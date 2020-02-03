package cybage.worldLine.uk.widgetBuilders.serviceImpl;

import org.apache.log4j.Logger;

import cybage.worldLine.uk.widgetBuilders.domain.ConcreteBillables;
import cybage.worldLine.uk.widgetBuilders.domain.Shape;
import cybage.worldLine.uk.widgetBuilders.domain.TextBox;

/**
 * @author arjund
 *
 */
public class TextBoxBillables extends ConcreteBillables {

	final static Logger logger = Logger.getLogger(TextBoxBillables.class);

	public TextBoxBillables(Shape shape) {
		super(shape);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cybage.worldLink.uk.widgetBuilders.domain.ConcreteBillables#billables()
	 * This does all the billing works *
	 */

	@Override
	public String billables() {

		logger.info(super.billables() + billWithTextBox());
		return super.billables() + billWithTextBox();
	}

	/**
	 * @return This does TextBox Specific Work
	 * 
	 */
	private String billWithTextBox() {

		TextBox textBox = (TextBox) shape;
		return "width=" + textBox.getWidth() + " height=" + textBox.getHeight() + " text=" + textBox.getText();
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
