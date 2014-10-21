package ExpressionTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserFunctionNodeMap {

	private static Map<String, ExpressionNode> userFunctionMap; 
	
	private static UserFunctionNodeMap myUserFunctionNodeMap = new UserFunctionNodeMap();
	
	private UserFunctionNodeMap(){
		userFunctionMap = new HashMap<>(); 
	}
	
	public static ExpressionNode getFunction(String s){
		return userFunctionMap.get(s);
	}
	
	public static boolean contains(String s){
		return userFunctionMap.containsKey(s);
	}
		
	public static UserFunctionNodeMap getUserFunctionNodeMap(){
		return myUserFunctionNodeMap; 
	}

	public static void addFunction(String identifier, ExpressionNode function){
		if(!userFunctionMap.keySet().contains(identifier) ) {
			userFunctionMap.put(identifier, function);
		}
	}

	public void discardVariable(String identifier){
		userFunctionMap.remove(identifier); 
	}
	
	public static Set<String> keySet(){
		return userFunctionMap.keySet(); 
	}
	
}
