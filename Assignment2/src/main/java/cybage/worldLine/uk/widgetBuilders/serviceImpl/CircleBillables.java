package cybage.worldLine.uk.widgetBuilders.serviceImpl;

import org.apache.log4j.Logger;

import cybage.worldLine.uk.widgetBuilders.domain.Circle;
import cybage.worldLine.uk.widgetBuilders.domain.ConcreteBillables;
import cybage.worldLine.uk.widgetBuilders.domain.Shape;

/**
 * @author arjund
 *
 */
public class CircleBillables extends ConcreteBillables {

	final static Logger logger = Logger.getLogger(CircleBillables.class);

	public CircleBillables(Shape shape) {
		super(shape);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cybage.worldLink.uk.widgetBuilders.domain.ConcreteBillables#billables()
	 * 
	 * This does all the calculation for billing.
	 * 
	 */

	@Override
	public String billables() {

		logger.info(super.billables() + billWithcircle());
		return super.billables() + billWithcircle();
	}

	/**
	 * @return
	 */
	private String billWithcircle() {

		Circle circle = (Circle) shape;
		return "size=" + circle.getDiameter();
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
