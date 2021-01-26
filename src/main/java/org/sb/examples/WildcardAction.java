package org.sb.examples;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springbridge.action.Action;
import org.springbridge.action.ActionForm;
import org.springbridge.action.ActionForward;
import org.springbridge.action.ActionMapping;
import org.springbridge.support.handler.ActionContext;
import org.springbridge.support.handler.ActionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Perform any tasks and setup any data that must be prepared before the form is
 * displayed.
 *
 * @version $Rev: 471754 $ $Date: 2006-11-06 08:55:09 -0600 (Mon, 06 Nov 2006) $
 */
@Controller
public class WildcardAction extends Action {
	@Autowired
	private ActionHandler handler;
	// ------------------------------------------------------------ Constructors

	/**
	 * Constructor for PrepareOptionsAction.
	 */
	public WildcardAction() {
		super();
	}

	@RequestMapping(path = { "/Prepare*.do","/Source*.do","/Wildcard*.do" })
	public ModelAndView handlePrepareSimple(ActionMapping mapping,
			 HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("From handlePrepareSimple");
		String bestMatchingPattern=(String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
		System.out.println("bestMatchingPattern::"+bestMatchingPattern);
		PathMatcher pathMatcher = new AntPathMatcher();
		String matcherPath=pathMatcher.extractPathWithinPattern(bestMatchingPattern,request.getServletPath());
		System.out.println("matcherPath::"+matcherPath);
		final Enumeration<String> attrNames=request.getAttributeNames();
		while(attrNames.hasMoreElements()){
			String attrName=attrNames.nextElement();
			System.out.println(attrName+"::"+request.getAttribute(attrName));
		}
		final ActionContext ctx = ActionContext.builder().withController(this).withExecuteFunction(this::execute)
				.withMapping(mapping).withHttpServletRequest(request)
				.withHttpServletResponse(response).build();
		return handler.handleActionExecution(ctx);
	}
	
	@RequestMapping(path = { "/PrepareOne.do"})
	public ModelAndView handlePrepareOne(ActionMapping mapping,
			 HttpServletRequest request,
			HttpServletResponse response) {
		System.err.println("From handlePrepareOne");
		final ActionContext ctx = ActionContext.builder().withController(this).withExecuteFunction(this::execute)
				.withMapping(mapping).withHttpServletRequest(request)
				.withHttpServletResponse(response).build();
		return handler.handleActionExecution(ctx);
	}
	
    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {
    	return new ActionForward(mapping.getForward());
    }
}
