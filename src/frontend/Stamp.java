package frontend;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static frontend.Turtle.IMAGE_WIDTH;
import static frontend.Turtle.IMAGE_HEIGHT;

/**
 * This class represents a stamp on the screen made by a turtle. 
 * It is the turtle's image put into place at the position the turtle
 * was at when it stamped.
 * 
 * This is a passive data object; the reason we chose to differentiate it
 * from an ImageView is so that we can easily remove all stamps
 * from the canvas using a Predicate that removes all of a certain
 * class. We could not simply remove all ImageView's since the actual
 * turtles are graphically represented by ImageView's as well.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class Stamp extends ImageView{

	/**
	 * 
	 * Constructor with parameters.
	 * 
	 * @param x The x position of the stamp.
	 * @param y The y position of the stamp.
	 * @param direction The direction of the stamp.
	 * @param im The image of the stamp.
	 */
	public Stamp(double x, double y, double direction, Image im){
		super(im);
		this.setX(x - IMAGE_WIDTH/2);
		this.setY(y - IMAGE_HEIGHT/2);
		this.setRotate(-direction + 90);
		this.setFitHeight(IMAGE_HEIGHT);
		this.setFitWidth(IMAGE_WIDTH);
	}

	/**
	 * Constructor with no parameters. We needed a null
	 * constructor in order to get a class type in the ClearStamps
	 * command.
	 */
	public Stamp() {
		//Intentionally left blank.
	}
}
