package frontend.ConcreteFeatures;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import frontend.SLogoCanvas;
import frontend.AbstractFeatures.GUIFeatureWithButton;

/**
 * Concrete feature that allows a user to change the 
 * canvas's background color.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class ChangeBackgroundButton extends GUIFeatureWithButton{

	private Canvas myCanvas;
	private ColorPicker myColorPicker;
	
	/**
	 * 
	 * @see GUIFeatureWithButton#GUIFeatureWithButton(double, double, String)
	 * @param node The Canvas to change the background of.
	 * @param cp The color picker object to get the chosen color from.
	 */
	public ChangeBackgroundButton(double x, double y, String buttonName, SLogoCanvas canvas, ColorPicker cp) {
		super(x, y, buttonName);
		myCanvas = canvas;
		myColorPicker = cp;
		
	}
	
	/**
	 * {@inheritDoc}
	 * Changes the background color of the canvas.
	 */
	@Override
	public void action(){	
		((SLogoCanvas) myCanvas).changeBackground(this.myColorPicker.getValue());
	}
	
	

}
