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
public class PrepareMultiboxAction extends Action {
	@Autowired
	private ActionHandler handler;
    // ------------------------------------------------------------ Constructors

    /**
     * Constructor for SuccessAction.
     */
    public PrepareMultiboxAction() {
        super();
    }
    
	
    @RequestMapping(path = "/prepareMultibox.do")
	public ModelAndView handlePrepareSimple(ActionMapping mapping,
			@ModelAttribute("multiboxForm") MultiboxActionForm form, BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		final ActionContext ctx = ActionContext.builder().withController(this).withExecuteFunction(this::execute)
				.withMapping(mapping).withForm(form).withBindingResult(bindingResult).withHttpServletRequest(request)
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

            System.out.println("Prepare MultiboxActionForm ....");

            /*
             * Prepare a String array of color names used to generate
             * checkboxes using html:multibox tags in the JSP page.
             */
            String[] colors =
                { "Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet" };
            request.setAttribute("colors", colors);

            /*
             * Set default checkbox values.
             */
            String[] defaultFruits = { "Orange", "Banana", "Apple" };
            String[] defaultColors = { "Orange", "Yellow" };
            MultiboxActionForm multiboxForm = (MultiboxActionForm) form;
            multiboxForm.setFruits(defaultFruits);
            multiboxForm.setColors(defaultColors);

            // Return an ActionForward to the form
            return mapping.findForward("success");

        }

}
