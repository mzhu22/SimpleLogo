package frontend.ConcreteFeatures;

import frontend.SLogoCanvas;
import frontend.AbstractFeatures.GUIFeatureWithDropDown;

public class GUIChooseLineStyle extends GUIFeatureWithDropDown {

	private SLogoCanvas myCanvas;
	
	public GUIChooseLineStyle(double x, double y, String prompt, SLogoCanvas canvas) {
		super(x, y, prompt);
		myCanvas = canvas;
	}

	@Override
	public void doDropDownClickAction(String chosen) {
		myCanvas.setLineStyle(chosen);

	}

	@Override
	public void fillItemList() {
		myItems.add("Solid");
		myItems.add("Dashed");
		myItems.add("Dotted");
	}

}
