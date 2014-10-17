package frontend;

import java.io.File;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ChangeActionObjectImageButton extends GUIFeatureWithButton {

	ActionObject myObject;
	
	public ChangeActionObjectImageButton(double x, double y, String buttonName, ActionObject obj) {
		super(x, y, buttonName);
		myObject = obj;
		
	}

	@Override
	public void action() {
		
		
		
		
		
		FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir") +"/src/images"));
        File file = fileChooser.showOpenDialog(new Stage());
		
        if(file != null && file.isFile()){
        	myObject.changeImage(correctFormat(file.toString()));
        }
	}
	
	private String correctFormat(String s){
		//Kinda hardcoded
		
		int idx = s.indexOf("images");
		return s.substring(idx);
	}

}
