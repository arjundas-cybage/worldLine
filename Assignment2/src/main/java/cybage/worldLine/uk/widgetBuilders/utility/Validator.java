package cybage.worldLine.uk.widgetBuilders.utility;

/**
 * @author arjund
 *
 */
public interface Validator {

	/**
	 * @param integer
	 * @param coOrdinates
	 * @return
	 */
	public boolean validateInteger(Integer integer, Boolean coOrdinates);

	/**
	 * @param string
	 * @return
	 */
	public boolean validateString(String string);

}
