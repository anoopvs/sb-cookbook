package org.sb.examples;

import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.sb.examples.exceptions.NotPrivilegedException;
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
public class UtilityAction extends Action {
	@Autowired
	private ActionHandler handler;
    // ------------------------------------------------------------ Constructors

    /**
     * Constructor for PrepareOptionsAction.
     */
    public UtilityAction() {
        super();
    }
    
    @RequestMapping(path = "/configureLogging.do")
	public void configureLoggingMethod(HttpServletRequest request) {
    	System.out.println("Done!!!!");
	}
	
    @RequestMapping(path = "/generateException.do")
	public ModelAndView handlePrepareSimple(ActionMapping mapping,
			 HttpServletRequest request,
			HttpServletResponse response) {
		final ActionContext ctx = ActionContext.builder().withController(this).withExecuteFunction(this::execute)
				.withMapping(mapping).withHttpServletRequest(request)
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
     * @exception Exception if an exception occurs
     *
     * @return the ActionForward to forward control to
     */
    public ActionForward execute(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response)
        throws Exception {
        // Forward to the form
    	if(Objects.nonNull(request.getParameter("exc"))) {
    		String execType=request.getParameter("exc");
    		if("IA".equalsIgnoreCase(execType)) {
    			throw new IllegalAccessException("Testing Illegal Access Exception Handler");
    		}else if("IS".equalsIgnoreCase(execType)) {
    			throw new IllegalStateException("Testing State Access Exception Handler");
    		}else if("NP".equalsIgnoreCase(execType)) {
    			throw new NotPrivilegedException("Testing NotPrivileged Exception Handler");
    		}
    		throw new ServletException("Test Exception");
    	}
        return mapping.findForward("home");

    }

}
