package cybage.worldLine.uk.widgetBuilders.domain;


/**
 * @author arjund
 *
 */
public class Shape {
	
	/**
	 * Constructor Call to super
	 */
	public Shape() {
		super();
	}
	Integer positionX ;
    Integer positionY ;
	/**
	 * @return the positionX
	 */
	public Integer getPositionX() {
		return positionX;
	}
	/**
	 * @param positionX the positionX to set
	 */
	public void setPositionX(Integer positionX) {
		this.positionX = positionX;
	}
	/**
	 * @return the positionY
	 */
	public Integer getPositionY() {
		return positionY;
	}
	/**
	 * @param positionY the positionY to set
	 */
	public void setPositionY(Integer positionY) {
		this.positionY = positionY;
	}
	/**
	 * @param positionX
	 * @param positionY
	 */
	public Shape(Integer positionX, Integer positionY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
	}
    
    
    
    
}
