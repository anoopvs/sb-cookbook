package org.sb.examples;

import java.util.Map;

import org.springbridge.action.ActionForward;
import org.springbridge.action.ActionMapping;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChainRedirectActionMappingConfig {
	
	
	@Bean("prepareRedirectChainAction")
	public ActionMapping prepareChainAction(@Qualifier("globalForwards") Map<String,ActionForward> globalForwards) {
		ActionMapping prepareSimpleMapping= new ActionMapping();
		prepareSimpleMapping.setPath("/initiateRedirectChain.do");
		prepareSimpleMapping.setType("org.sb.examples.ChainRedirectAction");
		prepareSimpleMapping.setGlobalForwards(globalForwards);
		prepareSimpleMapping.setValidate(false);
		prepareSimpleMapping.setCancellable(false);
		prepareSimpleMapping.addForward("one", new ActionForward("one", "/oneRedirect.do", true));
		return prepareSimpleMapping;
	}
	@Bean("prepareRedirectChainOneAction")
	public ActionMapping prepareChainOneAction(@Qualifier("globalForwards") Map<String,ActionForward> globalForwards) {
		ActionMapping prepareSimpleMapping= new ActionMapping();
		prepareSimpleMapping.setPath("/oneRedirect.do");
		prepareSimpleMapping.setType("org.sb.examples.ChainRedirectAction");
		prepareSimpleMapping.setGlobalForwards(globalForwards);
		prepareSimpleMapping.setValidate(false);
		prepareSimpleMapping.setCancellable(false);
		prepareSimpleMapping.addForward("two", new ActionForward("two", "/twoRedirect.do", true));
		return prepareSimpleMapping;
	}
	@Bean("prepareRedirectChainTwoAction")
	public ActionMapping prepareChainTwoAction(@Qualifier("globalForwards") Map<String,ActionForward> globalForwards) {
		ActionMapping prepareSimpleMapping= new ActionMapping();
		prepareSimpleMapping.setPath("/twoRedirect.do");
		prepareSimpleMapping.setType("org.sb.examples.ChainRedirectAction");
		prepareSimpleMapping.setGlobalForwards(globalForwards);
		prepareSimpleMapping.setValidate(false);
		prepareSimpleMapping.setCancellable(false);
		prepareSimpleMapping.addForward("three", new ActionForward("three", "/threeRedirect.do", true));
		return prepareSimpleMapping;
	}
	@Bean("prepareRedirectChainThreeAction")
	public ActionMapping prepareChainThreeAction(@Qualifier("globalForwards") Map<String,ActionForward> globalForwards) {
		ActionMapping prepareSimpleMapping= new ActionMapping();
		prepareSimpleMapping.setPath("/threeRedirect.do");
		prepareSimpleMapping.setType("org.sb.examples.ChainRedirectAction");
		prepareSimpleMapping.setGlobalForwards(globalForwards);
		prepareSimpleMapping.setValidate(false);
		prepareSimpleMapping.setCancellable(false);
		prepareSimpleMapping.addForward("success", new ActionForward("success", "/jsp/chainComplete.jsp", false));
		return prepareSimpleMapping;
	}
}
