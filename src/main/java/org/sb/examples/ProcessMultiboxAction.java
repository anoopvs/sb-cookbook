package org.sb.examples;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sb.examples.simple.MultiboxActionForm;
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

/**
 * Perform any tasks and setup any data that
 * must be prepared before the form is displayed.
 *
 * @version $Rev: 471754 $ $Date: 2006-11-06 08:55:09 -0600 (Mon, 06 Nov 2006) $
 */
@Controller
public class ProcessMultiboxAction extends Action {
	@Autowired
	private ActionHandler handler;
    // ------------------------------------------------------------ Constructors

    /**
     * Constructor for SuccessAction.
     */
    public ProcessMultiboxAction() {
        super();
    }
    
	
    @RequestMapping(path = "/processMultibox.do")
	public ModelAndView handlePrepareSimple(ActionMapping mapping,
			@ModelAttribute("multiboxForm") MultiboxActionForm form, BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		final ActionContext ctx = ActionContext.builder().withController(this).withExecuteFunction(this::execute)
				.withMapping(mapping).withForm(form).withMapping(mapping).withBindingResult(bindingResult).withHttpServletRequest(request)
				.withHttpServletResponse(response).build();
		ModelAndView mav= handler.handleActionExecution(ctx);
		return mav;
	}

    // ---------------------------------------------------------- Action Methods

    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {

        // If user pressed 'Cancel' button,
        // return to home page
        if (isCancelled(request)) {
            return mapping.findForward("home");
        }

        // Forward to result page
        return mapping.findForward("success");

        }

}
