package org.sb.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;

import org.sb.examples.exceptions.NotPrivilegedException;
import org.springbridge.support.ActionMappingInstanceLocator;
import org.springbridge.support.DefaultModelAndViewGenerator;
import org.springbridge.support.ModelAndViewGenerator;
import org.springbridge.support.RequestAttributeActionMappingInstanceLocator;
import org.springbridge.support.handler.DefaultActionHandler;
import org.springbridge.support.handler.ExceptionHandler;
import org.springbridge.support.utils.MessageResources;
import org.springbridge.utils.ApplicationContextUtils;
import org.springbridge.validation.ActionFormValidator;
import org.springbridge.validation.CustomBeanValidator;
import org.springbridge.validation.impl.CompositeValidator;
import org.springbridge.validation.impl.DefaultActionFormValidator;
import org.springbridge.validation.impl.JSR303BasedActionFormValidator;
import org.springbridge.validation.impl.SpringCommonsActionFormValidator;
import org.springbridge.web.method.support.ActionMappingConfigMethodProcessor;
import org.springbridge.web.method.support.CustomModelAttributeMethodProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.context.support.ServletContextResourcePatternResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springmodules.validation.commons.DefaultValidatorFactory;

import examples.exceptionhandler.IllegalAccessExceptionHandler;
import examples.exceptionhandler.IllegalStateExceptionHandler;
import examples.exceptionhandler.NotPrivilegedExceptionHandler;
@PropertySource(value="classpath:org/sb/resources/sb.properties")
@EnableWebMvc
public class SBConfig {

	@Bean
	public ActionMappingConfigMethodProcessor actionMappingConfigMethodProcessor(ApplicationContext ctx) {
		ActionMappingConfigMethodProcessor methodProcessor= new ActionMappingConfigMethodProcessor(ctx);
		return methodProcessor;
	}
	
	@Bean
	public CustomModelAttributeMethodProcessor customModelAttributeMethodProcessor(ApplicationContext ctx) {
		CustomModelAttributeMethodProcessor methodProcessor= new CustomModelAttributeMethodProcessor(ctx);
		methodProcessor.setConvertNullToDefaultValue(true);
		return methodProcessor;
	}
	
	@Bean("#sb_config_method_processor")
	public String dummyBean(ApplicationContext ctx,RequestMappingHandlerAdapter adapter ,CustomModelAttributeMethodProcessor cmProcessor) {
		//CustomModelAttributeMethodProcessor cmProcessor= customModelAttributeMethodProcessor(false,ctx);
		//cmProcessor.setConvertNullToDefaultValue(true);
		final List<HandlerMethodArgumentResolver> resolvers=new ArrayList<>(adapter.getArgumentResolvers());
		resolvers.add(0,cmProcessor);
		adapter.setArgumentResolvers(resolvers);
		System.err.println("__________________________________________");
		adapter.getArgumentResolvers().forEach(System.err::println);
		System.err.println("__________________________________________");
		System.err.println("Updated sb_config_method_processor bean created !!!!");
		return "OK";
	}
	
	/*@Bean("#sb_config_method_processor")
	public String dummyBean(ApplicationContext ctx,RequestMappingHandlerAdapter adapter) {
		CustomModelAttributeMethodProcessor cmProcessor= customModelAttributeMethodProcessor(true,ctx);
		cmProcessor.setConvertNullToDefaultValue(true);
//		ActionMappingConfigMethodProcessor amProcessor=actionMappingConfigMethodProcessor(ctx);
		List<HandlerMethodArgumentResolver> resolvers=new ArrayList<>(adapter.getArgumentResolvers());
//		resolvers.add(0,amProcessor);
		resolvers.add(0,cmProcessor);
		cmProcessor= customModelAttributeMethodProcessor(false,ctx);
		cmProcessor.setConvertNullToDefaultValue(true);
		resolvers.add(0,cmProcessor);
		adapter.setArgumentResolvers(resolvers);
		System.err.println("__________________________________________");
		adapter.getArgumentResolvers().forEach(System.err::println);
		System.err.println("__________________________________________");
		System.err.println("Updated sb_config_method_processor bean created !!!!");
		return "OK";
	}
	*/
	@Bean
	public MessageResources messageResources (final ApplicationContext ctx) {
		return  new MessageResources(ctx);
	}
	
	@Bean
	public ActionMappingInstanceLocator actionMappingResolver() {
		return new RequestAttributeActionMappingInstanceLocator();
	}
	
	@Bean
	public static ApplicationContextUtils applicationContextUtils() {
		return new ApplicationContextUtils();
	}
	
	@Bean
	public ActionFormValidator actionFormValidator(MessageResources messageResources) {
		ActionFormValidator actionFormValidator= new CompositeValidator();
		return actionFormValidator;
	}
	
