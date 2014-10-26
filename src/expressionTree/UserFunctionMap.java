package expressionTree;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * Class that holds all user-defined functions. Contains Map variable that maps String
 * identifier for each function to a ListNode. 
 * 
 * Class follows Singleton pattern as there should only be one map ever initialized, and 
 * several classes on the backend require access to the map.
 * 
 * Class implements Serializable so that it can be written to a file using FileOutputStream,
 * then read to enable save/load of user defined functions.
 * @author Mike Zhu
 *
 */
public class UserFunctionMap implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1897103858901701660L;

	private Map<String, ListNode> userFunctionMap; 
	
	private static UserFunctionMap myUserFunctionMap = new UserFunctionMap();
	
	private UserFunctionMap(){
		userFunctionMap = new HashMap<>(); 
	}
	
	public ExpressionNode getFunction(String s){
		return userFunctionMap.get(s);
	}
	
	public boolean contains(String s){
		return userFunctionMap.containsKey(s);
	}
		
	public static UserFunctionMap getUserFunctionMap(){
		return myUserFunctionMap; 
	}
	
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
	
	public void applyLoadedMap(UserFunctionMap loadedMap){
		myUserFunctionMap = loadedMap;
	}
	
}
