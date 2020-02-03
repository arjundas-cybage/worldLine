package cybage.worldLine.uk.widgetBuilders.utility;

import java.util.List;

/**
 * @author arjund
 *
 */
public interface FileReader {

	/**
	 * @param link File Location to read
	 */
	public void readFile(String link) ;

	/**
	 * @param list 
	 * @param link File Location TO Write
	 */
	public void writeFile(List<String> list ,String link) ;

}
