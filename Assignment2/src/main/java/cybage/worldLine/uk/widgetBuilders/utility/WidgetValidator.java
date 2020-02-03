package cybage.worldLine.uk.widgetBuilders.utility;

import org.apache.log4j.Logger;

/**
 * @author arjund
 *
 */
public class WidgetValidator implements Validator {

	final static Logger logger = Logger.getLogger(WidgetValidator.class);

	/* (non-Javadoc)
	 * @see cybage.worldLine.uk.widgetBuilders.utility.Validator#validateInteger(java.lang.Integer, java.lang.Boolean)
	 * 
	 * This does the Business Validation
	 * 
	 * 
	 */
		
	@Override
	public boolean validateInteger(Integer integer, Boolean coOrdinates) {

		if (!(coOrdinates) && (integer <= 0 | integer > 1000)) {

			logger.error(ConstantFiles.errorMessage);
			return false;

		}

		else if (coOrdinates && integer < 0) {

			logger.error(ConstantFiles.errorMessage);
			return false;
		}

		return true;
	}

	@Override
	public boolean validateString(String string) {

		return true;
	}

}
