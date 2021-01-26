package org.sb.examples.simple.dyna;

import javax.servlet.http.HttpServletRequest;

import org.springbridge.action.ActionMapping;
import org.springbridge.action.DynaActionForm;

public class DynaForm extends DynaActionForm{
	private static final long serialVersionUID = 1L;

	String name;
	String secret;
	String color;
	String confirm;
	String rating;
	String message;
	String hidden;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getHidden() {
		return hidden;
	}
	public void setHidden(String hidden) {
		this.hidden = hidden;
	}
	
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.confirm = String.valueOf(Boolean.FALSE);
    }
}
