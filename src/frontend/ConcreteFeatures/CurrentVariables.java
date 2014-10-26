package frontend.ConcreteFeatures;

import javafx.scene.text.Text;
import expressionTree.VariableNodeMap;
import frontend.AbstractFeatures.GUIFeatureWithUpdateableScrollPane;

/**
 * This class represents a pane that displays
 * current user-defined variables and their values.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class CurrentVariables extends GUIFeatureWithUpdateableScrollPane{

	/**
	 * Constructor.
	 * @see GUIFeatureWithUpdateableScrollPane#GUIFeatureWithUpdateableScrollPane(double, double, double, double)
	 */
	public CurrentVariables(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	/**
	 * {@inheritDoc}
	 * Checks the variable node map
	 * and adds them to the pane.
	 */
	@Override
	public void updatePane() {
		VariableNodeMap myVariables = VariableNodeMap.getVariableNodeMap();
				
		String finalOutput = "\t Variables \n";
		for(String s : myVariables.keySet()){
			finalOutput += s.substring(1).toLowerCase() + "\t" + myVariables.getVariable(s).getValue() + "\n";
		}
		Text t = new Text(0, 0, finalOutput);
		t.setStyle("-fx-font-size: 14px");
		myWindow.setContent(t);
	}
	


}
