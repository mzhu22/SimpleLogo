package frontend;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class ActionObject {
	
	private static final double DEGREES_TO_RADIANS_FACTOR = Math.PI / 180;
	private double myX;
	private double myY;
	private double myDirection; //0 is right, 90 up, 180 left, 270 down
	
	private Image myImage;
	
	private Canvas myCanvas;
	
	private boolean myIsPenDown;
	private boolean myShowTurtle;
	
	
	public ActionObject(double startX, double startY, Image startImage, Canvas canvas){
		myX = startX;
		myY = startY;
		myCanvas = canvas;
		
		myIsPenDown = true;
		myShowTurtle = true;
		
		myDirection = 0;
	}
	
	
	public int move(int value){
	
		Point2D oldPosition = new Point2D(myX, myY);
		
		
		myX += (value * Math.cos(myDirection * DEGREES_TO_RADIANS_FACTOR));
		myY -= (value * Math.sin(myDirection * DEGREES_TO_RADIANS_FACTOR));
		//MINUS since normal xy plane has positive y as up; here positive y is down
		
		Point2D newPosition = new Point2D(myX, myY);
		
		if(myIsPenDown){
			((SLogoCanvas) myCanvas).drawLine(oldPosition, newPosition);
		}
		
		return value;
		
	}
	
	public int rotate(int value){ //positive value are rotating left
		
		myDirection += value;
		if(myDirection >= 360) myDirection -= 360;
		if(myDirection < 0) myDirection += 360;
		
		return value;
	}
	
	public void changeImage(){
		
	}
	
	
	public void penUp(){
		myIsPenDown = false;
	}
	public void penDown(){
		myIsPenDown = true;
	}
	
	public void showTurtle(){
		myShowTurtle = true;
	}
	public void hideTurtle(){
		myShowTurtle = false;
	}
	
	
	
}
