package cybage.worldLine.uk.widgetBuilders.utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.lang3.mutable.MutableBoolean;
import org.apache.log4j.Logger;

import cybage.worldLine.uk.widgetBuilders.domain.Circle;
import cybage.worldLine.uk.widgetBuilders.domain.Ellipse;
import cybage.worldLine.uk.widgetBuilders.domain.Rectangle;
import cybage.worldLine.uk.widgetBuilders.domain.Shape;
import cybage.worldLine.uk.widgetBuilders.domain.ShapeDTO;
import cybage.worldLine.uk.widgetBuilders.domain.Square;
import cybage.worldLine.uk.widgetBuilders.domain.TextBox;
import cybage.worldLine.uk.widgetBuilders.domain.WidgetBuilderFactory;
import cybage.worldLine.uk.widgetBuilders.serviceImpl.CircleBillables;
import cybage.worldLine.uk.widgetBuilders.serviceImpl.EllipseBillables;
import cybage.worldLine.uk.widgetBuilders.serviceImpl.RectangleBillables;
import cybage.worldLine.uk.widgetBuilders.serviceImpl.SquareBillables;
import cybage.worldLine.uk.widgetBuilders.serviceImpl.TextBoxBillables;

/**
 * @author arjund
 *
 */
/**
 * @author arjund
 *
 */

public class FlatFileReader implements FileReader {
	

	final static Logger logger = Logger.getLogger(FlatFileReader.class);
	public String filepath = "./Output.txt";
	
	/**
	 * @return the filepath
	 */
	public String getFilepath() {
		return filepath;
	}

	/**
	 * @param filepath the filepath to set
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	Boolean firstTimeRunnerFlag = true;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cybage.worldLink.uk.widgetBuilders.utility.FileReader#readFile(java.lang.
	 * String) This reads the flat parses it .
	 */
	@Override
	public void readFile(String link) {

		logger.info("Enter : FlatFileReader ::readFile");

		int count = 0;
		MutableBoolean malformed = new MutableBoolean(true);
		MutableBoolean textOptional = new MutableBoolean(false);
		String name = "";
		Path path = Paths.get(link);

		try (Stream<String> lines = Files.lines(path)) {

			Iterator<String> i = lines.iterator();

			ArrayList<String> list = new ArrayList<String>();

			while (i.hasNext()) {

				malformed.setTrue();

				if (count % 10 == 0) {
					writeFile(list, filepath);
					list.clear();

				}

				if (textOptional.isFalse()) {
					name = i.next();
				}

				if (name.contains(ConstantFiles.rectangle)) {
					count++;
					rectangleDtoBuilder(i, malformed, list);

				}

				if (name.contains(ConstantFiles.square)) {

					count++;
					squareDtoBuilder(i, malformed, list);

				}

				if (name.contains(ConstantFiles.ellipse)) {

					count++;
					ellipseDtoBuilder(i, malformed, list);

				}
				if (name.contains(ConstantFiles.circle)) {
					count++;
					circleDtoBuilder(i, malformed, list);
				}

				if (name.contains(ConstantFiles.textBox)) {
					count++;
					textBoxDtoBuilder(i, malformed, list, textOptional);

				}

				if (malformed.booleanValue() == true) {
					logger.error(ConstantFiles.errorMessage);
					logger.info("Failed Object Creation ");
				}

			}
			writeFile(list, filepath);

		} catch (IOException e) {
			logger.error(ConstantFiles.errorMessage);
		}

		logger.info(" Exit : FlatFileReader ::readFile");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cybage.worldLink.uk.widgetBuilders.utility.FileReader#writeFile(java.util
	 * .List, java.lang.String) write calls to the file
	 */

	@Override
	public void writeFile(List<String> list, String link) {

		logger.info("Enter : FlatFileReader ::writeFile");

		String filepath = link;
		try {
			writeSmallTextFile(list, filepath);
		} catch (IOException e) {
			logger.error(e);
		}

		logger.info("Exit : FlatFileReader ::writeFile");

	}

