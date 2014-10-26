package frontend.ConcreteFeatures;

import javafx.scene.text.Text;
import expressionTree.UserFunctionMap;
import frontend.AbstractFeatures.GUIFeatureWithUpdateableScrollPane;

/**
 * This class represents a pane that displays the currently
 * available user-defined commands.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class CommandsWindow extends GUIFeatureWithUpdateableScrollPane {

	/**
	 * Constructor.
	 * 
	 * @see GUIFeatureWithUpdateableScrollPane#GUIFeatureWithUpdateableScrollPane(double, double, double, double)
	 */
	public CommandsWindow(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	/**
	 * {@inheritDoc}
	 * Checks the user defined function map and 
	 * adds all to the pane.
	 */
	@Override
	public void updatePane() {
		
		//very similar to other updateable panes, will be refactored
		UserFunctionMap myFunctions = UserFunctionMap.getUserFunctionNodeMap();
		
		String finalOutput = "\t Functions \n";
		for(String s : myFunctions.keySet()){
			finalOutput += s.toLowerCase() + "\n";
		}
		Text t = new Text(0, 0, finalOutput);
		t.setStyle("-fx-font-size: 14px");
		myWindow.setContent(t);
	}
	
}
