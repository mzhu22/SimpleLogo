package frontend;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Turtle {
	
	public static final double DEGREES_TO_RADIANS_FACTOR = Math.PI / 180;
	private static final double WIDTH = 30;
	private static final double HEIGHT = 30;
	
	private double myX;
	private double myY;
	private double myDirection; //0 is right, 90 up, 180 left, 270 down
	
	private ImageView myImage;
	
	private Canvas myCanvas;
	private Pen myPen;
	
	private boolean myShowTurtle;
	
	private double myInitX;
	private double myInitY;
	private String myInitImage;
	
	private LineDrawer myDrawer;
	
	
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
		
		
		
		Image image = new Image(getClass().getResourceAsStream("../" + startImage));
        myImage = new ImageView();
        myImage.setImage(image);
        
        
		myImage.setFitHeight(HEIGHT);
		myImage.setFitWidth(WIDTH);
			
		((SLogoCanvas) myCanvas).getHolder().getChildren().add(myImage);
		
		myImage.setX(startX - (myImage.getFitWidth() / 2));
		myImage.setY(startY - (myImage.getFitHeight() / 2));
		
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
		
		
		myImage.setX(myX - (myImage.getFitWidth() / 2));
		myImage.setY(myY - (myImage.getFitHeight() / 2));
		
		return value;
		
	}

	public double rotate(double value){ //positive value are rotating left
		
		myDirection += value;
		handleDirection();
		
		myImage.setRotate(myImage.getRotate() - (value%360));
		
		return value;
	}
	
	private void handleDirection(){
		myDirection %= 360;
		if(myDirection < 0){
			myDirection += 360;
		}
	}
	
	public void changeImage(String newImage){
		
		Image image = new Image(getClass().getResourceAsStream("../" + newImage));
        myImage.setImage(image);
        
	}
	
	public void setDirection(double dir){
		myImage.setRotate(-dir + 90);
		myDirection = dir;
		handleDirection();
	}
	
	public double getDirection(){
		return myDirection;
	}
	
	public void goToCoord(double x, double y){
		myX = x;
		myY = y;
		myImage.setX(myX - (myImage.getFitWidth() / 2));
		myImage.setY(myY - (myImage.getFitHeight() / 2));
		
	}
	
	public void resetPosition(){
		goToCoord(myInitX, myInitY);
	}
	
	public void resetImage(){
		changeImage(myInitImage);
	}
	
	public void showTurtle(){
		myShowTurtle = true;
		myImage.setVisible(myShowTurtle);
	}
	public void hideTurtle(){
		myShowTurtle = false;
		myImage.setVisible(myShowTurtle);
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

}
