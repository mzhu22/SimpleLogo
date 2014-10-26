package frontend.ConcreteFeatures;

import expressionTree.UserFunctionMap;
import frontend.AbstractFeatures.SLogoScrollPane;

/**
 * This class represents a pane that displays the currently
 * available user-defined commands.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class CommandsWindow extends SLogoScrollPane {

	/**
	 * Constructor.
	 * 
	 * @see SLogoScrollPane#GUIFeatureWithUpdateableScrollPane(double, double, double, double)
	 */
	public CommandsWindow(double x, double y, double width, double height) {
		super(x, y, width, height, "\t Functions \n");
	}

	/**
	 * {@inheritDoc}
	 * Checks the user defined function map and 
	 * adds all to the pane.
	 */
	@Override
	public void updatePane() {
		UserFunctionMap myFunctions = UserFunctionMap.getUserFunctionNodeMap();
		
		for(String s : myFunctions.keySet()){
			finalOutput += s.toLowerCase() + "\n";
		}
		super.updatePane();
	}
	
}
