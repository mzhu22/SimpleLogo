package frontend.ConcreteFeatures;

import java.io.File;

import frontend.Turtle;
import frontend.AbstractFeatures.GUIFeatureWithDropDown;

public class GUIChooseImage extends GUIFeatureWithDropDown{
	
	private Turtle myTurtle;
	
	protected final static String IMAGE_FOLDER_NAME = "src/images/";
	protected final static int IMAGE_FOLDER_NAME_LENGTH = IMAGE_FOLDER_NAME.length();
	
	
	public GUIChooseImage(double x, double y, String prompt, Turtle turtle) {
		super(x, y, prompt);
		myTurtle = turtle;
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
		
		/* WILL NEED \ INSTEAD FOR WINDOWS?????*/
		
		
		myTurtle.changeImage("images/" + chosen);
		
	}
}