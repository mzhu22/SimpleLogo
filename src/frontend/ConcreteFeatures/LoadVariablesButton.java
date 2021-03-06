package frontend.ConcreteFeatures;

import static frontend.GUIMaker.EPU;

import java.io.IOException;

import save.load.FileWriter;
import frontend.AbstractFeatures.SLogoButton;
import save.load.CustomReaderWriter;

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
		CustomReaderWriter writer = new CustomReaderWriter();
		try {
			writer.readFromFile();
		} catch (ClassNotFoundException | IOException e) {
			EPU.display("No file found", true);
		}
	}

}
