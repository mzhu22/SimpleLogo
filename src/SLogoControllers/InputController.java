package SLogoControllers;

import java.util.List;

import expressionTree.ExpressionNode;
import backend.Parser;



public class InputController {
	private Parser parser = new Parser(); 	
	String input;
	
	public void giveInput(String s){
		input = s; 
	}
	
	public List<ExpressionNode> getInstructions(){
		return parser.parse(input);
	}
}
