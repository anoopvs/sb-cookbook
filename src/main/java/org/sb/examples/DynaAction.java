package org.sb.examples;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springbridge.action.Action;
import org.springbridge.action.ActionForm;
import org.springbridge.action.ActionForward;
import org.springbridge.action.ActionMapping;
import org.springbridge.action.DynaActionForm;
import org.springbridge.support.annotation.ActionMappingConfig;
import org.springbridge.support.handler.ActionContext;
import org.springbridge.support.handler.ActionHandler;
import org.springbridge.utils.ModelAttributeUtils;

@Controller
public class DynaAction extends Action {
	@Autowired
	private ActionHandler handler;
	// ------------------------------------------------------------ Constructors

	/**
	 * Constructor for SuccessAction.
	 */
	public DynaAction() {
		super();
	}

	@ModelAttribute("dynaForm")
	public ActionForm dynaForm() {
		return ModelAttributeUtils.lookupOrCreateModelAttribute("org.sb.examples.simple.dyna.DynaForm");
	}
	//Dummy wrong method to test Annotation processor
	
//	public ModelAndView handleUnknownPrepareDyna(ActionMapping mapping, @ModelAttribute("dynaForm") ActionForm form,
//			@ActionMappingConfig("wrongMapping") BindingResult bindingResult, HttpServletRequest request,
//			HttpServletResponse response) {
//		final ActionContext ctx = ActionContext.builder().withController(this).withExecuteFunction(this::execute)
//				.withMapping(mapping).withHttpServletRequest(request).withHttpServletResponse(response).build();
//		ModelAndView mav = handler.handleActionExecution(ctx);
//		DynaActionForm simpleForm = (DynaActionForm) form;
//		simpleForm.set("hidden", "Sssh! It's a New secret. Nobody knows I'm here.");
//		return mav;
//	}

	@RequestMapping(path = "/prepareDynaOne.do")
	public ModelAndView handlePrepareDyna(@ActionMappingConfig("prepareDynaOneMapping") ActionMapping mapping,
			@ModelAttribute("dynaForm") ActionForm form, BindingResult bindingResult,HttpServletRequest request,
			HttpServletResponse response) {
		final ActionContext ctx = ActionContext.builder().withController(this).withExecuteFunction(this::execute)
				.withMapping(mapping).withHttpServletRequest(request).withHttpServletResponse(response).build();
		ModelAndView mav = handler.handleActionExecution(ctx);
		DynaActionForm simpleForm = (DynaActionForm) form;
		simpleForm.set("hidden", "Sssh! It's a New secret. Nobody knows I'm here.");
		return mav;
	}
	// ---------------------------------------------------------- Action Methods

	/**
	 * Returns the <code>ActionForward</code> named "success" if one is configured
	 * or <code>null</code>if it cannot be found.
	 *
	 * Searches first for a local forward, then a global forward.
	 *
	 * @param mapping  The ActionMapping used to select this instance
	 * @param form     The optional ActionForm bean for this request (if any)
	 * @param request  The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 *
	 * @exception Exception if mapping.findForward throws an Exception
	 *
	 * @return the "success" ActionForward, or null if it cannot be found
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		saveToken(request);
		return mapping.findForward("success");
	}

}
