package frontend.ConcreteFeatures;

import expressionTree.VariableNodeMap;
import frontend.AbstractFeatures.SLogoScrollPane;

/**
 * This class represents a pane that displays
 * current user-defined variables and their values.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class CurrentVariablesWindow extends SLogoScrollPane{

	/**
	 * Constructor.
	 * @see SLogoScrollPane#GUIFeatureWithUpdateableScrollPane(double, double, double, double)
	 */
	public CurrentVariablesWindow(double x, double y, double width, double height) {
		super(x, y, width, height, "\t Variables \n");
	}

	/**
	 * {@inheritDoc}
	 * Checks the variable node map
	 * and adds them to the pane.
	 */
	@Override
	public void updatePane() {
		VariableNodeMap myVariables = VariableNodeMap.getVariableNodeMap();
		
		for(String s : myVariables.keySet()){
			finalOutput += s.substring(1).toLowerCase() + "\t" + myVariables.getVariable(s).getValue() + "\n";
		}
		super.updatePane();
	}
	


}
