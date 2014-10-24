package frontend.ConcreteFeatures;

import javafx.scene.text.Text;
import expressionTree.UserFunctionMap;
import expressionTree.VariableNodeMap;
import frontend.AbstractFeatures.GUIFeatureWithUpdateableScrollPane;

public class CommandsWindow extends GUIFeatureWithUpdateableScrollPane {

	public CommandsWindow(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	@Override
	public void updatePane() {
		
		//very similar to other updateable panes, will be refactored
		UserFunctionMap myFunctions = UserFunctionMap.getUserFunctionNodeMap();
		
		String finalOutput = "Functions \n";
		for(String s : myFunctions.keySet()){
			finalOutput += "\t" + s.toLowerCase() + "\n";
		}
		Text t = new Text(0, 0, finalOutput);
		t.setStyle("-fx-font-size: 14px");
		myWindow.setContent(t);
	}
	
}
