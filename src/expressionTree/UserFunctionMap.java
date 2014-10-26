package expressionTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserFunctionMap {

	private Map<String, ListNode> userFunctionMap; 
	
	private static UserFunctionMap myUserFunctionNodeMap = new UserFunctionMap();
	
	private UserFunctionMap(){
		userFunctionMap = new HashMap<>(); 
	}
	
	public ExpressionNode getFunction(String s){
//		addFunction(s); 
		return userFunctionMap.get(s);
	}
	
	public boolean contains(String s){
		return userFunctionMap.containsKey(s);
	}
		
	public static UserFunctionMap getUserFunctionNodeMap(){
		return myUserFunctionNodeMap; 
	}

//	public void addFunction(String identifier){
//		if(!userFunctionMap.keySet().contains(identifier) ) {
//			userFunctionMap.put(identifier, new UserFunction());
//		}
//	}
	
	public void addFunction(String identifier, ListNode commands){
		if(!userFunctionMap.keySet().contains(identifier) ) {
			userFunctionMap.put(identifier, commands);
		}
	}

	public void discardFunction(String identifier){
		userFunctionMap.remove(identifier); 
	}
	
	public Set<String> keySet(){
		return userFunctionMap.keySet(); 
	}
	
}
