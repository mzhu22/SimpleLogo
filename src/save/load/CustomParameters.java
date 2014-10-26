package save.load;

import java.io.Serializable;

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
public class CustomParameters implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7170346785388768928L;
	private VariableNodeMap myVariables;
	private UserFunctionMap myUserFunctions;	
	
	public CustomParameters(VariableNodeMap vars, UserFunctionMap funcs){
		myVariables = vars;
		myUserFunctions = funcs;
	}
	
	public VariableNodeMap getVariables(){
		return myVariables;
	}
	
	public UserFunctionMap getFunctions(){
		return myUserFunctions;
	}
}
