package org.sb.examples;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sb.examples.simple.TestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springbridge.action.Action;
import org.springbridge.action.ActionErrors;
import org.springbridge.action.ActionForm;
import org.springbridge.action.ActionForward;
import org.springbridge.action.ActionMapping;
import org.springbridge.action.ActionMessage;
import org.springbridge.action.ActionMessages;
import org.springbridge.support.handler.ActionContext;
import org.springbridge.support.handler.ActionHandler;
import org.springbridge.utils.ModelAttributeUtils;
/**
 * Retrieve and process data from the submitted form
 *
 * @version $Rev: 471754 $ $Date: 2006-11-06 08:55:09 -0600 (Mon, 06 Nov 2006) $
 */
@Controller
public class ProcessTokenAction extends Action {
	@Autowired
	private ActionHandler handler;
    // ------------------------------------------------------------ Constructors

    /**
     * Constructor for ProcessOptionsAction.
     */
    public ProcessTokenAction() {
        super();
    }
	@ModelAttribute("testForm")
	public TestForm testForm() {
		return ModelAttributeUtils.lookupOrCreateModelAttribute(TestForm.class);
	}
	
    @RequestMapping(path = "/processToken.do")
	public ModelAndView handlePrepareSimple(ActionMapping mapping,
			@ModelAttribute("testForm") TestForm form, BindingResult bindingResult, HttpServletRequest request,
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

        // If user pressed 'Cancel' button,
        // return to home page
        if (isCancelled(request)) {
            return mapping.findForward("home");
        }

        ActionErrors errors = new ActionErrors();

        // Prevent unintentional duplication submissions by checking
        // that we have not received this token previously
        if (!isTokenValid(request)) {
            errors.add(
                ActionMessages.GLOBAL_MESSAGE,
                new ActionMessage("errors.token"));
        }
        resetToken(request);

        // Report any errors we have discovered back to the original form
        if (!errors.isEmpty()) {
            saveErrors(request, errors);
            saveToken(request);
            return (mapping.getInputForward());
        }

        // Forward to result page
        return mapping.findForward("success");
    }

}
