package org.sb.examples;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sb.examples.simple.dyna.DynaForm;
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
import org.springbridge.support.handler.ActionContext;
import org.springbridge.support.handler.ActionHandler;
import org.springbridge.utils.ModelAttributeUtils;

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
public class ProcessDynaAction extends Action {
	@Autowired
	private ActionHandler handler;
    // ------------------------------------------------------------ Constructors

    /**
     * Constructor for SuccessAction.
     */
    public ProcessDynaAction() {
        super();
    }
    
	@ModelAttribute("dynaForm")
	public DynaForm dynaForm() {
		return ModelAttributeUtils.lookupOrCreateModelAttribute(DynaForm.class);
	}
	
    @RequestMapping(path = "/processDyna.do")
	public ModelAndView handlePrepareSimple(ActionMapping mapping,
			@ModelAttribute("dynaForm") DynaForm form, BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		final ActionContext ctx = ActionContext.builder().withController(this).withExecuteFunction(this::execute)
				.withMapping(mapping).withForm(form).withMapping(mapping).withBindingResult(bindingResult).withHttpServletRequest(request)
				.withHttpServletResponse(response).build();
		return handler.handleActionExecution(ctx);
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
    	DynaActionForm daf=(DynaActionForm) form;
    	System.out.println("Name::"+daf.get("name"));
        // If user pressed 'Cancel' button,
        // return to home page
        if (isCancelled(request)) {
            return mapping.findForward("home");
        }

        // Forward to result page
        return mapping.findForward("success");
    }
}
