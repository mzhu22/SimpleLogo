package ExpressionTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import CommandAbstractClasses.VariableNode;

public class VariableNodeMap {

	
	private Map<String, VariableNode> variableMap; 
	
	private static VariableNodeMap myVariableNodeMap = new VariableNodeMap();
	
	private VariableNodeMap(){
		variableMap = new HashMap<String, VariableNode>(); 
		// 
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
	
}
