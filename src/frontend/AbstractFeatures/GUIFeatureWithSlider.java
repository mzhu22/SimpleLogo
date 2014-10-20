/**
 * This class represents a GUIFeature that uses a slider to interact.
 * 
 * @author Safkat Islam
 * @author Chris Bernt
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
	 * @see frontend.GUIFeature@action()
	 */
	public GUIFeatureWithSlider(double x, double y, int min, int max, int startValue) {
		super(x, y);
		myMin = min;
		myMax = max;
		myStart = startValue;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see frontend.AbstractFeatures.GUIFeature#action()
	 */
	@Override
	public void action() {
		
	}

	/**
	 * @see frontend.AbstractFeatures.GUIFeature#makeTool()
	 */
	@Override
	public Group makeTool() {
		Group g = new Group();
		slider = new Slider(myMin, myMax, myStart);
		g.getChildren().add(slider);
		slider.getValue();
		return g;
		
	}
	
	public double getSliderValue(){
		return slider.getValue();
	}

}
