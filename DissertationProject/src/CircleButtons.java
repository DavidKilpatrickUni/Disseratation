import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

/**
 * <h1> Class </h1>
 * 
 * <p>
 * Utility Layer of the Tiered architecture structure.
 * </p>
 * 
 * <p>
 * CircleButtons
 * </p>
 * 
 * <p>
 * CircleButtons class that stores methods/process/tasks for generating circler shaped swing buttons.
 * <br> Only currently used for Profile button but is hoped there could be wider use of of this throughout design
 * </p>
 * 
 *
 */

	public class CircleButtons implements Border {

		// Variables
		
	    private int radius;
 
	    
	    // Constructors
		
		// Overloaded
		
		/**
		 * <h1> Constructor </h1>
		 * 
		 * <p>
		 * Default constructor for the <code>CircleButtons</code> class. 
		 * </p>
		 * 
		 * <p>
		 * Constructor to change a Jbutton from rectangle shape to circle shape based on the parameter passed.
		 * </p>
		 * 
		 * <p>
		 * Parameter is the desired radius of the swing button being adjusted. A <code>Integer</code> object is used to store the data.
		 * </p>
		 * 
		 * @param radius		<code>Integer</code> object to store radius (How circler) information.
		 * 
		 * @see CircleButtons
		 * @see Integer

		 */
	    
	    CircleButtons(int radius) {
	        
	    	this.radius = radius;
	    	
	    }
	    
		/**
		 * <h1> Method </h1>
		 * <p>
		 * Method for setting up custom insets for the newly created circle shaped button.
		 * </p>
		 * 
		 * <p>
		 * Parameter is the component of GUI being adjusted. A <code>Component</code> object is used to store the data.
		 * </p>
		 * 
		 * @param circle		<code>Component</code> object to store component that is being adjusted.
		 *
		 * @see CircleButtons
		 * @see Component
		 */
	    public Insets getBorderInsets(Component circle) {
	       
	    	return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	    	
	    }
	    
	    
		/**
		 * <h1> Method </h1>
		 * <p>
		 * Method for designing the border of the newly created circle shaped button.
		 * </p>
		 * <p>
		 * Parameter is the component of GUI being adjusted. A <code>Component</code> object is used to store the data.
		 * <br> Parameter is the abstract Graphics class of GUI being adjusted. A <code>Graphics</code> object is used to store the data.
		 * <br> Parameter is the x-axis information. A <code>Integer</code> object is used to store the data.
		 * <br> Parameter is the y-axis information. A <code>Integer</code> object is used to store the data.
		 * <br> Parameter is the width information. A <code>Integer</code> object is used to store the data.
		 * <br> Parameter is the height information. A <code>Integer</code> object is used to store the data.
		 * </p>
		 * 
		 * @param circle		<code>Component</code> object to store component that is being adjusted. 
		 * @param graphic		<code>Graphics</code> object to store graphic abstract that is being adjusted. 
		 * @param x				<code>Integer</code> object to store x-axis information. 
		 * @param y				<code>Integer</code> object to store y-axis information. 
		 * @param width			<code>Integer</code> object to store width information. 
		 * @param height		<code>Integer</code> object to store height information. 
		 *
		 * @see CircleButtons
		 * @see Integer
		 * @see Graphic
		 * @see Component
		 */
	    public void paintBorder(Component circle, Graphics graphic, int x, int y, int width, int height) {
	       
	    	graphic.drawRoundRect(x, y, width-1, height-1, radius, radius);
	    
	    }
	    
		/**
		 * <h1> Method </h1>
		 * <p>
		 * Method for setting the 'Opaque' value of newly created circle button.
		 * </p>
		 * 
		 *
		 * @see CircleButtons
		 */

		public boolean isBorderOpaque() {

			return false;
		}
	    
	}
	

