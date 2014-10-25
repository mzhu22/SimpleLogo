package expressionTree;

import java.util.Stack;

import commandAbstractClasses.*;

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
		toReturn.setInfo(constant); 
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
			node = new doNothing();
			System.out.println(command);
		}
		return node;
	}

	public ExpressionNode variableHandler(String s){
		return myVariables.getVariable(s); 
	}

	/**
	 * Called when Logo word is not one of the built-in commands. 
	 * When word comes after the To command, either:
	 * 	a. Adds word to the UserFunctionMap 
	 * 	b. Throws error if the word is already in UserFunctionMap
	 * 
	 * When word is called as its own instruction, checks UserFunctionMap and
	 * 	a. Returns ListNode representing that command
	 * 	b. Throws error if the command was not found
	 * 
	 * @param s == Logo word input
	 * @return
	 */
	public ExpressionNode unknownFunctionHandler(String s){
		if(myUserFunctions.contains(s)){
			return myUserFunctions.getFunction(s);
		}
		
		return new doNothing(s);
	}
}
