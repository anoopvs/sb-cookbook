package org.sb.examples;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springbridge.action.ActionForward;
import org.springbridge.action.ActionMapping;
import org.springbridge.config.validation.impl.ActionMappingConfigValidator;

@Configuration
@Import(value= {SBConfig.class,ChainActionMappingConfig.class,ChainRedirectARActionMappingConfig.class,WildcardActionMappingConfig.class})
public class ActionMappingConfig {

	@Bean("globalForwards")
	public Map<String,ActionForward> globalForwards() {
		Map<String,ActionForward> globalForwards= new HashMap<>();
		globalForwards.put("home",new ActionForward("/Home.do"));
		return globalForwards;
	}
	
	@Bean("homeMapping")
	public ActionMapping homeMapping() {
		ActionMapping homeMapping= new ActionMapping();
		homeMapping.setPath("/Home.do");
		homeMapping.setInput("/WEB-INF/login/login.jsp");
		homeMapping.setType("org.sb.examples.SuccessAction");
		homeMapping.setGlobalForwards(globalForwards());
		homeMapping.setValidate(false);
		homeMapping.setRoles("ADMIN ,  CSR");
		//homeMapping.setRoles("UNKNOWN");
		homeMapping.addForward("success", new ActionForward("success", "/index.jsp", true));
		return homeMapping;
	}
	
	@Bean("generateExceptionActionMapping")
	public ActionMapping generateExceptionActionMapping() {
		ActionMapping generateExceptionActionMapping= new ActionMapping();
		generateExceptionActionMapping.setPath("/generateException.do");
		generateExceptionActionMapping.setType("org.sb.examples.UtilityAction");
		generateExceptionActionMapping.setGlobalForwards(globalForwards());
		return generateExceptionActionMapping;
	}
	
	@Bean("prepareSimpleMapping")
	public ActionMapping prepareSimpleMapping() {
		ActionMapping prepareSimpleMapping= new ActionMapping();
		prepareSimpleMapping.setPath("/prepareSimple.do");
		prepareSimpleMapping.setType("org.sb.examples.SuccessAction");
		prepareSimpleMapping.setGlobalForwards(globalForwards());
		prepareSimpleMapping.setValidate(false);
		prepareSimpleMapping.setCancellable(false);
		prepareSimpleMapping.addForward("success", new ActionForward("success", "/jsp/simple/Simple.jsp", false));
		return prepareSimpleMapping;
	}
	
	@Bean("prepareMultiboxMapping")
	public ActionMapping prepareMultiboxMapping() {
		ActionMapping prepareMultiboxMapping= new ActionMapping();
		prepareMultiboxMapping.setPath("/prepareMultibox.do");
		prepareMultiboxMapping.setType("org.sb.examples.PrepareMultiboxAction");
		prepareMultiboxMapping.setGlobalForwards(globalForwards());
		prepareMultiboxMapping.setValidate(false);
		prepareMultiboxMapping.setCancellable(false);
		prepareMultiboxMapping.setName("multiboxForm");
		prepareMultiboxMapping.addForward("success", new ActionForward("success", "/jsp/multibox/Multibox.jsp", false));
		return prepareMultiboxMapping;
	}
	
	@Bean("processSimpleMapping")
	public ActionMapping processSimpleMapping() {
		ActionMapping processSimpleMapping= new ActionMapping();
		processSimpleMapping.setPath("/processSimple.do");
		processSimpleMapping.setType("org.sb.examples.ProcessSimpleAction");
		processSimpleMapping.setName("simpleForm");
		processSimpleMapping.setGlobalForwards(globalForwards());
		processSimpleMapping.setValidate(true);
		processSimpleMapping.setCancellable(true);
		processSimpleMapping.addForward("success", new ActionForward("success", "/jsp/simple/SimpleResults.jsp"));
		return processSimpleMapping;
	}
	
	@Bean("prepareDynaMapping")
	public ActionMapping prepareDynaMapping() {
		ActionMapping prepareSimpleMapping= new ActionMapping();
		prepareSimpleMapping.setPath("/prepareDyna.do");
		prepareSimpleMapping.setType("org.sb.examples.SuccessAction");
		prepareSimpleMapping.setGlobalForwards(globalForwards());
		prepareSimpleMapping.setValidate(true);
		prepareSimpleMapping.setCancellable(false);
		prepareSimpleMapping.addForward("success", new ActionForward("success", "/jsp/simple/Dyna.jsp", false));
		return prepareSimpleMapping;
	}
	
