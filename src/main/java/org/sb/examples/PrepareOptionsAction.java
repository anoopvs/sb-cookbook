package org.sb.examples;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sb.examples.simple.dyna.OptionsForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springbridge.action.Action;
import org.springbridge.action.ActionForm;
import org.springbridge.action.ActionForward;
import org.springbridge.action.ActionMapping;
import org.springbridge.action.DynaActionForm;
import org.springbridge.support.handler.ActionContext;
import org.springbridge.support.handler.ActionHandler;
import org.springbridge.support.utils.LabelValueBean;
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
public class PrepareOptionsAction extends Action {
	@Autowired
	private ActionHandler handler;
    // ------------------------------------------------------------ Constructors

    /**
     * Constructor for SuccessAction.
     */
    public PrepareOptionsAction() {
        super();
    }
    
	@ModelAttribute("optionsForm")
	public OptionsForm dynaForm() {
		return ModelAttributeUtils.lookupOrCreateModelAttribute(OptionsForm.class);
	}
	
    @RequestMapping(path = "/prepareOptions.do")
	public ModelAndView handlePrepareSimple(ActionMapping mapping,
			@ModelAttribute("optionsForm") DynaActionForm form, BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		final ActionContext ctx = ActionContext.builder().withController(this).withExecuteFunction(this::execute)
				.withMapping(mapping).withMapping(mapping).withHttpServletRequest(request)
				.withHttpServletResponse(response).build();
		ModelAndView mav= handler.handleActionExecution(ctx);
		return mav;
	}

    // ---------------------------------------------------------- Action Methods

    /**
     * Process the request and return an <code>ActionForward</code> instance
     * describing where and how control should be forwarded, or
     * <code>null</code>if the response has already been completed.
     *
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if an exception occurs
     *
     * @return the ActionForward to forward control to
     */
    public ActionForward execute(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response)
        throws Exception {

        /* An array */
        String[] fruits =
            {
                "Strawberry",
                "Apple",
                "Orange",
                "Pear",
                "Mango",
                "Banana",
                "Pineapple" };
        request.setAttribute("fruits", fruits);

        /* Two arrays - one for labels and one for values */
        String[] colors =
            { "Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet" };
        request.setAttribute("colors", colors);

        String[] colorCodes =
            {
                "#FF0000",
                "#FFA500",
                "#FFFF00",
                "#00FF00",
                "#0000FF",
                "#4B0082",
                "#EE82EE" };
        request.setAttribute("colorCodes", colorCodes);

        /* A Collection */
        ArrayList<String> colorList = new ArrayList<>();
        colorList.add("Red");
        colorList.add("Orange");
        colorList.add("Yellow");
        colorList.add("Green");
        colorList.add("Blue");
        colorList.add("Indigo");
        colorList.add("Violet");
        request.setAttribute("colorCollection", colorList);

        /* A Collection of LabelValue beans */
        ArrayList<LabelValueBean> days = new ArrayList<LabelValueBean>();
        days.add(new LabelValueBean("Monday", "1"));
        days.add(new LabelValueBean("Tuesday", "2"));
        days.add(new LabelValueBean("Wednesday", "3"));
        days.add(new LabelValueBean("Thursday", "4"));
        days.add(new LabelValueBean("Friday", "5"));
        days.add(new LabelValueBean("Saturday", "6"));
        days.add(new LabelValueBean("Sunday", "7"));
        request.setAttribute("days", days);

        /* Collection of custom beans */
        ArrayList<BookBean> books = new ArrayList<>();
        books.add(new BookBean("0596003285", "Programming Jakarta Struts"));
        books.add(new BookBean("1930110502", "Struts in Action"));
        books.add(
            new BookBean("1861007817", "Professional Struts Applications"));
        books.add(new BookBean("0672324725", "Struts Kick Start"));
        books.add(new BookBean("0471213020", "Mastering Jakarta Struts"));
        books.add(new BookBean("1558608621", "The Struts Framework"));
        books.add(new BookBean("0971661901", "Struts Fast Track"));
        request.setAttribute("books", books);

        /* A Map
         *
         * Note: We are using a HashMap which is unsorted - the resulting
         * options could appear in any order. If you want to your options to be
         * in a particular order you should you a SortedMap implementation such
         * as the TreeMap. This behaviour is a feature of the standard Map
         * implementaions and nothing to to with Struts tags.
         *
         * Also, we've used an Integer as the key to demonstrate that the
         * <html:options> and <html:optionsCollection> tags do not require
         * String values for the label and values. If they are passed an object
         * other than a String, they will automatically call the toString()
         * method and use the result.
         */
        HashMap<Integer,String> animals = new HashMap<>();
        animals.put(Integer.valueOf(1), "Cat");
        animals.put(Integer.valueOf(2), "Dog");
        animals.put(Integer.valueOf(3), "Horse");
        animals.put(Integer.valueOf(4), "Rabbit");
        animals.put(Integer.valueOf(5), "Goldfish");
        request.setAttribute("animals", animals);

        // Forward to form page
        return mapping.findForward("success");

    }

}
