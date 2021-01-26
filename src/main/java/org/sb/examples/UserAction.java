package org.sb.examples;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sb.examples.simple.UserForm;
import org.springbridge.action.Action;
import org.springbridge.action.ActionForm;
import org.springbridge.action.ActionForward;
import org.springbridge.action.ActionMapping;
import org.springbridge.support.handler.ActionContext;
import org.springbridge.support.handler.ActionContext.Builder;
import org.springbridge.support.handler.ActionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserAction extends Action {
	@Autowired
	private ActionHandler handler;
	// ------------------------------------------------------------ Constructors

	/**
	 * Constructor for SuccessAction.
	 */
	public UserAction() {
		super();
	}

	@ModelAttribute
	public ActionForm userForm() {
		UserForm user = new UserForm("123");
		return user;
	}

	@RequestMapping(path = "/UserAction.do")
	public ModelAndView handlePrepareDyna(ActionMapping mapping, ActionForm form, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response) {
		UserForm userForm = (UserForm) form;
		System.out.println("UserForm::" + userForm);
		final ActionContext ctx = ActionContext.builder().withController(this).withMapping(mapping).withForm(form)
				.withBindingResult(bindingResult).withHttpServletRequest(request)
				.withHttpServletResponse(response).build(this::setExecuteFunction);
		return handler.handleActionExecution(ctx);
	}
	// ---------------------------------------------------------- Action Methods

	private void setExecuteFunction(Builder builder) {
		ActionMapping mapping = builder.getMapping();
		HttpServletRequest request = builder.getHttpServletRequest();
		String methodName = request.getParameter(mapping.getParameter());
		if (StringUtils.hasText(methodName)) {
			switch (methodName) {
			case "add":
				builder.setExecuteFunction(this::add);
				break;
			case "update":
				builder.setExecuteFunction(this::update);
				break;
			case "delete":
				builder.setExecuteFunction(this::delete);
				break;
			default:
				throw new UnsupportedOperationException(methodName + " not found !!!");
			}
		}
	}

	private final static String SUCCESS = "success";

	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;
		userForm.setMessage("Inside add user method.");
		return mapping.findForward(SUCCESS);
	}

	public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;
		userForm.setMessage("Inside update user method.");
		return mapping.findForward(SUCCESS);
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;
		userForm.setMessage("Inside delete user method.");
		return mapping.findForward(SUCCESS);
	}
}