	@Bean("prepareDynaOneMapping")
	public ActionMapping prepareDynaOneMapping() {
		ActionMapping prepareSimpleMapping= new ActionMapping();
		prepareSimpleMapping.setPath("/prepareDynaOne.do");
		prepareSimpleMapping.setType("org.sb.examples.DynaAction");
		prepareSimpleMapping.setGlobalForwards(globalForwards());
		prepareSimpleMapping.setValidate(false);
		prepareSimpleMapping.setCancellable(false);
		prepareSimpleMapping.addForward("success", new ActionForward("success", "/jsp/simple/Dyna.jsp", false));
		return prepareSimpleMapping;
	}
	
	
	@Bean("processDynaMapping")
	public ActionMapping processDynaMapping() {
		ActionMapping processDynaMapping= new ActionMapping();
		processDynaMapping.setPath("/processDyna.do");
		processDynaMapping.setType("org.sb.examples.ProcessDynaAction");
		processDynaMapping.setName("dynaForm");
		processDynaMapping.setGlobalForwards(globalForwards());
		processDynaMapping.setValidate(true);
		processDynaMapping.setCancellable(true);
		processDynaMapping.addForward("success", new ActionForward("success", "/jsp/simple/DynaResults.jsp"));
		return processDynaMapping;
	}
	@Bean("prepareOptionsMapping")
	public ActionMapping prepareOptionsMapping() {
		ActionMapping actionMapping= new ActionMapping();
		actionMapping.setPath("/prepareOptions.do");
		actionMapping.setType("org.sb.examples.PrepareOptionsAction");
		actionMapping.setGlobalForwards(globalForwards());
		actionMapping.setValidate(false);
		actionMapping.setCancellable(false);
		actionMapping.addForward("success", new ActionForward("success", "/jsp/options/Options.jsp"));
		return actionMapping;
	}
	
	@Bean("processOptionsMapping")
	public ActionMapping processOptionsMapping() {
		ActionMapping processOptionsMapping= new ActionMapping();
		processOptionsMapping.setPath("/processOptions.do");
		processOptionsMapping.setType("org.sb.examples.ProcessOptionsAction");
		processOptionsMapping.setName("optionsForm");
		processOptionsMapping.setGlobalForwards(globalForwards());
		processOptionsMapping.addForward("success", new ActionForward("success", "/jsp/options/OptionsResults.jsp"));
		return processOptionsMapping;
	}
	
	@Bean("processMultiboxMapping")
	public ActionMapping processMultiboxMapping() {
		ActionMapping processMultiboxMapping= new ActionMapping();
		processMultiboxMapping.setPath("/processMultibox.do");
		processMultiboxMapping.setType("org.sb.examples.ProcessMultiboxAction");
		processMultiboxMapping.setGlobalForwards(globalForwards());
		processMultiboxMapping.setValidate(false);
		processMultiboxMapping.setCancellable(true);
		processMultiboxMapping.setName("multiboxForm");
		processMultiboxMapping.addForward("success", new ActionForward("success", "/jsp/multibox/MultiboxResults.jsp"));
		return processMultiboxMapping;
	}
	
	@Bean("prepareMessagesMapping")
	public ActionMapping prepareMessagesMapping() {
		ActionMapping actionMapping= new ActionMapping();
		actionMapping.setPath("/prepareMessages.do");
		actionMapping.setType("org.sb.examples.SuccessAction");
		actionMapping.setGlobalForwards(globalForwards());
		actionMapping.setValidate(false);
		actionMapping.setCancellable(false);
		actionMapping.addForward("success", new ActionForward("success", "/jsp/messages/Messages.jsp"));
		return actionMapping;
	}
	
	@Bean("prepareValidatorMapping")
	public ActionMapping prepareValidatorMapping() {
		ActionMapping actionMapping= new ActionMapping();
		actionMapping.setPath("/prepareValidator.do");
		actionMapping.setType("org.sb.examples.SuccessAction");
		actionMapping.setGlobalForwards(globalForwards());
		actionMapping.setValidate(false);
		actionMapping.setCancellable(false);
		actionMapping.addForward("success", new ActionForward("success", "/jsp/validator/Validator.jsp"));
		return actionMapping;
	}
	
	@Bean("processValidatorMapping")
	public ActionMapping processValidatorMapping() {
		ActionMapping processValidatorMapping= new ActionMapping();
		processValidatorMapping.setPath("/processValidator.do");
		processValidatorMapping.setType("org.sb.examples.ProcessValidatorAction");
		processValidatorMapping.setInput("/jsp/validator/Validator.jsp");
		processValidatorMapping.setValidate(true);
		processValidatorMapping.setCancellable(true);
		processValidatorMapping.setName("validatorForm");
		processValidatorMapping.setProperty("actionId", "validatorAction");
		processValidatorMapping.setName("validatorForm");
		processValidatorMapping.setGlobalForwards(globalForwards());
		processValidatorMapping.addForward("success", new ActionForward("success", "/jsp/options/OptionsResults.jsp"));
		return processValidatorMapping;
	}
	
