package SLogoControllers;

import java.util.List;

import backend.Parser;
import ExpressionTree.ExpressionNode;


public class InputController {
	private Parser parser = new Parser(); 	
	String input;
	
	public void giveInput(String s){
		input = s; 
		System.out.println(s);

	}
	
	public List<ExpressionNode> getInstructions(){
		return parser.parse(input);
	}
}
