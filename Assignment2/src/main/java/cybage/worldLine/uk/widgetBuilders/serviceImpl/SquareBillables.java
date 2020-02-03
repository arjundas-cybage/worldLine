package cybage.worldLine.uk.widgetBuilders.serviceImpl;

import org.apache.log4j.Logger;

import cybage.worldLine.uk.widgetBuilders.domain.ConcreteBillables;
import cybage.worldLine.uk.widgetBuilders.domain.Shape;
import cybage.worldLine.uk.widgetBuilders.domain.Square;

public class SquareBillables extends ConcreteBillables {

	final static Logger logger = Logger.getLogger(SquareBillables.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cybage.worldLink.uk.widgetBuilders.domain.ConcreteBillables#billables()
	 * This does all the billing works
	 * 
	 */
	@Override
	public String billables() {

		logger.info(super.billables() + billWithSquare());
		return super.billables() + billWithSquare();
	}

	public SquareBillables(Shape shape) {
		super(shape);

	}

	/**
	 * @return This does all the billing works for square
	 */
	private String billWithSquare() {

		Square square = (Square) shape;
		return "size=" + square.getWidth();
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
