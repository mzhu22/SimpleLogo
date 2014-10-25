/**
 * This class represents the field where the turtle can be and where the lines are drawn.
 * 
 * @author Safkat Islam
 * @author Chris Bernt
 */

package frontend;

import java.util.ArrayList;

import java.util.List;
import java.util.function.Predicate;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import static frontend.SLogoTab.GUI_PREFERENCES;

public class SLogoCanvas extends Canvas {

	private Pane myHolder;
	private GridPane myGrid;
	private Rectangle myBackground;
	private List<Color> myColors;
	
	private static final int SPACE_BETWEEN_GRID_LINES = 10;
	/**
	 * Constructor. 
	 * 
	 * @param width The width of the drawing area.
	 * @param height The height of the drawing area.
	 * @param x The x-Coordinate of the drawing area.
	 * @param y The y-Coordinate of the drawing area.
	 */
	public SLogoCanvas(double width, double height, double x, double y) {
		super(width, height);

		myColors = new ArrayList<Color>();
		myHolder = new Pane();
		myHolder.setLayoutX(x);
		myHolder.setLayoutY(y);
		myHolder.setPrefHeight(height);
		myHolder.setPrefWidth(width);
		
		
		myGrid = new GridPane();
		myGrid.setPrefHeight(height);
		myGrid.setPrefWidth(width);
		
		
		for(int i = 0; i < width/SPACE_BETWEEN_GRID_LINES; i++){
			myGrid.getColumnConstraints().add(new ColumnConstraints(SPACE_BETWEEN_GRID_LINES));			
		}
		for(int i = 0; i < height/SPACE_BETWEEN_GRID_LINES; i++){
			myGrid.getRowConstraints().add(new RowConstraints(SPACE_BETWEEN_GRID_LINES));			
		}
		
		
		myGrid.setGridLinesVisible(false);
		
		myBackground = new Rectangle(0,0,width, height);
		
		myBackground.setFill(Color.WHITE);
		
		myHolder.getChildren().add(myBackground);
		myHolder.getChildren().add(this);
		myHolder.getChildren().add(myGrid);
		
		setUpColorPalette();
	
	}
	
	public void removeObjects(Object o){
		this.getHolder().getChildren().removeIf(new Predicate<Object>(){
			@Override
			public boolean test(Object t) {
				return t.getClass().equals(o.getClass());
			}
		});
	}
	
	public void setUpColorPalette(){
		String[] colors = GUI_PREFERENCES.getString("StartingPalettes").split(";");
		for(String s : colors){
			String[] rgbVals = s.split(",");
			List<Integer> rgbs = new ArrayList<Integer>();
			for(String val : rgbVals){
				rgbs.add(Integer.parseInt(val.trim()));
			}
			this.myColors.add(Color.rgb(rgbs.get(0), rgbs.get(1), rgbs.get(2)));
		}
	}
	
	public void changeBackground(Color c){
		myBackground.setFill(c);
	}
	
	public void changeBackground(int index)
	{
		this.myBackground.setFill(this.getColor(index));
	}
	
	public void addColor(double index, int r, int g, int b)
	{
		myColors.add((int) index, Color.rgb(r, g, b));
	}
	
	public Color getColor(int index)
	{
		return this.myColors.get(index);
	}
	
	public Pane getHolder()
	{
		return myHolder;
	}
	
	public void toggleGridLines(){
		this.myGrid.setGridLinesVisible(!this.myGrid.isGridLinesVisible());
	}
}
