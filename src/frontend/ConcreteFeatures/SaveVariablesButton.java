package frontend.ConcreteFeatures;

import static frontend.GUIMaker.EPU;

import java.io.IOException;

import save.load.FileWriter;
import frontend.AbstractFeatures.SLogoButton;

public class SaveVariablesButton extends SLogoButton {

	public SaveVariablesButton(double x, double y, String buttonName) {
		super(x, y, buttonName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action() {
		FileWriter writer = new FileWriter();
		try {
			writer.writeToFile();
		} catch (IOException e) {
			EPU.display("Error writing variables to disk", true);
			e.printStackTrace();
		}
	}

}
