package cybage.worldLine.uk.widgetBuilders.domain;

public class Rectangle extends Shape {

	/**
	 * @param positionX
	 * @param positionY
	 */
	public Rectangle(Integer positionX, Integer positionY) {
		super(positionX, positionY);

	}

	private Integer width;

	private Integer height;

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
	 * @return the height
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * @param positionX
	 * @param positionY
	 * @param width
	 * @param height
	 */
	public Rectangle(Integer positionX, Integer positionY, Integer width, Integer height) {
		super(positionX, positionY);
		this.width = width;
		this.height = height;
	}

	/**
	 * @param height
	 *            * the height to set
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() See information on rectangle
	 */
	@Override
	public String toString() {

		return super.toString() + "positionX - " + this.positionX + "  position y - " + this.positionY + "  width "
				+ this.width + "  height" + this.height;

	}

}
