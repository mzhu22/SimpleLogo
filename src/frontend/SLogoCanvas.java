package frontend;

import static frontend.SLogoWorkspace.GUI_PREFERENCES;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * This class represents the field where the turtle can be and where the lines are drawn.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 */
public class SLogoCanvas extends Canvas {

	private Pane myHolder;
	private GridPane myGrid;
	private Rectangle myBackground;
	private List<Color> myColors;
	
	private static final int SPACE_BETWEEN_GRID_LINES = 10;
	public static final Color START_COLOR = Color.WHITE;
	
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
		
		myBackground.setFill(START_COLOR);
		
		myHolder.getChildren().add(myBackground);
		myHolder.getChildren().add(this);
		myHolder.getChildren().add(myGrid);
		
		setUpColorPalette();
	
	}
	
	/**
	 * Removes all objects of this type from the canvas.
	 * @param o The object to represent the type to remove.
	 */
	public void removeObjects(Object o){
		this.getHolder().getChildren().removeIf(new Predicate<Object>(){
			@Override
			public boolean test(Object t) {
				return t.getClass().equals(o.getClass());
			}
		});
	}
	
	/**
	 * Takes the resource bundle and sets up the 
	 * initial color list to grab from SLogo commands.
	 */
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
	
	/**
	 * Changes the canvas's background.
	 * 
	 * @param c The color to change the background to.
	 */
	public void changeBackground(Color c){
		myBackground.setFill(c);
	}
	
	/**
	 * Changes the canvas's background.
	 * 
	 * @param index The index of the palette list from which to grab the color to change the background to.
	 */
	public void changeBackground(int index)
	{
		this.myBackground.setFill(this.getColor(index));
	}
	
	/**
	 * Adds a color specified by the given r,g,b values to
	 * this particular index in the color list.
	 * 
	 * @param index The index at which to add this particular color in the palette.
	 * @param r The red value 0-255.
	 * @param g The green value 0-255.
	 * @param b The blue value 0-255.
	 */
	public void addColor(double index, int r, int g, int b)
	{
		myColors.add((int) index, Color.rgb(r, g, b));
	}
	
	/**
	 * Gets the color at the index in the palette.
	 * 
	 * @param index The index from which to get the color in the palette.
	 * @return The color at the given index.
	 */
	public Color getColor(int index)
	{
		return this.myColors.get(index);
	}
	
	/**
	 * Gets the holder (pane) that the canvas is in.
	 * 
	 * @return The pane the canvas is in.
	 */
	public Pane getHolder()
	{
		return myHolder;
	}
	
	/**
	 * Toggles whether the grid lines are displayed.
	 */
	public void toggleGridLines(){
		this.myGrid.setGridLinesVisible(!this.myGrid.isGridLinesVisible());
	}
}
