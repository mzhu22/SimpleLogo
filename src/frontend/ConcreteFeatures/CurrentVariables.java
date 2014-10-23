package frontend.ConcreteFeatures;

import ExpressionTree.VariableNodeMap;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import frontend.AbstractFeatures.GUIFeatureWithUpdateableScrollPane;

public class CurrentVariables extends GUIFeatureWithUpdateableScrollPane{

	public CurrentVariables(double x, double y, double width, double height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updatePane() {
		VariableNodeMap myVariables = VariableNodeMap.getVariableNodeMap();
				
		String finalOutput = "Variables \n";
		for(String s : myVariables.keySet()){
			finalOutput += "\t" + s.substring(1) + "\t" + myVariables.getVariable(s).getInfo() + "\n";
		}
		Text t = new Text(0, 0, finalOutput);
		t.setStyle("-fx-font-size: 16px");
		myWindow.setContent(t);
	}
	


}
