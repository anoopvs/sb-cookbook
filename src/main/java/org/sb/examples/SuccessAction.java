package org.sb.examples;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sb.examples.simple.SimpleActionForm;
import org.sb.examples.simple.ValidatorForm;
import org.sb.examples.simple.dyna.DynaForm;
import org.springbridge.action.Action;
import org.springbridge.action.ActionForm;
import org.springbridge.action.ActionForward;
import org.springbridge.action.ActionMapping;
import org.springbridge.support.handler.ActionContext;
import org.springbridge.support.handler.ActionHandler;
import org.springbridge.utils.ModelAttributeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>An Action that forwards control via a "success" ActionFoward.</p>
 *
 * <p>A recommended strategy is that view pages should link only to Actions and
 * never directly to other views. In situations where the view does not require
 * any preparation you can use a SuccessAction, specifying the view as an
 * ActionForward named "success" in your action mapping.</p>
 *
 * <p>e.g. If you configure an ActionMapping in struts-config.xml like this:</p>
 *
 * <pre>
 *    &lt;action path="/prepareView"
 *            type="examples.SuccessAction"&gt;
 *        &lt;forward name="success" path="/jsp/View.jsp"/&gt;
 *    &lt/action&gt;
 * </pre>
 *
 * <p>You could create a link to the view (via the Action) as follows:</p>
 *
 * <pre>
 *     &lt;html:link action="/prepareView"&gt;Display 'view' page&lt;/html:link&gt;
 * </pre>
 *
 * <p>If you later change your application such that the view page requires some
 * initialization you can change a single ActionMapping definition in
 * struts-config.xml rather than lots of link definitions in many JSPs.</p>
 *
 * @version $Rev: 471754 $ $Date: 2006-11-06 08:55:09 -0600 (Mon, 06 Nov 2006) $
 */
@Controller
public class SuccessAction extends Action {
	@Autowired
	private ActionHandler handler;
    // ------------------------------------------------------------ Constructors

    /**
     * Constructor for SuccessAction.
     */
    public SuccessAction() {
        super();
    }
    
    @RequestMapping(path = "/Home.do")
	public ModelAndView handleLoginRequest(ActionMapping mapping,
			HttpServletRequest request,
			HttpServletResponse response) {
		final ActionContext ctx = ActionContext.builder().withController(this).withExecuteFunction(this::execute)
				.withMapping(mapping).withHttpServletRequest(request)
				.withHttpServletResponse(response).build();
		ModelAndView mav= handler.handleActionExecution(ctx);
		return mav;
	}
	@ModelAttribute("simpleForm")
	public ActionForm loginForm() {
		return ModelAttributeUtils.lookupOrCreateModelAttribute("org.sb.examples.simple.SimpleActionForm");
	}
	
    @RequestMapping(path = "/prepareSimple.do")
	public ModelAndView handlePrepareSimple(ActionMapping mapping,
			@ModelAttribute("simpleForm") ActionForm form, BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		final ActionContext ctx = ActionContext.builder().withController(this).withExecuteFunction(this::execute)
				.withMapping(mapping).withMapping(mapping).withHttpServletRequest(request)
				.withHttpServletResponse(response).build();
		ModelAndView mav= handler.handleActionExecution(ctx);
		SimpleActionForm simpleForm=(SimpleActionForm) form;
		simpleForm.setHidden("Sssh! It's a secret. Nobody knows I'm here.");
		return mav;
	}
    
	@ModelAttribute("dynaForm")
	public DynaForm dynaForm() {
		return ModelAttributeUtils.lookupOrCreateModelAttribute(DynaForm.class);
	}
	
    @RequestMapping(path = "/prepareDyna.do")
	public ModelAndView handlePrepareDyna(ActionMapping mapping,
			@ModelAttribute("dynaForm") ActionForm form, BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		final ActionContext ctx = ActionContext.builder().withController(this).withExecuteFunction(this::execute)
				.withMapping(mapping).withMapping(mapping).withHttpServletRequest(request)
				.withHttpServletResponse(response).build();
		ModelAndView mav= handler.handleActionExecution(ctx);
		DynaForm simpleForm=(DynaForm) form;
		simpleForm.set("hidden","Sssh! It's a secret. Nobody knows I'm here.");
		return mav;
	}
    
    @RequestMapping(path = "/prepareMessages.do")
	public ModelAndView handlePrepareMessages(ActionMapping mapping,
			HttpServletRequest request,
			HttpServletResponse response) {
		final ActionContext ctx = ActionContext.builder().withController(this).withExecuteFunction(this::execute)
				.withMapping(mapping).withHttpServletRequest(request)
				.withHttpServletResponse(response).build();
		ModelAndView mav= handler.handleActionExecution(ctx);
		return mav;
	}
    
    @RequestMapping(path = "/prepareLocalization.do")
	public ModelAndView handlePrepareLocalization(ActionMapping mapping,
			HttpServletRequest request,
			HttpServletResponse response) {
		final ActionContext ctx = ActionContext.builder().withController(this).withExecuteFunction(this::execute)
				.withMapping(mapping).withHttpServletRequest(request)
				.withHttpServletResponse(response).build();
		ModelAndView mav= handler.handleActionExecution(ctx);
		return mav;
	}
    
	@ModelAttribute("validatorForm")
	public ValidatorForm validatorForm() {
		return ModelAttributeUtils.lookupOrCreateModelAttribute(ValidatorForm.class);
	}
	
    @RequestMapping(path = "/prepareValidator.do")
	public ModelAndView handlePrepareValidator(ActionMapping mapping,
			HttpServletRequest request,
			HttpServletResponse response) {
		final ActionContext ctx = ActionContext.builder().withController(this).withExecuteFunction(this::execute)
				.withMapping(mapping).withHttpServletRequest(request)
				.withHttpServletResponse(response).build();
		ModelAndView mav= handler.handleActionExecution(ctx);
		return mav;
	}
    // ---------------------------------------------------------- Action Methods

    /**
     * Returns the <code>ActionForward</code> named "success" if one is
     * configured or <code>null</code>if it cannot be found.
     *
     * Searches first for a local forward, then a global forward.
     *
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if mapping.findForward throws an Exception
     *
     * @return the "success" ActionForward, or null if it cannot be found
     */
    public ActionForward execute(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response)
        throws Exception {
    	saveToken(request);
        return mapping.findForward("success");
    }

}
