package frontend;

import javafx.scene.Node;

public abstract class GUIFeature {
	
	protected double myX;
	protected double myY;
	
	public GUIFeature(double x, double y){
		myX = x;
		myY = y;
	}
	
	public abstract void action();
	
	public abstract Node makeTool();
}
