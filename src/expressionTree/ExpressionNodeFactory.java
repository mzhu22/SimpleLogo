package expressionTree;

import java.util.Stack;

import commandAbstractClasses.*;
import errorsAndExceptions.ErrorPopUp;

/**
 * Class called by ExpressionTreeBuilder that takes in a String representing user-input 
 * Slogo code, returns a set of ExpressionNodes used to build the tree.
 * 
 * Contains code to parse two special cases:
 * 1) Left and right brackets indicating sections of code used in Repeat and user-defined
 * functions
 * 2) Variables identified by a colon, e.g. :b
 * 
 * ExpressionNode objects are created using reflection. Throws up error window when 
 * unrecognized commands are entered. 
 * @author Mike Zhu
 *
 */
public final class ExpressionNodeFactory {

	private VariableNodeMap myVariables = VariableNodeMap.getVariableNodeMap();
	private UserFunctionMap myUserFunctions = UserFunctionMap.getUserFunctionNodeMap();


	private String[] myPackages = { "commandAbstractClasses", 
			"comparators",
			"controlStructures",
			"displayCommands",
			"expressionTree",
			"mathOperations",
			"turtleQueries"};


	public  Stack<ExpressionNode> getAllNodes(String s){
		int balance = 0; 
		Stack<ExpressionNode> returnNodes = new Stack<ExpressionNode>();

		String[] split = s.trim().split(" "); 

		for(String string : split ){

			//Case for code organized in brackets (e.g., for repeats)
			if(string.matches("ListStart") && balance == 0){
				balance ++ ; 	
				returnNodes.push(new ListNode());
			}
			else if(string.matches("ListEnd")){
				balance -- ; 				
			}
			else{
				if( balance == 0 ){
					returnNodes.push(getNode(string)); 
				}
				else  {				
					ListNode list = (ListNode) returnNodes.peek();
					list.add(string);
				}
			}

		}
		return returnNodes;
	}


	private ExpressionNode getNode( String s){

		ExpressionNode toReturn; 
		double constant =0; 

		if(s.startsWith(":")) return variableHandler(s); 

		try{
			constant = Double.parseDouble(s); 
		}
		catch(NumberFormatException e ){	

			try {
				return commandHandler(s);
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		}

		toReturn = new Constant(); 
		toReturn.setValue(constant); 
		return toReturn; 

	}

	private ExpressionNode commandHandler(String command) throws InstantiationException, IllegalAccessException{
		//For the extraodinary case of the Random command, which is already a Java
		//class
		if(command.equals("Random")){
			command = "SlogoRandom";
		}
		
		ExpressionNode node = null;

		for(String packageName : myPackages){
			String className = packageName + "." + command;

			try {
				Class<?> c = Class.forName(className);
				node = (ExpressionNode) c.newInstance();
			} catch (ClassNotFoundException e) {
				continue;
			}
		}
		if(node == null){
			userError("Unrecognized command");
			return new doNothing();
		}
		return node;
	}

	public ExpressionNode variableHandler(String s){
		return myVariables.getVariable(s); 
	}
	
	public void userError(String s){
		ErrorPopUp error = new ErrorPopUp();
		error.display(s);
	}
}