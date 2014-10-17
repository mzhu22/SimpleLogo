package frontend;

import java.io.File;

import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ActionObject {
	
	private static final double DEGREES_TO_RADIANS_FACTOR = Math.PI / 180;
	private static final double WIDTH = 30;
	private static final double HEIGHT = 30;
	
	
	private double myX;
	private double myY;
	private double myDirection; //0 is right, 90 up, 180 left, 270 down
	
	private ImageView myImage;
	
	private Canvas myCanvas;
	
	private boolean myIsPenDown;
	private boolean myShowTurtle;
	
	private double myInitX;
	private double myInitY;
	private String myInitImage;
	
	
	public ActionObject(double startX, double startY, String startImage, Canvas canvas){
		myX = startX;
		myY = startY;
		myCanvas = canvas;
		
		myInitX = startX;
		myInitY = startY;
		myInitImage = startImage;
		
		myIsPenDown = true;
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
		
		if(myX - myImage.getFitWidth()/2 <= 0){
			myX += myCanvas.getWidth();
		}
		if(myX + myImage.getFitWidth()/2 >= myCanvas.getWidth()){
			myX -= myCanvas.getWidth();
		}
		
		if(myY - myImage.getFitHeight()/2 <= 0){
			myY += myCanvas.getHeight();
		}
		if(myY + myImage.getFitHeight()/2 >= myCanvas.getHeight()){
			myY -= myCanvas.getHeight();
		}
		
		Point2D newPosition = new Point2D(myX, myY);
		
		makeLine(oldPosition, newPosition);
		
		myImage.setX(myX - (myImage.getFitWidth() / 2));
		myImage.setY(myY - (myImage.getFitHeight() / 2));
		
		return value;
		
	}


	/**
	 * @param oldPosition
	 * @param newPosition
	 */
	private void makeLine(Point2D oldPosition, Point2D newPosition) {
		if(myIsPenDown){
			((SLogoCanvas) myCanvas).drawLine(oldPosition, newPosition);
		}
	}
	
	public double rotate(double value){ //positive value are rotating left
		
		myDirection += (value%360);
		
		myImage.setRotate(myImage.getRotate() - (value%360));
		
		return value;
	}
	
	public void changeImage(String newImage){
		
		Image image = new Image(getClass().getResourceAsStream("../" + newImage));
        myImage.setImage(image);
        
	}
	
	public void setDirection(double dir){
		myImage.setRotate(-dir + 90);
		myDirection = dir;
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
	
	
	public void penUp(){
		myIsPenDown = false;
	}
	public void penDown(){
		myIsPenDown = true;
	}
	
	public void showTurtle(){
		myShowTurtle = true;
		myImage.setVisible(myShowTurtle);
	}
	public void hideTurtle(){
		myShowTurtle = false;
		myImage.setVisible(myShowTurtle);
	}

	
	public boolean isPenDown(){
		return myIsPenDown; 
	}

	
	public boolean isTurtle(){
		return myShowTurtle; 
	}
	
	
	
	public double getX(){
		return myX; 
	}

	public double getY(){
		return myY; 
	}
	
	
	
}
