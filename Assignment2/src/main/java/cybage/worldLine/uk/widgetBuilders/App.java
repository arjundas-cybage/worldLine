package cybage.worldLine.uk.widgetBuilders;

import cybage.worldLine.uk.widgetBuilders.utility.FileReader;
import cybage.worldLine.uk.widgetBuilders.utility.FlatFileReader;

/**
 * Hello world!
 *
 */

public class App {
	public static void main(String[] args) {
		String link = "./src/main/resources/Input.txt";
		FileReader f = new FlatFileReader();
		f.readFile(link);
	}
}