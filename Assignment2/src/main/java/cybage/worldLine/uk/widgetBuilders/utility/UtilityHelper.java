package cybage.worldLine.uk.widgetBuilders.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * @author arjund
 *
 */
public class UtilityHelper {

	final static Logger logger = Logger.getLogger(UtilityHelper.class);

	/**
	 * @param positions 
	 * @return Integer
	 * 
	 * This is a regular Expression Method to extract the digits
	 */
	public static Integer extractNumeric(String positions) {

		logger.info("Enter : UtilityHelper ::extractNumeric");

		String str = positions;
		Integer num = 0;
		Pattern negative = Pattern.compile("(-\\d+)");
		Pattern positive = Pattern.compile("(\\d+)");
		Matcher matchPositive = positive.matcher(str);
		Matcher matchNegative = negative.matcher(str);
		while (matchNegative.find()) {
			num = Integer.valueOf(matchNegative.group(1));
			// logger.error(ConstantFiles.errorMessage);
			logger.info("Exit : UtilityHelper ::extractNumeric : matchNegative");
			return num;
		}
		while (matchPositive.find()) {
			num = Integer.valueOf(matchPositive.group(1));

		}

		logger.info("Exit : UtilityHelper ::extractNumeric : matchPositive");
		return num;

	}

	/**
	 * @param text
	 * 
	 * @return String
	 * 
	 * This is a regular Expression Method to extract the String
	 */
	public static String extractText(String text) {

		logger.info("Enter : UtilityHelper ::extractText");
		String[] textArray = text.split("Text - ");
		logger.info("Exit : UtilityHelper ::extractText");
		if (textArray.length > 1) {
			return "\"" + textArray[1].trim() + "\"";
		} else
			return "";
	}
}