	@Bean("prepareTokenMapping")
	public ActionMapping prepareTokenMapping() {
		ActionMapping prepareTokenMapping= new ActionMapping();
		prepareTokenMapping.setPath("/prepareToken.do");
		prepareTokenMapping.setType("org.sb.examples.PrepareTokenAction");
		prepareTokenMapping.setValidate(false);
		prepareTokenMapping.setGlobalForwards(globalForwards());
		prepareTokenMapping.addForward("success", new ActionForward("success", "/jsp/token/Token.jsp"));
		return prepareTokenMapping;
	}
	
	@Bean("processTokenMapping")
	public ActionMapping processTokenMapping() {
		ActionMapping processTokenMapping= new ActionMapping();
		processTokenMapping.setPath("/processToken.do");
		processTokenMapping.setType("org.sb.examples.ProcessTokenAction");
		processTokenMapping.setName("testForm");
		processTokenMapping.setInput("/jsp/token/Token.jsp");
		processTokenMapping.setValidate(false);
		processTokenMapping.setName("testForm");
		processTokenMapping.setGlobalForwards(globalForwards());
		processTokenMapping.addForward("success", new ActionForward("success", "/jsp/token/TokenResults.jsp"));
		return processTokenMapping;
	}
	
	@Bean("processLocalizationMapping")
	public ActionMapping processLocalizationMapping() {
		ActionMapping processLocalizationMapping= new ActionMapping();
		processLocalizationMapping.setPath("/processLocalization.do");
		processLocalizationMapping.setType("org.sb.examples.ProcessLocalizationAction");
		processLocalizationMapping.setInput("/jsp/localization/Localization.jsp");
		processLocalizationMapping.setValidate(false);
		processLocalizationMapping.setGlobalForwards(globalForwards());
		processLocalizationMapping.addForward("success", new ActionForward("success", "/jsp/localization/Localization.jsp"));
		return processLocalizationMapping;
	}
	
	@Bean("processLocalizationActionMapping")
	public ActionMapping processLocalizationActionMapping() {
		ActionMapping processLocalizationMapping= new ActionMapping();
		processLocalizationMapping.setPath("/changeLocale.do");
		processLocalizationMapping.setType("org.sb.examples.ChangeLocaleAction");
		processLocalizationMapping.setInput("/jsp/localization/ChangeLocale.jsp");
		processLocalizationMapping.setValidate(false);
		processLocalizationMapping.setGlobalForwards(globalForwards());
		processLocalizationMapping.addForward("success", new ActionForward("success", "/jsp/localization/ChangeLocale.jsp"));
		return processLocalizationMapping;
	}
	
	@Bean("prepareLocalizationMapping")
	public ActionMapping prepareLocalizationMapping() {
		ActionMapping prepareTokenMapping= new ActionMapping();
		prepareTokenMapping.setPath("/prepareLocalization.do");
		prepareTokenMapping.setType("org.sb.examples.SuccessAction");
		prepareTokenMapping.setValidate(false);
		prepareTokenMapping.setGlobalForwards(globalForwards());
		prepareTokenMapping.addForward("success", new ActionForward("success", "/jsp/localization/Localization.jsp"));
		return prepareTokenMapping;
	}
	
	@Bean("actionMappingConfigValidator")
	public ActionMappingConfigValidator actionMappingConfigValidator() {
		ActionMappingConfigValidator cfv= new ActionMappingConfigValidator();
		cfv.setValidateCommonAttributes(false);
		return cfv;
	}
	
	@Bean("userActionMapping")
	public ActionMapping userActionMapping() {
		ActionMapping actionMapping= new ActionMapping();
		actionMapping.setPath("/UserAction.do");
		actionMapping.setType("org.sb.examples.UserAction");
		actionMapping.setGlobalForwards(globalForwards());
		actionMapping.setValidate(false);
		actionMapping.setCancellable(false);
		actionMapping.setParameter("method");
		actionMapping.setName("name");
		actionMapping.addForward("success", new ActionForward("success", "/jsp/dispatch-action/result.jsp"));
		return actionMapping;
	}
	
	public static void main(String... args) {
		ActionMappingConfig config= new ActionMappingConfig();
		ActionMapping am= config.processTokenMapping();
		am.setBeanName("chkConfig");
		try {
			am.afterPropertiesSet();
			System.out.println(am.getFormBeanClass());
		} catch (Exception e) {
			e.printStackTrace();
		}
		am.setFormBeanType("org.sb.examples.simple.TestForm");
		System.out.println(am.getFormBeanClass());
	}
}
