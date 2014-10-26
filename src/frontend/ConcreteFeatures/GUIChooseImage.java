package frontend.ConcreteFeatures;

import java.io.File;

import frontend.Turtle;
import frontend.TurtleCollection;
import frontend.AbstractFeatures.GUIFeatureWithDropDown;

/**
 * This class represents drop down box that allows
 * the user to choose an image for the turtle.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class GUIChooseImage extends GUIFeatureWithDropDown{
	private TurtleCollection myTurtleCollection;
	
	protected final static String IMAGE_FOLDER_NAME = "src/images/";
	protected final static int IMAGE_FOLDER_NAME_LENGTH = IMAGE_FOLDER_NAME.length();
	
	/**
	 * 
	 * @see GUIFeatureWithDropDown#GUIFeatureWithDropDown(double, double, String)
	 * @param turtles The collection of turtles to change the image for.
	 */
	public GUIChooseImage(double x, double y, String prompt, TurtleCollection turtles) {
		super(x, y, prompt);
		myTurtleCollection = turtles;
	}

	/**
	 * {@inheritDoc}
	 * Fills the drop down with images from
	 * the images folder.
	 */
	@Override
	public void fillItemList(){
		File[] files = new File(IMAGE_FOLDER_NAME).listFiles();
		
		for (File file : files) {
			myItems.add(file.toString().substring(
					file.toString().indexOf(IMAGE_FOLDER_NAME) + IMAGE_FOLDER_NAME_LENGTH,
					file.toString().length()));
		}
	}

	/**
	 * {@inheritDoc}
	 * Changes the image to the selected one.
	 * @param chosen The chosen String from the drop down.
	 */
	@Override
	public void doDropDownClickAction(String chosen) {
		myTurtleCollection.setActiveTurtles();
		for(Turtle t : myTurtleCollection)
		{
			t.changeImage(chosen);
		}
		
	}
}
