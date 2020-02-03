package cybage.worldLine.uk.widgetBuilders.serviceImpl;

import org.apache.log4j.Logger;

import cybage.worldLine.uk.widgetBuilders.domain.ConcreteBillables;
import cybage.worldLine.uk.widgetBuilders.domain.Ellipse;
import cybage.worldLine.uk.widgetBuilders.domain.Shape;

/**
 * @author arjund
 *
 */
public class EllipseBillables extends ConcreteBillables {

	final static Logger logger = Logger.getLogger(EllipseBillables.class);

	public EllipseBillables(Shape shape) {
		super(shape);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cybage.worldLink.uk.widgetBuilders.domain.ConcreteBillables#billables()
	 * This does the complete billables
	 * 
	 */
	@Override
	public String billables() {

		logger.info(super.billables() + billWithEllipse());
		return super.billables() + billWithEllipse();
	}

	/**
	 * @return billing specific to ecllipse
	 * 
	 */

	private String billWithEllipse() {

		Ellipse ellipse = (Ellipse) shape;
		return "diameterH = " + ellipse.getHorizontal() + " diameterV = " + ellipse.getVertical();
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
