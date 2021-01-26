package org.sb.examples;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sb.examples.simple.ValidatorForm;
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
import org.springbridge.support.handler.ActionContext;
import org.springbridge.support.handler.ActionHandler;
import org.springbridge.utils.ModelAttributeUtils;

/**
 * Retrieve and process data from the submitted form
 *
 * @version $Rev: 471754 $ $Date: 2006-11-06 08:55:09 -0600 (Mon, 06 Nov 2006) $
 */
@Controller
public class ProcessValidatorAction extends Action {
	@Autowired
	private ActionHandler handler;
    // ------------------------------------------------------------ Constructors

    /**
     * Constructor for ProcessOptionsAction.
     */
    public ProcessValidatorAction() {
        super();
    }
	@ModelAttribute("validatorForm")
	public ValidatorForm validatorForm() {
		return ModelAttributeUtils.lookupOrCreateModelAttribute(ValidatorForm.class);
	}
    @RequestMapping(path = "/processValidator.do")
	public ModelAndView handlePrepareSimple(ActionMapping mapping,
			@ModelAttribute("validatorForm") ValidatorForm form, BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		final ActionContext ctx = ActionContext.builder().withController(this).withExecuteFunction(this::execute)
				.withMapping(mapping).withForm(form).withMapping(mapping).withBindingResult(bindingResult).withHttpServletRequest(request)
				.withHttpServletResponse(response).build();
		ModelAndView mav= handler.handleActionExecution(ctx);
		return mav;
	}
    // ---------------------------------------------------------- Action Methods

    /**
     * Process the request and return an <code>ActionForward</code> instance
     * describing where and how control should be forwarded, or
     * <code>null</code>if the response has already been completed.
     *
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if the application logic throws an exception
     *
     * @return the ActionForward for the next view
     */
    public ActionForward execute(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response)
        throws Exception {
    	System.out.println("ActionForm::"+form);
        // If user pressed 'Cancel' button,
        // return to home page
        if (isCancelled(request)) {
            return mapping.findForward("home");
        }

        // Forward to result page
        return mapping.findForward("success");
    }

}
