package expressionTree;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * Class that holds all user-defined variables. Contains Map variable that maps String
 * identifier for each variable to a VariableNode object.. 
 * 
 * Class follows Singleton pattern as there should only be one map ever initialized, and 
 * several classes on the backend require access to user-defined variables.
 * 
 * Class implements Serializable so that it can be written to a file using FileOutputStream,
 * then read to enable save/load of user defined variables.
 * @author Mike Zhu
 *
 */
public class VariableNodeMap implements Serializable{

	private static final long serialVersionUID = 1L;

	private Map<String, VariableNode> variableMap; 
	
	private static VariableNodeMap myVariableNodeMap = new VariableNodeMap();
	
	private VariableNodeMap(){
		variableMap = new HashMap<String, VariableNode>(); 
	}
	
	public VariableNode getVariable(String variableName){
		addVariable(variableName); 
		return variableMap.get(variableName); 
	} 
		
	public static VariableNodeMap getVariableNodeMap(){
		return myVariableNodeMap; 
	}

	private void addVariable(String identifier){
		if(!variableMap.keySet().contains(identifier) ) {
			variableMap.put(identifier, new VariableNode());
		}
	}

	public void discardVariable(String identifier){
		variableMap.remove(identifier); 
	}
	
	public Set<String> keySet(){
		return variableMap.keySet(); 
	}
	
	public void applyLoadedMap(VariableNodeMap loadedMap){
		myVariableNodeMap = loadedMap;
	}
	
}
