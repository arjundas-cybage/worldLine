package cybage.worldLine.uk.widgetBuilders.domain;

/**
 * @author arjund
 *
 */
public class Circle extends Shape {

	private Integer diameter;

	/**
	 * @param positionX
	 * @param positionY
	 */
	public Circle(Integer positionX, Integer positionY) {
		super(positionX, positionY);
	}

	/**
	 * @return the diameter
	 */
	public Integer getDiameter() {
		return diameter;
	}

	/**
	 * @param diameter
	 *            the diameter to set
	 */
	public void setDiameter(Integer diameter) {
		this.diameter = diameter;
	}

	/**
	 * @param positionX
	 * @param positionY
	 * @param diameter
	 */
	public Circle(Integer positionX, Integer positionY, Integer diameter) {
		super(positionX, positionY);
		this.diameter = diameter;
	}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
		
		return	super.toString()+ "positionX - "  +this.positionX + "  position y - " +this.positionY + "  diameter "  + this.diameter  ;
		
		
	
		
	}
}
