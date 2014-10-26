package frontend;

import static frontend.SLogoWorkspace.CANVAS_HEIGHT;
import static frontend.SLogoWorkspace.CANVAS_WIDTH;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 * This class represents the turtle object, handling the 
 * data and the graphical rendering. We chose to not
 * separate this class into frontend and backend since
 * each turtle object would need one of each. See BothTurtle
 * for a prototype of how the refactored class would have looked.
 * We did not think the new design was any better. 
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class Turtle {
	
	private static final String IMAGE_DIRECTORY = "../images/";
	private static final String BORDER_RED = "-fx-border-color: red;";
	private static final String BORDER_SOLID = "-fx-border-style: solid;";
	private static final String BORDER_WIDTH = "-fx-border-width: 2;";
	private static final String BORDER_GREEN = "-fx-border-color: green;";
	public static final double DEGREES_TO_RADIANS_FACTOR = Math.PI / 180;
	public static final double IMAGE_WIDTH = 30;
	public static final double IMAGE_HEIGHT = 30;
	public static final String TURTLE_DEFAULT_IMAGE = "arrow_red.png";
	private static final int TURTLE_DEFAULT_Y = CANVAS_HEIGHT/2;
	private static final int TURTLE_DEFAULT_X = CANVAS_WIDTH/2;
	public static final int TURTLE_DEFAULT_DIRECTION = 90;
	
	private double myX;
	private double myY;
	private double myDirection; //0 is right, 90 up, 180 left, 270 down
	private ImageView myImage;
	private HBox myContainer;
	private Canvas myCanvas;
	private Pen myPen;
	private boolean myShowTurtle;
	private double myInitX;
	private double myInitY;
	private String myInitImage;
	private LineDrawer myDrawer;
	private boolean isActive;
	private int myID;
		
	/**
	 * Constructor
	 * 
	 * @param startX The initial X-Coordinate of the turtle
	 * @param startY The initial Y-Coordinate of the turtle
	 * @param startImage The initial image of the turtle, represented by a string
	 * @param canvas The canvas this turtle is placed on
	 * @param id The ID of this turtle
	 */
	public Turtle(double startX, double startY, String startImage, Canvas canvas, int id){
		myX = startX;
		myY = startY;
		myCanvas = canvas;
		
		myPen = new Pen();
		
		myInitX = startX;
		myInitY = startY;
		myInitImage = startImage;

		myShowTurtle = true;
		
		myDirection = TURTLE_DEFAULT_DIRECTION; //START FACING UP
		
		isActive = true;
		
		myID = id; 
		
		Image image = new Image(getClass().getResourceAsStream(IMAGE_DIRECTORY + startImage));
        myImage = new ImageView();
        myImage.setImage(image);
        myContainer = new HBox();
        myContainer.setPrefSize(IMAGE_WIDTH, IMAGE_HEIGHT);
        
		myImage.setFitHeight(IMAGE_HEIGHT);
		myImage.setFitWidth(IMAGE_WIDTH);
			
		((SLogoCanvas) myCanvas).getHolder().getChildren().add(myImage);
		
		myContainer.setLayoutX(myX - (IMAGE_WIDTH / 2));
		myContainer.setLayoutY(myY - (IMAGE_HEIGHT / 2));
		myContainer.getChildren().add(myImage);
		((SLogoCanvas) myCanvas).getHolder().getChildren().add(myContainer);
		
		handleActiveOutline();
		
		myContainer.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> toggleActive());
		
	}
	
	/**
	 * Shortened Constructor
	 * @param canvas The canvas the turtle is placed on
	 * @param id The ID of the turtle
	 */
	public Turtle(Canvas canvas, int id){
		this(TURTLE_DEFAULT_X, TURTLE_DEFAULT_Y, TURTLE_DEFAULT_IMAGE, canvas, id);
	}
	
	/**
	 * Toggles whether this turtle is active or not.
	 */
	private void toggleActive(){
		this.setActive(!this.getIsActive());
		handleActiveOutline();
	}
	
	/**
	 * This method handles linear turtle motion.
	 * 
	 * @param value The amount this turtle should move forward.
	 * @return The amount moved
	 */
	public double move(double value){
	
		Point2D oldPosition = new Point2D(myX, myY);
		
		
		myX += (value * Math.cos(myDirection * DEGREES_TO_RADIANS_FACTOR));
		myY -= (value * Math.sin(myDirection * DEGREES_TO_RADIANS_FACTOR));
		//MINUS since normal xy plane has positive y as up; here positive y is down
		
		myDrawer = new LineDrawer(this, ((SLogoCanvas) myCanvas).getHolder());
		Point2D curPosition = myDrawer.draw(oldPosition);
		myX = curPosition.getX();
		myY = curPosition.getY();
		
		myContainer.setLayoutX(myX - (myContainer.getWidth() / 2));
		myContainer.setLayoutY(myY - (myContainer.getHeight() / 2));
		
		return value;	
	}

	/**
	 * This method handles turtle rotation.
	 * @param value The number of degrees to rotate left.
	 * @return The degrees turned
	 */
	public double rotate(double value){ //positive value are rotating left
		
		myDirection += value;
		handleDirection();
		
		myContainer.setRotate(myContainer.getRotate() - (value%360));
		
		return value;
	}
	
	/**
	 * Helper method to make sure direction is
	 * always within 0-360 degrees
	 */
	private void handleDirection(){
		myDirection %= 360;
		if(myDirection < 0){
			myDirection += 360;
		}
	}
	
	/**
	 * Adds the correct border around a turtle
	 * based on activeness.
	 */
	public void handleActiveOutline(){
		String styleInner = "";
		if(isActive){
			styleInner = BORDER_GREEN + BORDER_WIDTH + BORDER_SOLID;
		}
		else{
			styleInner = BORDER_RED + BORDER_WIDTH + BORDER_SOLID;
		}
		myContainer.setStyle(styleInner);
	}
	
	/**
	 * Changes the turtle's image.
	 * 
	 * @param newImage The String representing the new image
	 */
	public void changeImage(String newImage){
		Image image = new Image(getClass().getResourceAsStream(IMAGE_DIRECTORY + newImage));
        myImage.setImage(image);
        
	}
	
	/**
	 * Places a stamp of the turtle on the canvas.
	 */
	public void stamp(){
		Stamp stamp = new Stamp(myX, myY, myDirection,  myImage.getImage());
		((SLogoCanvas) myCanvas).getHolder().getChildren().add(stamp);
		
	}
	
	/**
	 * Sets the turtle's heading/direction.
	 * 
	 * @param dir The direction to face.
	 */
	public void setDirection(double dir){
		myContainer.setRotate(-dir + 90);
		myDirection = dir;
		handleDirection();
	}
	
	/**
	 * @return The turtle's current heading/direction.
	 */
	public double getDirection(){
		return myDirection;
	}
	
	/**
	 * Sets the turtle's location.
	 * @param x X-Coordinate of new location
	 * @param y Y-Coordinate of new Location
	 */
	public void goToCoord(double x, double y){
		myX = x;
		myY = y;
		myContainer.setLayoutX(myX - (myContainer.getWidth() / 2));
		myContainer.setLayoutY(myY - (myContainer.getHeight() / 2));
		
	}
	
	/**
	 * Sets turtle's position to its initial position.
	 */
	public void resetPosition(){
		goToCoord(myInitX, myInitY);
	}
	
	/**
	 * Sets turtle's image to its initial image.
	 */
	public void resetImage(){
		changeImage(myInitImage);
	}
	
	/**
	 * Makes the turtle's image displayed on the canvas.
	 */
	public void showTurtle(){
		myShowTurtle = true;
		myContainer.setVisible(myShowTurtle);
	}
	
	/**
	 * Makes the turtle's image not displayed on the canvas.
	 */
	public void hideTurtle(){
		myShowTurtle = false;
		myContainer.setVisible(myShowTurtle);
	}
	
	/**
	 * @return The turtle's pen.
	 */
	public Pen getPen(){
		return myPen;
	}
	
	/**
	 * @return Whether the turtle's image is being displayed on the canvas.
	 */
	public boolean isShowing(){
		return myShowTurtle; 
	}
	
	/**
	 * @return The X-Coordinate of the turtle.
	 */
	public double getX(){
		return myX; 
	}

	/**
	 * @return The Y-Coordinate of the turtle.
	 */
	public double getY(){
		return myY; 
	}
	
	/**
	 * @return Whether the turtle is active.
	 */
	public boolean getIsActive(){
		return isActive;
	}
	
	/**
	 * Sets the turtle's activeness.
	 * @param active Whether the turtle is active
	 */
	public void setActive(boolean active){
		isActive = active;
		handleActiveOutline();
	}

	/**
	 * @return The turtle's ID
	 */
	public int getID()
	{
		return myID;
	}
}
