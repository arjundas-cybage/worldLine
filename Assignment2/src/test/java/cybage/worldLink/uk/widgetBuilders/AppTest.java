package cybage.worldLink.uk.widgetBuilders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import cybage.worldLine.uk.widgetBuilders.domain.Circle;
import cybage.worldLine.uk.widgetBuilders.domain.Ellipse;
import cybage.worldLine.uk.widgetBuilders.domain.Rectangle;
import cybage.worldLine.uk.widgetBuilders.domain.Square;
import cybage.worldLine.uk.widgetBuilders.domain.TextBox;
import cybage.worldLine.uk.widgetBuilders.serviceImpl.CircleBillables;
import cybage.worldLine.uk.widgetBuilders.serviceImpl.EllipseBillables;
import cybage.worldLine.uk.widgetBuilders.serviceImpl.RectangleBillables;
import cybage.worldLine.uk.widgetBuilders.serviceImpl.SquareBillables;
import cybage.worldLine.uk.widgetBuilders.serviceImpl.TextBoxBillables;
import cybage.worldLine.uk.widgetBuilders.utility.ConstantFiles;
import cybage.worldLine.uk.widgetBuilders.utility.FileReader;
import cybage.worldLine.uk.widgetBuilders.utility.FlatFileReader;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	final static Logger logger = Logger.getLogger(AppTest.class);

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 * 
	 * @throws IOException
	 */
	public void testApp() throws IOException {

		
	}

	public void testAbortConditions() throws IOException {
		String linkInput = "./src/test/resources/Input.txt";
		String linkOutput = "./Output_Test.txt";
		
		boolean errorFlag = false;
		Path path = Paths.get(linkOutput);
		FlatFileReader file = new FlatFileReader();
		file.setFilepath(linkOutput);
		file.readFile(linkInput);

		try (Stream<String> lines = Files.lines(path)) {
			Iterator<String> i = lines.iterator();
			while (i.hasNext()) {
				String abort = i.next();
				if (abort.contains(ConstantFiles.errorMessage)) {
					errorFlag = true;
					break;
				}
			}

			assertEquals(errorFlag ,  true);
		}
	}
	public void testRectangle() {
		Rectangle rectangle = new Rectangle(10, 20, 30, 40);
		logger.info("Rectangle created with attributes " + rectangle.toString());
		RectangleBillables rectangleBillables = new RectangleBillables(rectangle);
		assertEquals(rectangleBillables.billables(), "Rectangle(10,20)width=30 height=40");
	}

	public void testCircle() {
		Circle circle = new Circle(10, 20, 30);
		logger.info("circle created with attributes " + circle.toString());
		CircleBillables circleBillables = new CircleBillables(circle);
		assertEquals(circleBillables.billables(), "Circle(10,20)size=30");
	}

	public void testSquare() {
		Square square = new Square(10, 20, 30);
		logger.info("Rectangle created with attributes " + square.toString());
		SquareBillables squareBillables = new SquareBillables(square);
		assertEquals(squareBillables.billables(), "Square(10,20)size=30");
	}

	public void testEcllipse() {
		Ellipse ellipse = new Ellipse(10, 20, 30, 40);
		logger.info("Ellipse created with attributes " + ellipse.toString());
		EllipseBillables ellipseBillables = new EllipseBillables(ellipse);
		assertEquals(ellipseBillables.billables(), "Ellipse(10,20)diameterH = 40 diameterV = 30");
	}

	public void testTextBox() {
		TextBox textBox = new TextBox(10, 20, 30, 40, "sampleText");
		logger.info("TextBox created with attributes " + textBox.toString());
		TextBoxBillables textBoxBillables = new TextBoxBillables(textBox);
		assertEquals(textBoxBillables.billables(), "Textbox(10,20)width=30 height=40 text=sampleText");
	}

	public void testFileAsInput() throws IOException {
		String linkInput = "./src/test/resources/Input.txt";
		String linkOutput = "./Output_test.txt";
		Boolean flag = false;
		Path path = Paths.get(linkOutput);
		FlatFileReader f = new FlatFileReader();
	    f.setFilepath(linkOutput);
		f.readFile(linkInput);

		try (Stream<String> lines = Files.lines(path)) {
			Iterator<String> i = lines.iterator();
			if (i.hasNext()) {
				 flag  = true;
						
			} else {
				flag=false;
			}
			assertEquals(flag,Boolean.TRUE);
		}
		
		
	}

}
