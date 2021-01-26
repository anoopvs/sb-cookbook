package org.sb.examples;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sb.examples.simple.User;

/**
 * Servlet Filter implementation class SetRoleFilter
 */
@WebFilter(description = "Inject Roles in Request",servletNames= {"dispatcher"})
//@WebFilter(description = "Inject Roles in Request",urlPatterns= {"/"})
public class SetRoleFilter implements Filter {
	protected static final Log logger = LogFactory.getLog(SetRoleFilter.class);
    /**
     * Default constructor. 
     */
    public SetRoleFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.debug("From SetRoleFilter>>");
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		HttpSession session=((HttpServletRequest) request).getSession(false);
		if(Objects.nonNull(request.getParameter("logout"))) {
			if(session!=null) {
				session.invalidate();
			}
		}
		session=httpRequest.getSession(true);
		if(Objects.isNull(session.getAttribute("user"))) {
			User user= new User();
			user.setUserName("Anoop V S");
			user.setLoginTS(new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss").format(new Date()));
			session.setAttribute("user", user);
		}
		chain.doFilter(new ValidateRoleRequestWrapper((HttpServletRequest) request), response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
