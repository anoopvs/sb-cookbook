package org.sb.examples;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sb.examples.simple.dyna.OptionsForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springbridge.action.Action;
import org.springbridge.action.DynaActionForm;
import org.springbridge.support.handler.ActionHandler;
import org.springbridge.utils.ModelAttributeUtils;

/**
 * <p>An Action that forwards control via a "success" ActionFoward.</p>
 *
 * <p>A recommended strategy is that view pages should link only to Actions and
 * never directly to other views. In situations where the view does not require
 * any preparation you can use a SuccessAction, specifying the view as an
 * ActionForward named "success" in your action mapping.</p>
 *
 * <p>e.g. If you configure an ActionMapping in struts-config.xml like this:</p>
 *
 * <pre>
 *    &lt;action path="/prepareView"
 *            type="examples.SuccessAction"&gt;
 *        &lt;forward name="success" path="/jsp/View.jsp"/&gt;
 *    &lt/action&gt;
 * </pre>
 *
 * <p>You could create a link to the view (via the Action) as follows:</p>
 *
 * <pre>
 *     &lt;html:link action="/prepareView"&gt;Display 'view' page&lt;/html:link&gt;
 * </pre>
 *
 * <p>If you later change your application such that the view page requires some
 * initialization you can change a single ActionMapping definition in
 * struts-config.xml rather than lots of link definitions in many JSPs.</p>
 *
 * @version $Rev: 471754 $ $Date: 2006-11-06 08:55:09 -0600 (Mon, 06 Nov 2006) $
 */
@Controller
@SessionAttributes(names= {"optionsForm"})
public class SessionCheckAction extends Action {
	@Autowired
	private ActionHandler handler;
    // ------------------------------------------------------------ Constructors

    /**
     * Constructor for SuccessAction.
     */
    public SessionCheckAction() {
        super();
    }
    
	@ModelAttribute("optionsForm")
	public OptionsForm dynaForm() {
		return ModelAttributeUtils.lookupOrCreateModelAttribute(OptionsForm.class);
	}
	
    @RequestMapping(path = "/sessionCheck.do")
	public ModelAndView handlePrepareSimple(
			@ModelAttribute("optionsForm") DynaActionForm form, BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
    	OptionsForm myForm=(OptionsForm) request.getSession().getAttribute("optionsForm");
    	if(!Objects.isNull(myForm)) {
    		System.out.println("Got Form from Session");
    		return null;
    	}
    	else {
    		System.out.println("Form not found in Session");
    	}
		return null;
	}

}
