package org.sb.examples;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@Component
public class ServletRequestHandledEventListener implements ApplicationListener<ServletRequestHandledEvent> {
	/** Logger available to subclasses. */
	protected final Log logger = LogFactory.getLog(getClass());
	@Override
	public void onApplicationEvent(ServletRequestHandledEvent event) {
		logger.info("####"+event);
	}

}
