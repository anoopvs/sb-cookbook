package org.sb.examples;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class ValidateRoleRequestWrapper extends HttpServletRequestWrapper {
	public static final String[] VALID_ROLES = new String[] {"ADMIN","CSR","MARKET_ADMIN","USER"};
	public ValidateRoleRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public boolean isUserInRole(String role) {
		return Arrays.binarySearch(VALID_ROLES, role)>= 0;
	}

}
