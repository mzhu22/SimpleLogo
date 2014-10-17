package frontend;

public class GUIChooseLineStyle extends GUIFeatureWithDropDown {

	private SLogoCanvas myCanvas;
	
	public GUIChooseLineStyle(double x, double y, SLogoCanvas canvas) {
		super(x, y);
		myCanvas = canvas;
		myPromptText = "Select Line Style";
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
