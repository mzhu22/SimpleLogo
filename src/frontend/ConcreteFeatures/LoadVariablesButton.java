package frontend.ConcreteFeatures;

import static frontend.GUIMaker.EPU;

import java.io.IOException;

import save.load.CustomReaderWriter;
import frontend.AbstractFeatures.GUIFeatureWithButton;

public class LoadVariablesButton extends GUIFeatureWithButton {

	public LoadVariablesButton(double x, double y, String buttonName) {
		super(x, y, buttonName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		CustomReaderWriter writer = new CustomReaderWriter();
		try {
			writer.readFromFile();
		} catch (ClassNotFoundException | IOException e) {
			EPU.display("No file found", true);
		}
	}

}
