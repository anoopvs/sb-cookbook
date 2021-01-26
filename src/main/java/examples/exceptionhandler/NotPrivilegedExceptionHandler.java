package examples.exceptionhandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springbridge.action.ActionForm;
import org.springbridge.action.ActionForward;
import org.springbridge.action.ActionMapping;
import org.springbridge.support.handler.AbstractExceptionHandler;

public class NotPrivilegedExceptionHandler extends AbstractExceptionHandler {

	@Override
	public ActionForward handleActionExecutionException(final Exception exc, final ActionMapping mapping,
			final ActionForm actionForm, final HttpServletRequest request, final HttpServletResponse response)  {
		return new ActionForward("not-privileged", "/WEB-INF/exception/notPrivileged.jsp");
	}

}
