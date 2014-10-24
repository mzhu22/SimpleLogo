package save.load;

import expressionTree.UserFunctionMap;
import expressionTree.VariableNodeMap;

/**
 * Data object that holds all configuration settings of a Slogo session. This includes
 * user-defined variable and functions, background color, turtle types, and other 
 * graphical customizations. Used to pass to/from the FileWriter and FileReaders in 
 * order to write/read configs between sessions.
 * 
 * Passive data object used to encapsulate all config data.
 * @author Mike Zhu
 *
 */
public class SlogoConfigs {
	VariableNodeMap myVariables;
	UserFunctionMap myUserFunctions;
	
}
