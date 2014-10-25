package frontend;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import static frontend.SLogoTab.CANVAS_HEIGHT;
import static frontend.SLogoTab.CANVAS_WIDTH;

public class Turtle {
	
	public static final double DEGREES_TO_RADIANS_FACTOR = Math.PI / 180;
	public static final double IMAGE_WIDTH = 30;
	public static final double IMAGE_HEIGHT = 30;
	public static final String TURTLE_DEFAULT_IMAGE = "images/arrow_red.png";
	private static final int TURTLE_DEFAULT_Y = CANVAS_HEIGHT/2;
	private static final int TURTLE_DEFAULT_X = CANVAS_WIDTH/2;
	
	
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
	
	public Turtle(Canvas canvas){
		this(TURTLE_DEFAULT_X, TURTLE_DEFAULT_Y, TURTLE_DEFAULT_IMAGE, canvas);
	}
	
	
	public Turtle(double startX, double startY, String startImage, Canvas canvas){
		myX = startX;
		myY = startY;
		myCanvas = canvas;
		
		myPen = new Pen();
		
		myInitX = startX;
		myInitY = startY;
		myInitImage = startImage;

		myShowTurtle = true;
		
		myDirection = 90; //START FACING UP
		
		isActive = true;
		
		Image image = new Image(getClass().getResourceAsStream("../" + startImage));
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
		
		myContainer.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> toggleState());
		
	}
	
	private void toggleState(){
		this.setActive(!this.getIsActive());
		handleActiveOutline();
	}
	
	
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

	public double rotate(double value){ //positive value are rotating left
		
		myDirection += value;
		handleDirection();
		
		myContainer.setRotate(myContainer.getRotate() - (value%360));
		
		return value;
	}
	
	private void handleDirection(){
		myDirection %= 360;
		if(myDirection < 0){
			myDirection += 360;
		}
	}
	
	public void handleActiveOutline(){
		String styleInner = "";
		if(isActive){
			styleInner = "-fx-border-color: green;"
		              + "-fx-border-width: 2;"
		              + "-fx-border-style: solid;";
		}
		else{
			styleInner = "-fx-border-color: red;"
		              + "-fx-border-width: 2;"
		              + "-fx-border-style: solid;";
		}
		myContainer.setStyle(styleInner);
	}
	
	public void changeImage(String newImage){
		
		Image image = new Image(getClass().getResourceAsStream("../images/" + newImage));
        myImage.setImage(image);
        
	}
	
	public void stamp(){
		Stamp stamp = new Stamp(myX, myY, myDirection,  myImage.getImage());
		((SLogoCanvas) myCanvas).getHolder().getChildren().add(stamp);
		
	}
	
	public void setDirection(double dir){
		myContainer.setRotate(-dir + 90);
		myDirection = dir;
		handleDirection();
	}
	
	public double getDirection(){
		return myDirection;
	}
	
	public void goToCoord(double x, double y){
		myX = x;
		myY = y;
		myContainer.setLayoutX(myX - (myContainer.getWidth() / 2));
		myContainer.setLayoutY(myY - (myContainer.getHeight() / 2));
		
	}
	
	public void resetPosition(){
		goToCoord(myInitX, myInitY);
	}
	
	public void resetImage(){
		changeImage(myInitImage);
	}
	
	public void showTurtle(){
		myShowTurtle = true;
		myContainer.setVisible(myShowTurtle);
	}
	public void hideTurtle(){
		myShowTurtle = false;
		myContainer.setVisible(myShowTurtle);
	}
	
	
	public Pen getPen(){
		return myPen;
	}
	
	public boolean isShowing(){
		return myShowTurtle; 
	}
	
	public double getX(){
		return myX; 
	}

	public double getY(){
		return myY; 
	}
	
	public boolean getIsActive(){
		return isActive;
	}
	
	public void setActive(boolean active){
		isActive = active;
		handleActiveOutline();
	}

}
