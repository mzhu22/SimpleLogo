package frontend.ConcreteFeatures;

import static frontend.GUIMaker.EPU;

import java.io.IOException;
import save.load.CustomReaderWriter;

import frontend.AbstractFeatures.GUIFeatureWithButton;

public class SaveVariablesButton extends GUIFeatureWithButton {

	public SaveVariablesButton(double x, double y, String buttonName) {
		super(x, y, buttonName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action() {
		CustomReaderWriter writer = new CustomReaderWriter();
		try {
			writer.writeToFile();
		} catch (IOException e) {
			EPU.display("Error writing variables to disk", true);
			e.printStackTrace();
		}
	}

}
