package org.sb.examples.simple;

import javax.servlet.http.HttpServletRequest;

import org.springbridge.action.ActionErrors;
import org.springbridge.action.ActionForm;
import org.springbridge.action.ActionMapping;

/**
 * An ActionForm for the Multibox examples
 *
 * @version $Rev: 471754 $ $Date: 2006-11-06 08:55:09 -0600 (Mon, 06 Nov 2006) $
 */
public class MultiboxActionForm extends ActionForm {
	private static final long serialVersionUID = 1L;

    // ------------------------------------------------------ Instance Variables
	/** Fruits */
    private String[] fruits = {};

    /** Colors */
    private String[] colors = {};

    // ------------------------------------------------------------ Constructors

    /**
     * Constructor for MultiboxActionForm.
     */
    public MultiboxActionForm() {
        super();
    }

    // ---------------------------------------------------------- Public Methods

    /**
     * Clear all checkboxes
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {

        /*
         * The ActionForm reset method should only be used to *clear*
         * checkboxes. The correct place to *set* default checkbox values is in
         * the 'prepare' action, called prior to displaying the form page.
         */
        String[] empty = {};
        this.fruits = empty;
        this.colors = empty;

    }

    /**
     * Validate the properties that have been set from this HTTP request,
     * and return an <code>ActionMessages</code> object that encapsulates any
     * validation errors that have been found.  If no errors are found, return
     * <code>null</code> or an <code>ActionMessages</code> object with no
     * recorded error messages.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     *
     * @return ActionMessages if any validation errors occurred
     */
    public ActionErrors validate(
        ActionMapping mapping,
        HttpServletRequest request) {

        /*
         * We're not doing any validation (yet) so return null to
         * indicate that there were no errors. (We don't
         * actually need to override this nethod unles we're doing
         * validation - but it's here for reference)
         */
        return null;
    }

    // -------------------------------------------------------------- Properties

    /**
     * Returns the colors.
     * @return String[]
     */
    public String[] getColors() {
        return colors;
    }

    /**
     * Returns the fruits.
     * @return String[]
     */
    public String[] getFruits() {
        return fruits;
    }

    /**
     * Sets the colors.
     * @param colors The colors to set
     */
    public void setColors(String[] colors) {
        this.colors = colors;
    }

    /**
     * Sets the fruits.
     * @param fruits The fruits to set
     */
    public void setFruits(String[] fruits) {
        this.fruits = fruits;
    }

}
