package frontend.ConcreteFeatures;

import static frontend.GUIMaker.EPU;

import java.io.IOException;

import save.load.FileWriter;
import frontend.AbstractFeatures.SLogoButton;

/**
 * 
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class LoadVariablesButton extends SLogoButton {

	public LoadVariablesButton(double x, double y, String buttonName) {
		super(x, y, buttonName);
	}

	@Override
	public void action() {
		FileWriter writer = new FileWriter();
		try {
			writer.readFromFile();
		} catch (ClassNotFoundException | IOException e) {
			EPU.display("No file found", true);
		}
	}

}
