package org.sb.examples;

import java.util.Map;

import org.springbridge.action.ActionForward;
import org.springbridge.action.ActionMapping;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChainRedirectARActionMappingConfig {
	
	
	@Bean("prepareARedirectChainAction")
	public ActionMapping prepareChainAction(@Qualifier("globalForwards") Map<String,ActionForward> globalForwards) {
		ActionMapping prepareSimpleMapping= new ActionMapping();
		prepareSimpleMapping.setPath("/initiateARedirectChain.do");
		prepareSimpleMapping.setType("org.sb.examples.ChainRedirectARAction");
		prepareSimpleMapping.setGlobalForwards(globalForwards);
		prepareSimpleMapping.setValidate(false);
		prepareSimpleMapping.setCancellable(false);
		return prepareSimpleMapping;
	}
	@Bean("prepareARedirectChainOneAction")
	public ActionMapping prepareChainOneAction(@Qualifier("globalForwards") Map<String,ActionForward> globalForwards) {
		ActionMapping prepareSimpleMapping= new ActionMapping();
		prepareSimpleMapping.setPath("/oneARedirect.do");
		prepareSimpleMapping.setType("org.sb.examples.ChainRedirectARAction");
		prepareSimpleMapping.setGlobalForwards(globalForwards);
		prepareSimpleMapping.setValidate(false);
		prepareSimpleMapping.setCancellable(false);
		return prepareSimpleMapping;
	}
	@Bean("prepareARedirectChainTwoAction")
	public ActionMapping prepareChainTwoAction(@Qualifier("globalForwards") Map<String,ActionForward> globalForwards) {
		ActionMapping prepareSimpleMapping= new ActionMapping();
		prepareSimpleMapping.setPath("/twoARedirect.do");
		prepareSimpleMapping.setType("org.sb.examples.ChainRedirectARAction");
		prepareSimpleMapping.setGlobalForwards(globalForwards);
		prepareSimpleMapping.setValidate(false);
		prepareSimpleMapping.setCancellable(false);
		return prepareSimpleMapping;
	}
	@Bean("prepareARedirectChainThreeAction")
	public ActionMapping prepareChainThreeAction(@Qualifier("globalForwards") Map<String,ActionForward> globalForwards) {
		ActionMapping prepareSimpleMapping= new ActionMapping();
		prepareSimpleMapping.setPath("/threeARedirect.do");
		prepareSimpleMapping.setType("org.sb.examples.ChainRedirectAction");
		prepareSimpleMapping.setGlobalForwards(globalForwards);
		prepareSimpleMapping.setValidate(false);
		prepareSimpleMapping.setCancellable(false);
		prepareSimpleMapping.addForward("success", new ActionForward("success", "/jsp/chainARComplete.jsp", false));
		return prepareSimpleMapping;
	}
}
