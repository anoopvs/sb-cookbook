package org.sb.examples;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sb.examples.simple.UserForm;
import org.springbridge.action.Action;
import org.springbridge.action.ActionForm;
import org.springbridge.action.ActionMapping;
import org.springbridge.support.handler.ActionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Perform any tasks and setup any data that
 * must be prepared before the form is displayed.
 *
 * @version $Rev: 471754 $ $Date: 2006-11-06 08:55:09 -0600 (Mon, 06 Nov 2006) $
 */
@Controller
public class DynamicModelAttributeAction extends Action {
	@Autowired
	private ActionHandler handler;
    // ------------------------------------------------------------ Constructors

    /**
     * Constructor for PrepareOptionsAction.
     */
    public DynamicModelAttributeAction() {
        super();
    }

	@ModelAttribute("one")
	public ActionForm firstForm() {
		UserForm user= new UserForm("1");
		return user;
	}
	
	@ModelAttribute("two")
	public ActionForm secondForm() {
		UserForm user= new UserForm("2");
		return user;
	}
	@ModelAttribute("three")
	public ActionForm thirdForm() {
		UserForm user= new UserForm("3");
		return user;
	}
	
    @RequestMapping(path = {"/dynamicModelAttr.do"})
	public ModelAndView handlePrepareSimple(@ModelAttribute("#{request.maName}") UserForm form,
			 HttpServletRequest request,
			HttpServletResponse response) {
		StandardEvaluationContext context = new StandardEvaluationContext();
		context.addPropertyAccessor(new MapAccessor());
		context.setRootObject(request);
    	ExpressionParser parser = new SpelExpressionParser();
    	System.out.println(form.getUserName());
    	//System.out.println(parser.parseExpression("params.maName").getValue(context,String.class));
	 return null;
	}

}
