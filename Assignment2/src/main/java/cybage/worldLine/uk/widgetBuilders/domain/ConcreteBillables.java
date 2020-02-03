package cybage.worldLine.uk.widgetBuilders.domain;

import org.apache.log4j.Logger;

import cybage.worldLine.uk.widgetBuilders.utility.ConstantFiles;

/**
 * @author arjund
 *
 */
public class ConcreteBillables {

	final static Logger logger = Logger.getLogger(ConcreteBillables.class);

	/**
	 * @param shape
	 *            Constructor to build Concrete Shape
	 */
	public ConcreteBillables(Shape shape) {
		super();
		this.shape = shape;
	}

	protected Shape shape;

	/**
	 * @return Implementation of Concrete parent billable method
	 * 
	 */
	public String billables() {

		String typeName = shape.getClass().getTypeName();
		String widgetType = null;

		switch (typeName) {
		case "cybage.worldLine.uk.widgetBuilders.domain.Rectangle":
			widgetType = "Rectangle";
			break;
		case "cybage.worldLine.uk.widgetBuilders.domain.Circle":
			widgetType = "Circle";
			break;
		case "cybage.worldLine.uk.widgetBuilders.domain.Square":
			widgetType = "Square";
			break;
		case "cybage.worldLine.uk.widgetBuilders.domain.Ellipse":
			widgetType = "Ellipse";

			break;
		case "cybage.worldLine.uk.widgetBuilders.domain.TextBox":
			widgetType = "Textbox";
			break;

		default:
			widgetType = ConstantFiles.errorMessage;
			logger.error(ConstantFiles.errorMessage);
		}

		if (widgetType.equalsIgnoreCase(ConstantFiles.errorMessage))
			return ConstantFiles.errorMessage;

		return widgetType + "(" + shape.positionX + "," + shape.positionY + ")";

	}

}
