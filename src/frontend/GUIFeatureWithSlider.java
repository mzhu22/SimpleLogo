/**
 * This class represents a GUIFeature that uses a slider to interact.
 * 
 * @author Safkat Islam
 * @author Chris Bernt
 */
package frontend;

import javafx.scene.Group;
import javafx.scene.Node;
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
	 * @see frontend.GUIFeature#action()
	 */
	@Override
	public void action() {
		
	}

	/**
	 * @see frontend.GUIFeature#makeTool()
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
