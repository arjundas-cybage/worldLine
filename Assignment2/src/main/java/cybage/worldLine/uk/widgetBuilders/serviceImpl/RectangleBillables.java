package cybage.worldLine.uk.widgetBuilders.serviceImpl;

import org.apache.log4j.Logger;

import cybage.worldLine.uk.widgetBuilders.domain.ConcreteBillables;
import cybage.worldLine.uk.widgetBuilders.domain.Rectangle;
import cybage.worldLine.uk.widgetBuilders.domain.Shape;

public class RectangleBillables extends ConcreteBillables {

	final static Logger logger = Logger.getLogger(RectangleBillables.class);

	public RectangleBillables(Shape shape) {
		super(shape);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cybage.worldLink.uk.widgetBuilders.domain.ConcreteBillables#billables()
	 * This does all the billing work
	 */
	@Override
	public String billables() {

		logger.info(super.billables() + billWithRectangles());
		return super.billables() + billWithRectangles();
	}

	/**
	 * @return Billing specific to rectangle
	 */
	private String billWithRectangles() {

		Rectangle rectangle = (Rectangle) shape;
		return "width=" + rectangle.getWidth() + " height=" + rectangle.getHeight();
	}

	/**
	 * @return the shape
	 */
	public Shape getShape() {
		return shape;
	}

	/**
	 * @param shape
	 *            the shape to set
	 */
	public void setShape(Shape shape) {
		this.shape = shape;
	}

}