	/**
	 * @param aLines
	 * @param filePath
	 * @throws IOException
	 */
	private void writeSmallTextFile(List<String> aLines, String filePath) throws IOException {

		logger.info("Enter : FlatFileReader ::writeSmallTextFile");

		Path fileP = Paths.get(filePath);
		Charset charset = Charset.forName("utf-8");

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {

			if (firstTimeRunnerFlag == true) {

				writer.newLine();
				writer.write(FileHeader.header);

				firstTimeRunnerFlag = false;

			}

			for (String line : aLines) {
				writer.newLine();
				writer.write(line);
			}

		} catch (IOException e) {
			logger.error(e);
		}

		logger.info("Enter : FlatFileReader ::writeSmallTextFile");
	}

	/**
	 * @param i
	 * @param malformed
	 * @param list
	 *            This parses the file and populates DTO for Rectangle
	 */
	public void rectangleDtoBuilder(Iterator i, MutableBoolean malformed, List list) {

		Shape shape;
		Boolean validationInputFlag = Boolean.TRUE;
		Integer positionX = null;
		Integer positionY = null;
		Integer width = null;
		Integer height = null;

		String position = (String) i.next();

		if (position.contains(ConstantFiles.position_X)) {
			positionX = UtilityHelper.extractNumeric(position);
			WidgetValidator widgetValidator = new WidgetValidator();
			validationInputFlag = widgetValidator.validateInteger(positionX, true) && validationInputFlag;
			position = (String) i.next();
		}
		if (position.contains(ConstantFiles.position_Y)) {
			positionY = UtilityHelper.extractNumeric(position);
			WidgetValidator widgetValidator = new WidgetValidator();
			validationInputFlag = widgetValidator.validateInteger(positionY, true) && validationInputFlag;
			position = (String) i.next();
		}

		if (position.contains(ConstantFiles.width)) {

			width = UtilityHelper.extractNumeric(position);
			WidgetValidator widgetValidator = new WidgetValidator();
			validationInputFlag = widgetValidator.validateInteger(width, false) && validationInputFlag;
			position = (String) i.next();

		}
		if (position.contains(ConstantFiles.height)) {

			height = UtilityHelper.extractNumeric(position);
			WidgetValidator widgetValidator = new WidgetValidator();
			validationInputFlag = widgetValidator.validateInteger(height, false) && validationInputFlag;
		}

		if (validationInputFlag) {
			malformed.setFalse();
			ShapeDTO shapeDto = new ShapeDTO();
			shapeDto.setPositionX(positionX);
			shapeDto.setPositionY(positionY);
			shapeDto.setHeight(height);
			shapeDto.setWidth(width);

			Rectangle rectangle = (Rectangle) WidgetBuilderFactory.build("Rectangle", shapeDto);
			RectangleBillables rectangleBillables = new RectangleBillables(rectangle);
			list.add(rectangleBillables.billables());
		} else {

			list.add(ConstantFiles.errorMessage);
		}

	}

