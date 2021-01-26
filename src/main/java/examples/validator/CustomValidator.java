package examples.validator;


import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.springframework.validation.Errors;
import org.springmodules.validation.commons.FieldChecks;

/**
 * A custom validator example
 *
 * @version $Rev: 471754 $ $Date: 2006-11-06 08:55:09 -0600 (Mon, 06 Nov 2006) $
 */
public class CustomValidator {

    // ------------------------------------------------------------ Constructors

    /**
     * Constructor for CustomValidator.
     */
    public CustomValidator() {
        super();
    }

    // ---------------------------------------------------------- Public Methods

    /**
     * Example validator for comparing the equality of two fields
     *
     * http://struts.apache.org/userGuide/dev_validator.html
     * http://www.raibledesigns.com/page/rd/20030226
     */
    public static boolean validateTwoFields(
        Object bean,
        ValidatorAction va,
        Field field,
        Errors errors) {

        String value =
            ValidatorUtils.getValueAsString(bean, field.getProperty());
        String property2 = field.getVarValue("secondProperty");
        String value2 = ValidatorUtils.getValueAsString(bean, property2);

        if (!GenericValidator.isBlankOrNull(value)) {
            try {
                if (!value.equals(value2)) {
                	 FieldChecks.rejectValue(errors, field, va);
                    return false;
                }
            } catch (Exception e) {
            	 FieldChecks.rejectValue(errors, field, va);
                   
                return false;
            }
        }
        return true;
    }

}
