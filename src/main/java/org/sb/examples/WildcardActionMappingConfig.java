package org.sb.examples;

import java.util.Map;

import org.springbridge.action.ActionForward;
import org.springbridge.action.ActionMapping;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class WildcardActionMappingConfig {
	
	
	@Bean("prepareWildcardAction")
	public ActionMapping prepareWildcardAction(@Qualifier("globalForwards") Map<String,ActionForward> globalForwards) {
		ActionMapping prepareSimpleMapping= new ActionMapping();
		prepareSimpleMapping.setPath("/Prepare*.do");
		prepareSimpleMapping.setForward("/jsp/Wildcard/{1}.jsp");
		prepareSimpleMapping.setGlobalForwards(globalForwards);
		return prepareSimpleMapping;
	}
	@Bean("prepareSourceAction")
	public ActionMapping prepareSourceAction(@Qualifier("globalForwards") Map<String,ActionForward> globalForwards) {
		ActionMapping prepareSimpleMapping= new ActionMapping();
		prepareSimpleMapping.setPath("/Source*.do");
		prepareSimpleMapping.setForward("/jsp/{1}/Source.jsp");
		prepareSimpleMapping.setGlobalForwards(globalForwards);
		return prepareSimpleMapping;
	}
	@Bean("prepareMatchAnyAction")
	public ActionMapping prepareMatchAnyAction(@Qualifier("globalForwards") Map<String,ActionForward> globalForwards) {
		ActionMapping prepareSimpleMapping= new ActionMapping();
		prepareSimpleMapping.setPath("/Wildcard*.do");
		prepareSimpleMapping.setForward("/jsp/Wildcard/MatchAny.jsp");
		prepareSimpleMapping.setGlobalForwards(globalForwards);
		return prepareSimpleMapping;
	}
	
	@Bean("prepareOneAction")
	public ActionMapping prepareOneAction(@Qualifier("globalForwards") Map<String,ActionForward> globalForwards) {
		ActionMapping prepareSimpleMapping= new ActionMapping();
		prepareSimpleMapping.setPath("/PrepareOne.do");
		prepareSimpleMapping.setForward("/jsp/Wildcard/PrepareOne.jsp");
		prepareSimpleMapping.setGlobalForwards(globalForwards);
		return prepareSimpleMapping;
	}
}
