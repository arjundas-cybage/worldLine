package cybage.worldLine.uk.widgetBuilders.domain;

import org.apache.log4j.Logger;

/**
 * @author arjund Factory Method Implementation
 */
public class WidgetBuilderFactory {

	final static Logger logger = Logger.getLogger(WidgetBuilderFactory.class);

	/**
	 * @param Type
	 * @param shapeDto
	 * @return Shape Object Factory Method to build Specific Shape Objects
	 */

	public static Shape build(String Type, ShapeDTO shapeDto) {

		switch (Type) {

		case "Rectangle":
			return buildRectangle(shapeDto.positionX, shapeDto.positionY, shapeDto.width, shapeDto.height);
		case "Circle":
			return buildCircle(shapeDto.positionX, shapeDto.positionY, shapeDto.diameter);
		case "Ellipse":
			return buildEllipse(shapeDto.positionX, shapeDto.positionY, shapeDto.horizontal, shapeDto.vertical);
		case "Square":
			return buildSquare(shapeDto.positionX, shapeDto.positionY, shapeDto.width);
		case "TextBox":
			return buildTextBox(shapeDto.positionX, shapeDto.positionY, shapeDto.width, shapeDto.height, shapeDto.text);
		}
		return new Shape();

	}

	/**
	 * @param positionX
	 * @param positionY
	 * @param width
	 * @param height
	 * @return rectangle Object
	 * 
	 */
	private static Rectangle buildRectangle(Integer positionX, Integer positionY, Integer width, Integer height) {
		Rectangle rectangle = new Rectangle(positionX, positionY, width, height);
		logger.info("Rectangle created with attributes " + rectangle.toString());
		return rectangle;
	}

	/**
	 * @param positionX
	 * @param positionY
	 * @param diameter
	 * @return return circle Object
	 */
	private static Circle buildCircle(Integer positionX, Integer positionY, Integer diameter) {
		Circle circle = new Circle(positionX, positionY, diameter);
		logger.info("Circle created with attributes " + circle.toString());
		return circle;

	}

	/**
	 * @param positionX
	 * @param positionY
	 * @param horizontal
	 * @param vertical
	 * @return Ellipse Object
	 */
	private static Ellipse buildEllipse(Integer positionX, Integer positionY, Integer horizontal, Integer vertical) {
		Ellipse ellipse = new Ellipse(positionX, positionY, horizontal, vertical);
		logger.info("Ellipse created with attributes " + ellipse.toString());
		return ellipse;

	}

	/**
	 * @param positionX
	 * @param positionY
	 * @param width
	 * @param height
	 * @param text
	 * @return TextBox Object
	 */
	private static TextBox buildTextBox(Integer positionX, Integer positionY, Integer width, Integer height,
			String text) {
		TextBox textBox = new TextBox(positionX, positionY, width, height, text);
		logger.info("textBox created with attributes " + textBox.toString());
		return textBox;

	}

	/**
	 * @param positionX
	 * @param positionY
	 * @param width
	 * @return Square Object
	 */
	private static Square buildSquare(Integer positionX, Integer positionY, Integer width) {

		Square square = new Square(positionX, positionY, width);
		logger.info("Square created with attributes " + square.toString());
		return square;
	}

}
