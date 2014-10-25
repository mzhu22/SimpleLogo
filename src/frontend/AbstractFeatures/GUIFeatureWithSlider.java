/**
 * This class represents a GUIFeature that uses a slider to interact.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 */

package frontend.AbstractFeatures;

import javafx.scene.Group;
import javafx.scene.control.Slider;

public abstract class GUIFeatureWithSlider extends GUIFeature {

	private int myMin;
	private int myMax;
	private int myStart;
	private Slider slider;
	
	/**
	 * @see GUIFeature#GUIFeature(double, double)
	 * 
	 * @param min The minimum value of the slider.
	 * @param max The maximum value of the slider.
	 * @param startValue The start value of the slider.
	 */
	public GUIFeatureWithSlider(double x, double y, int min, int max, int startValue) {
		super(x, y);
		myMin = min;
		myMax = max;
		myStart = startValue;
		// TODO Auto-generated constructor stub
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void action() {
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Group makeTool() {
		Group g = new Group();
		slider = new Slider(myMin, myMax, myStart);
		g.getChildren().add(slider);
		slider.getValue();
		return g;
		
	}
	
	/**
	 * Get the value from the slider and return it.
	 * @return The value of the slider at its current position.
	 */
	public double getSliderValue(){
		return slider.getValue();
	}
}
