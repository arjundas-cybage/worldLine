package cybage.worldLine.uk.widgetBuilders.domain;

/**
 * @author arjund
 *
 */
public class TextBox extends Shape {

	private Integer width;

	private String text;

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
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the height
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}

	/**
	 * @param positionX
	 * @param positionY
	 * @param width
	 * @param height
	 * @param text
	 */
	public TextBox(Integer positionX, Integer positionY, Integer width, Integer height, String text) {
		super(positionX, positionY);
		this.width = width;
		this.text = text;
		this.height = height;
	}

	private Integer height;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() displays information of the object
	 * 
	 */
	@Override
	public String toString() {

		return super.toString() + "positionX - " + this.positionX + "  position y - " + this.positionY + "  width "
				+ this.width + "  height" + this.height + "  Text-" + this.text;

	}

}