	/**
	 * @param i
	 * @param malformed
	 * @param list
	 *            This parses the file and populates DTO for Square
	 */
	public void squareDtoBuilder(Iterator i, MutableBoolean malformed, List list) {
		Boolean validationInputFlag = Boolean.TRUE;
		Integer positionX = null;
		Integer positionY = null;
		Integer width = null;

		String position = (String) i.next();

		if (position.contains(ConstantFiles.position_X)) {

			// Integer temp = 0;
			positionX = UtilityHelper.extractNumeric(position);
			WidgetValidator widgetValidator = new WidgetValidator();
			validationInputFlag = widgetValidator.validateInteger(positionX, true) && validationInputFlag;
			position = (String) i.next();
		}
		if (position.contains(ConstantFiles.position_Y)) {
			// Integer temp = 0;
			positionY = UtilityHelper.extractNumeric(position);
			WidgetValidator widgetValidator = new WidgetValidator();
			validationInputFlag = widgetValidator.validateInteger(positionY, true) && validationInputFlag;
			position = (String) i.next();
		}

		if (position.contains(ConstantFiles.width)) {
			// Integer temp = 0;
			width = UtilityHelper.extractNumeric(position);
			WidgetValidator widgetValidator = new WidgetValidator();
			validationInputFlag = widgetValidator.validateInteger(width, false) && validationInputFlag;

		}
		// if (positionX > 0 && positionY > 0 && width > 0 && width <= 1000) {
		if (validationInputFlag) {
			malformed.setFalse();
			ShapeDTO shapeDto = new ShapeDTO();
			shapeDto.setPositionX(positionX);
			shapeDto.setPositionY(positionY);
			shapeDto.setWidth(width);

			Square square = (Square) WidgetBuilderFactory.build("Square", shapeDto);
			SquareBillables squareBilables = new SquareBillables(square);
			list.add(squareBilables.billables());
		} else {

			list.add(ConstantFiles.errorMessage);
		}
	}

	/**
	 * @param i
	 * @param malformed
	 * @param list
	 *            This parses the file and populates DTO for ellipse
	 */
	public void ellipseDtoBuilder(Iterator i, MutableBoolean malformed, List list) {
		Boolean validationInputFlag = Boolean.TRUE;
		Integer positionX = null;
		Integer positionY = null;
		Integer horizontal = null;
		Integer vertical = null;

		String position = (String) i.next();

		if (position.contains(ConstantFiles.position_X)) {

			positionX = UtilityHelper.extractNumeric(position);
			WidgetValidator widgetValidator = new WidgetValidator();
			validationInputFlag = widgetValidator.validateInteger(positionX, true) && validationInputFlag;
			position = (String) i.next();
		}
		if (position.contains(ConstantFiles.position_Y)) {

			positionY = UtilityHelper.extractNumeric(position);
			WidgetValidator widgetValidator = new WidgetValidator();
			validationInputFlag = widgetValidator.validateInteger(positionY, true) && validationInputFlag;
			position = (String) i.next();
		}

		if (position.contains(ConstantFiles.horizontal)) {

			horizontal = UtilityHelper.extractNumeric(position);
			WidgetValidator widgetValidator = new WidgetValidator();
			validationInputFlag = widgetValidator.validateInteger(horizontal, false) && validationInputFlag;
			position = (String) i.next();

		}
		if (position.contains(ConstantFiles.vertical)) {
			vertical = UtilityHelper.extractNumeric(position);
			WidgetValidator widgetValidator = new WidgetValidator();
			validationInputFlag = widgetValidator.validateInteger(vertical, false) && validationInputFlag;
		}
		if (validationInputFlag) {
			malformed.setFalse();
			ShapeDTO shapeDto = new ShapeDTO();
			shapeDto.setPositionX(positionX);
			shapeDto.setPositionY(positionY);
			shapeDto.setHorizontal(horizontal);
			shapeDto.setVertical(vertical);

			Ellipse ellipse = (Ellipse) WidgetBuilderFactory.build("Ellipse", shapeDto);
			logger.info("ellipse created with attributes " + ellipse.toString());
			EllipseBillables ellipseBillables = new EllipseBillables(ellipse);
			list.add(ellipseBillables.billables());
		} else {
			list.add(ConstantFiles.errorMessage);
		}
	}

