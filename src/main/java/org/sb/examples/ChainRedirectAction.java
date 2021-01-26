package org.sb.examples;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springbridge.action.Action;
import org.springbridge.action.ActionForm;
import org.springbridge.action.ActionForward;
import org.springbridge.action.ActionMapping;
import org.springbridge.support.ExecuteFunction;
import org.springbridge.support.handler.ActionContext;
import org.springbridge.support.handler.ActionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Perform any tasks and setup any data that
 * must be prepared before the form is displayed.
 *
 * @version $Rev: 471754 $ $Date: 2006-11-06 08:55:09 -0600 (Mon, 06 Nov 2006) $
 */
@Controller
public class ChainRedirectAction extends Action {
	@Autowired
	private ActionHandler handler;
    // ------------------------------------------------------------ Constructors

    /**
     * Constructor for PrepareOptionsAction.
     */
    public ChainRedirectAction() {
        super();
    }

	
    @RequestMapping(path = {"/initiateRedirectChain.do","/oneRedirect.do","/twoRedirect.do","/threeRedirect.do"})
	public ModelAndView handlePrepareSimple(ActionMapping mapping,
			 HttpServletRequest request,
			HttpServletResponse response) {
		final ActionContext ctx = ActionContext.builder().withController(this).withExecuteFunction(this.getExecuteFunction(request))
				.withMapping(mapping).withHttpServletRequest(request)
				.withHttpServletResponse(response).build();
		return handler.handleActionExecution(ctx);
	}
    private ExecuteFunction getExecuteFunction(HttpServletRequest request) {
		final String servletPath=request.getServletPath();
		System.out.println("servletPath::"+servletPath);
		if("/initiateRedirectChain.do".equals(servletPath)) {
			return this::execute;
		}else if("/oneRedirect.do".equals(servletPath)) {
			return this::one;
		}else if("/twoRedirect.do".equals(servletPath)) {
			return this::two;
		}
		return this::three;
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
        return mapping.findForward("one");
    }
    public ActionForward one(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {
            return mapping.findForward("two");
        }
    public ActionForward two(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {
            return mapping.findForward("three");
        }
    public ActionForward three(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {
            return mapping.findForward("success");
        }

}
