package frontend;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GUIChooseImage extends GUIFeatureWithDropDown{
	
	private ActionObject myTurtle;
	
	protected final static String IMAGE_FOLDER_NAME = "src/images/";
	protected final static int IMAGE_FOLDER_NAME_LENGTH = IMAGE_FOLDER_NAME.length();
	
	
	public GUIChooseImage(double x, double y, String prompt, ActionObject turtle) {
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
