package org.sb.examples;

import java.util.function.Supplier;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class ExecTimeTracker implements ServletRequestListener,Supplier<String> {
	
	private static ThreadLocal<Long> execTime=ThreadLocal.withInitial(()->System.currentTimeMillis());
	
	public ExecTimeTracker() {
		
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		execTime.set(null);
	}

	public void requestInitialized(ServletRequestEvent requestEvent) {
		if (!(requestEvent.getServletRequest() instanceof HttpServletRequest)) {
			throw new IllegalArgumentException(
					"Request is not an HttpServletRequest: " + requestEvent.getServletRequest());
		}
		execTime.set(System.currentTimeMillis());
	}

	@Override
	public String get() {
		return (System.currentTimeMillis()-execTime.get())+" "+"ms";
	}

}