	/**
	 * @param i
	 * @param malformed
	 * @param list
	 *            This parses the file and populates DTO for circle
	 */
	public void circleDtoBuilder(Iterator i, MutableBoolean malformed, List list) {
		Boolean validationInputFlag = Boolean.TRUE;
		Integer positionX = null;
		Integer positionY = null;
		Integer diameter = null;
		String position = (String) i.next();

		if (position.contains(ConstantFiles.position_X)) {

			positionX = UtilityHelper.extractNumeric(position);
			WidgetValidator widgetValidator = new WidgetValidator();
			validationInputFlag = widgetValidator.validateInteger(positionX, true) && validationInputFlag;
			position = (String) i.next();
		}
		if (position.contains(ConstantFiles.position_Y)) {
			positionY = UtilityHelper.extractNumeric(position);
			WidgetValidator widgetValidator = new WidgetValidator();
			validationInputFlag = widgetValidator.validateInteger(positionY, true) && validationInputFlag;
			position = (String) i.next();
		}

		if (position.contains(ConstantFiles.diameter)) {
			diameter = UtilityHelper.extractNumeric(position);
			WidgetValidator widgetValidator = new WidgetValidator();
			validationInputFlag = widgetValidator.validateInteger(diameter, false) && validationInputFlag;
		}
		if (validationInputFlag) {
			malformed.setFalse();
			ShapeDTO shapeDto = new ShapeDTO();
			shapeDto.setPositionX(positionX);
			shapeDto.setPositionY(positionY);
			shapeDto.setDiameter(diameter);
			Circle circle = (Circle) WidgetBuilderFactory.build("Circle", shapeDto);
			CircleBillables circleBillable = new CircleBillables(circle);
			list.add(circleBillable.billables());
		} else {
			list.add(ConstantFiles.errorMessage);
		}
	}

	/**
	 * @param i
	 * @param malformed
	 * @param list
	 * @param textOptional
	 *            This parses the file and populates DTO for textBox
	 */
	public void textBoxDtoBuilder(Iterator i, MutableBoolean malformed, List list, MutableBoolean textOptional) {
		Boolean validationInputFlag = Boolean.TRUE;
		Integer positionX = null;
		Integer positionY = null;
		Integer width = null;
		Integer height = null;
		String text = "";
		String position = (String) i.next();

		if (position.contains(ConstantFiles.position_X)) {
			positionX = UtilityHelper.extractNumeric(position);
			WidgetValidator widgetValidator = new WidgetValidator();
			validationInputFlag = widgetValidator.validateInteger(positionX, true) && validationInputFlag;
			position = (String) i.next();
		}
		if (position.contains(ConstantFiles.position_Y)) {
			positionY = UtilityHelper.extractNumeric(position);
			WidgetValidator widgetValidator = new WidgetValidator();
			validationInputFlag = widgetValidator.validateInteger(positionY, true) && validationInputFlag;
			position = (String) i.next();
		}

		if (position.contains(ConstantFiles.width)) {
			width = UtilityHelper.extractNumeric(position);
			WidgetValidator widgetValidator = new WidgetValidator();
			validationInputFlag = widgetValidator.validateInteger(width, false) && validationInputFlag;
			position = (String) i.next();

		}
		if (position.contains(ConstantFiles.height)) {
			height = UtilityHelper.extractNumeric(position);
			WidgetValidator widgetValidator = new WidgetValidator();
			validationInputFlag = widgetValidator.validateInteger(height, false) && validationInputFlag;
			if (i.hasNext()) {
				position = (String) i.next();
				if (position.contains(ConstantFiles.text)) {
					text = UtilityHelper.extractText(position);

				} else {
					textOptional.setTrue();
				}
			}

		}

		if (validationInputFlag) {
			malformed.setFalse();
			ShapeDTO shapeDto = new ShapeDTO();
			shapeDto.setPositionX(positionX);
			shapeDto.setPositionY(positionY);
			shapeDto.setHeight(height);
			shapeDto.setWidth(width);
			shapeDto.setText(text);
			TextBox textBox = (TextBox) WidgetBuilderFactory.build("TextBox", shapeDto);
			TextBoxBillables textBoxBillables = new TextBoxBillables(textBox);
			list.add(textBoxBillables.billables());
		} else {
			list.add(ConstantFiles.errorMessage);
		}
	}

}
