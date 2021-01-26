package org.sb.examples;

import java.util.Map;

import org.springbridge.action.ActionForward;
import org.springbridge.action.ActionMapping;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChainActionMappingConfig {
	
	
	@Bean("prepareChainAction")
	public ActionMapping prepareChainAction(@Qualifier("globalForwards") Map<String,ActionForward> globalForwards) {
		ActionMapping prepareSimpleMapping= new ActionMapping();
		prepareSimpleMapping.setPath("/initiateChain.do");
		prepareSimpleMapping.setType("org.sb.examples.ChainAction");
		prepareSimpleMapping.setGlobalForwards(globalForwards);
		prepareSimpleMapping.setValidate(false);
		prepareSimpleMapping.setCancellable(false);
		prepareSimpleMapping.addForward("one", new ActionForward("one", "/one.do", false));
		return prepareSimpleMapping;
	}
	@Bean("prepareChainOneAction")
	public ActionMapping prepareChainOneAction(@Qualifier("globalForwards") Map<String,ActionForward> globalForwards) {
		ActionMapping prepareSimpleMapping= new ActionMapping();
		prepareSimpleMapping.setPath("/one.do");
		prepareSimpleMapping.setType("org.sb.examples.ChainAction");
		prepareSimpleMapping.setGlobalForwards(globalForwards);
		prepareSimpleMapping.setValidate(false);
		prepareSimpleMapping.setCancellable(false);
		prepareSimpleMapping.addForward("two", new ActionForward("two", "/two.do", false));
		return prepareSimpleMapping;
	}
	@Bean("prepareChainTwoAction")
	public ActionMapping prepareChainTwoAction(@Qualifier("globalForwards") Map<String,ActionForward> globalForwards) {
		ActionMapping prepareSimpleMapping= new ActionMapping();
		prepareSimpleMapping.setPath("/two.do");
		prepareSimpleMapping.setType("org.sb.examples.ChainAction");
		prepareSimpleMapping.setGlobalForwards(globalForwards);
		prepareSimpleMapping.setValidate(false);
		prepareSimpleMapping.setCancellable(false);
		prepareSimpleMapping.addForward("three", new ActionForward("three", "/three.do", false));
		return prepareSimpleMapping;
	}
	@Bean("prepareChainThreeAction")
	public ActionMapping prepareChainThreeAction(@Qualifier("globalForwards") Map<String,ActionForward> globalForwards) {
		ActionMapping prepareSimpleMapping= new ActionMapping();
		prepareSimpleMapping.setPath("/three.do");
		prepareSimpleMapping.setType("org.sb.examples.ChainAction");
		prepareSimpleMapping.setGlobalForwards(globalForwards);
		prepareSimpleMapping.setValidate(false);
		prepareSimpleMapping.setCancellable(false);
		prepareSimpleMapping.addForward("success", new ActionForward("success", "/jsp/chainComplete.jsp", false));
		return prepareSimpleMapping;
	}
}
