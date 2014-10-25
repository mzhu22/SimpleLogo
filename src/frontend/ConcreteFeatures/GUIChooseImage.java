package frontend.ConcreteFeatures;

import java.io.File;

import frontend.Turtle;
import frontend.TurtleCollection;
import frontend.AbstractFeatures.GUIFeatureWithDropDown;

public class GUIChooseImage extends GUIFeatureWithDropDown{
	private TurtleCollection myTurtleCollection;
	
	protected final static String IMAGE_FOLDER_NAME = "src/images/";
	protected final static int IMAGE_FOLDER_NAME_LENGTH = IMAGE_FOLDER_NAME.length();
	
	
	public GUIChooseImage(double x, double y, String prompt, TurtleCollection turtles) {
		super(x, y, prompt);
		myTurtleCollection = turtles;
	}

	@Override
	public void fillItemList(){
		File[] files = new File(IMAGE_FOLDER_NAME).listFiles();
		
		for (File file : files) {
			myItems.add(file.toString().substring(
					file.toString().indexOf(IMAGE_FOLDER_NAME) + IMAGE_FOLDER_NAME_LENGTH,
					file.toString().length()));
		}
	}

	@Override
	public void doDropDownClickAction(String chosen) {
		for(Turtle t : myTurtleCollection)
		{
			t.changeImage("images/" + chosen);
		}
		
	}
}
