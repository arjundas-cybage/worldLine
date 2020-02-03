package cybage.worldLine.uk.widgetBuilders.domain;

/**
 * @author arjund
 *
 */
public class Square extends Shape {

	private Integer width;

	/**
	 * @return the width
	 */
	public Integer getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}

	/**
	 * @param positionX
	 * @param positionY
	 * @param width
	 */
	public Square(Integer positionX, Integer positionY, Integer width) {
		super(positionX, positionY);
		this.width = width;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() shows values of square
	 */
	@Override
	public String toString() {

		return super.toString() + "positionX - " + this.positionX + "  position y - " + this.positionY + "  width "
				+ this.width;

	}

}
