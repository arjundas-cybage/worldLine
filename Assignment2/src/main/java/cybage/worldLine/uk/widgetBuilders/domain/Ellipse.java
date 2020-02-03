package cybage.worldLine.uk.widgetBuilders.domain;

/**
 * @author arjund
 *
 */
public class Ellipse extends Shape {

	/**
	 * @param positionX
	 * @param positionY
	 */
	public Ellipse(Integer positionX, Integer positionY) {
		super(positionX, positionY);
	}

	/**
	 * @return the vertical
	 */
	public Integer getVertical() {
		return vertical;
	}

	/**
	 * @param vertical
	 *            the vertical to set
	 */
	public void setVertical(Integer vertical) {
		this.vertical = vertical;
	}

	/**
	 * @return the horizontal
	 */
	public Integer getHorizontal() {
		return horizontal;
	}

	/**
	 * @param horizontal
	 * 
	 */
	public void setHorizontal(Integer horizontal) {
		this.horizontal = horizontal;
	}

	private Integer vertical;

	private Integer horizontal;

	/**
	 * @param positionX
	 * @param positionY
	 * @param vertical
	 * @param horizontal
	 *            Ellipse Constructor
	 */
	public Ellipse(Integer positionX, Integer positionY, Integer vertical, Integer horizontal) {
		super(positionX, positionY);
		this.vertical = vertical;
		this.horizontal = horizontal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() contains information on same Displays
	 * object attributes
	 */
	@Override
	public String toString() {
		return super.toString() + "positionX - " + this.positionX + "  position y - " + this.positionY
				+ "  Vertical Diameter " + this.vertical + "  Horizontal Diameter" + this.horizontal;
	}
}
