package ExpressionTree;

import java.util.Stack;

import CommandAbstractClasses.Constant;
import Comparators.And;
import Comparators.Equal;
import Comparators.Greater;
import Comparators.Less;
import Comparators.Not;
import Comparators.NotEqual;
import Comparators.Or;
import MathOperations.Add;
import MathOperations.Arctan;
import MathOperations.Cosine;
import MathOperations.Difference;
import MathOperations.Log;
import MathOperations.Minus;
import MathOperations.Power;
import MathOperations.Product;
import MathOperations.Quotient;
import MathOperations.Randoms;
import MathOperations.Remainder;
import MathOperations.Sine;
import MathOperations.Tangent;
import controlStructures.Make;
import controlStructures.Repeat;
import controlStructures.To;
import displayCommands.Back;
import displayCommands.Forward;
import displayCommands.HideTurtle;
import displayCommands.Left;
import displayCommands.PenDown;
import displayCommands.PenUp;
import displayCommands.Right;
import displayCommands.ShowTurtle;

public final class ExpressionNodeFactory {

	private VariableNodeMap myVariables = VariableNodeMap.getVariableNodeMap();
	private UserFunctionNodeMap myUserFunctions = UserFunctionNodeMap.getUserFunctionNodeMap();
		
	
	public  Stack<ExpressionNode> getAllNodes(String s){
		int balance = 0; 
		Stack<ExpressionNode> returnNodes = new Stack<ExpressionNode>();

		String[] split = s.trim().split(" "); 

		for(String string : split ){

			//Case for code organized in brackets (e.g., for repeats)
			if(string.matches("\\[") && balance == 0){
				balance ++ ; 	
				returnNodes.push(new ListNode());
			}
			else if(string.matches("\\]")){
				balance -- ; 				
			}
			else{
				if( balance == 0 ){
					returnNodes.push(getNode(string)); 
				}
				else  {				
					ListNode list = (ListNode) returnNodes.peek();
					list.add(string);
					//returnNodes.push(list);
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
			
			return commandHandler(s);
		}

		toReturn = new Constant(); 
		toReturn.setInfo(constant); 
		return toReturn; 

	}

	private ExpressionNode commandHandler(String s) {
		switch (s) {
			//Display Node
			case "FORWARD" : case "FD": return new Forward();
			
			case "RIGHT" : case "RT" : return new Right();
			
			case "PENUP" : case "PU": return new PenUp();
			
			case "PENDOWN" : case "PD": return new PenDown();
			
			case "BACK" : case "BK" : return new Back();
			
			case "LEFT" : case "LT" : return new Left();
			
			case "SHOWTURTLE" : case "ST" : return new ShowTurtle();
			
			case "HIDETURTLE" : case "HT" : return new HideTurtle();
			
			case "SUM" : case  "+": return new Add(); 

			case "DIFFERENCE" : case "-": return new Difference(); 

			case "PRODUCT" : case "*" : return new Product(); 

			case "QUOTIENT" : case "/" : return new Quotient(); 

			case "REMAINDER" : case "%" : return new Remainder(); 

			case "MINUS" : case "~": return new Minus(); 

			case "RANDOM" : return new Randoms();

			case "SIN" : return new Sine(); 

			case "COS" : return new Cosine(); 

			case "TAN" : return new Tangent(); 

			case "ATAN" : return new Arctan(); 

			case "LOG" : return new Log(); 

			case "POW" : return new Power(); 

			case "AND" : return new And(); 

			case "OR" : return new Or(); 

			case "NOT" : return new Not(); 

			case "NOTEQUAL?" : case "NOTEQUALP" :return new NotEqual(); 

			case "EQUAL?" : case "EQUALP" :return new Equal(); 

			case "GREATER?" : case "GREATERP" :return new Greater(); 

			case "LESS?" : case  "LESSP" : return new Less(); 
			
			case "REPEAT" : return new Repeat();

			case "MAKE" : return new Make(); 
			
			case "TO" : return new To();
						
			default: return unknownFunctionHandler(s); 

		}
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
