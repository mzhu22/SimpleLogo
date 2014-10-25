package frontend.ConcreteFeatures;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import expressionTree.VariableNodeMap;
import frontend.AbstractFeatures.GUIFeatureWithUpdateableScrollPane;

public class CurrentVariables extends GUIFeatureWithUpdateableScrollPane{

	public CurrentVariables(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	@Override
	public void updatePane() {
		VariableNodeMap myVariables = VariableNodeMap.getVariableNodeMap();
				
		String finalOutput = "Variables \n";
		for(String s : myVariables.keySet()){
			finalOutput += "\t" + s.substring(1).toLowerCase() + "\t" + myVariables.getVariable(s).getValue() + "\n";
		}
		Text t = new Text(0, 0, finalOutput);
		t.setStyle("-fx-font-size: 14px");
		myWindow.setContent(t);
	}
	


}