	@Bean
	public DefaultActionHandler defaultActionHandler(CustomBeanValidator beanValidator,MessageResources messageResources) {
		Logger.getGlobal().setLevel(Level.FINEST);
		DefaultActionHandler defaultActionHandler= new DefaultActionHandler();
		List<ActionFormValidator> validators= new ArrayList<>();
		validators.add(new DefaultActionFormValidator());
		validators.add(jsr303BasedActionFormValidator(messageResources));
		System.out.println(">>>getMessageResources"+messageResources);
		validators.add(new SpringCommonsActionFormValidator(beanValidator,messageResources));
		CompositeValidator compositeValidator = new CompositeValidator();
		compositeValidator.setValidators(validators);
		compositeValidator.afterPropertiesSet();
		compositeValidator.setValidators(validators);
		defaultActionHandler.setCompositeValidator(compositeValidator);
		Map<String, List<Supplier<String>>> globalResponseHeaderSuppliers= new HashMap<>();
		globalResponseHeaderSuppliers.computeIfAbsent("X-GUID", k-> new ArrayList<Supplier<String>>()).add(this::getUUID);
		globalResponseHeaderSuppliers.computeIfAbsent("X-EXEC-TIME", k-> new ArrayList<Supplier<String>>()).add(new ExecTimeTracker());
		defaultActionHandler.setPublishEvents(true);
		defaultActionHandler.setExposeErrorRequestAttributes(false);
		defaultActionHandler.setGlobalResponseHeaderSuppliers(globalResponseHeaderSuppliers);
		return defaultActionHandler;
	}
	
	private String getUUID() {
		return UUID.randomUUID().toString();
	}
	
	@Bean
	public JSR303BasedActionFormValidator jsr303BasedActionFormValidator(MessageResources messageResources) {
		LocalValidatorFactoryBean validatorFactory = new LocalValidatorFactoryBean();
		validatorFactory.afterPropertiesSet();
		JSR303BasedActionFormValidator validator= new JSR303BasedActionFormValidator(validatorFactory,messageResources);
		return validator;
	}
	
	@Bean
	public ResourceLoader getSBWebAppResourceLoader(ServletContext sc) {
		ServletContextResourcePatternResolver resourceLoader = new ServletContextResourcePatternResolver(sc);
		return resourceLoader;
	}
	
	@Bean
	public DefaultValidatorFactory defaultValidatorFactory(MessageResources messageResources,ResourceLoader resourceLoader) {
		DefaultValidatorFactory validatorFactory = new DefaultValidatorFactory();
		List<Resource> xmlResource= new ArrayList<>();
		//ServletContextResourcePatternResolver resourceLoader = (ServletContextResourcePatternResolver) sbWebAppResourceLoader;
		xmlResource.add(resourceLoader.getResource("/WEB-INF/validation.xml"));
		xmlResource.add(resourceLoader.getResource("/WEB-INF/validator-rules.xml"));
		System.out.println("Got Validation XMLs"+xmlResource);
		validatorFactory.setValidationConfigLocations(xmlResource.toArray(new Resource[0]));
		return validatorFactory;
	}
	
	
	
	@Bean
	public CustomBeanValidator customBeanValidator(DefaultValidatorFactory validatorFactory) {
		CustomBeanValidator beanValidator= new CustomBeanValidator();
		beanValidator.setValidatorFactory(validatorFactory);
		return beanValidator;
	}
	
	@Bean
	public ModelAndViewGenerator modelAndViewGenerator() {
		ModelAndViewGenerator modelAndViewGenerator= new DefaultModelAndViewGenerator();
		return modelAndViewGenerator;
	}
	// ExceptionHandler beans
	@Bean
	public ExceptionHandler notPrivilegedExceptionHandler() {
		NotPrivilegedExceptionHandler exceptionHandler= new NotPrivilegedExceptionHandler();
		exceptionHandler.setExceptionClasses(Arrays.asList(NotPrivilegedException.class));
		return exceptionHandler;
	}
	@Bean
	public ExceptionHandler illegalAccessExceptionHandler() {
		IllegalAccessExceptionHandler exceptionHandler= new IllegalAccessExceptionHandler();
		exceptionHandler.setExceptionClasses(Arrays.asList(IllegalAccessException.class));
		return exceptionHandler;
	}
	@Bean
	public ExceptionHandler illegalStateExceptionHandler() {
		IllegalStateExceptionHandler exceptionHandler= new IllegalStateExceptionHandler();
		exceptionHandler.setExceptionClasses(Arrays.asList(IllegalStateException.class,SecurityException.class));
		return exceptionHandler;
	}
	// ExceptionHandler beans
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
//	    return new PropertySourcesPlaceholderConfigurer();
//	}
}
