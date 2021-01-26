package org.sb.examples.simple;

import org.springbridge.action.ActionForm;

public class UserForm extends ActionForm {

	private static final long serialVersionUID = 1L;
    final String userName;
    private String  message;
	public UserForm(String userName) {
		super();
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "UserForm [userName=" + userName + ", message=" + message + "]";
	}
	
}
