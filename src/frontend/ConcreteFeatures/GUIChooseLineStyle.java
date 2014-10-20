package frontend.ConcreteFeatures;

import frontend.Pen;
import frontend.AbstractFeatures.GUIFeatureWithDropDown;

public class GUIChooseLineStyle extends GUIFeatureWithDropDown {

	private Pen myPen;
	
	public GUIChooseLineStyle(double x, double y, String prompt, Pen pen) {
		super(x, y, prompt);
		myPen = pen;
	}

	@Override
	public void doDropDownClickAction(String chosen) {
		myPen.setLineStyle(chosen);

	}

	@Override
	public void fillItemList() {
		myItems.add("Solid");
		myItems.add("Dashed");
		myItems.add("Dotted");
	}

}
