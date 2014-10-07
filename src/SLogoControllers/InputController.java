package SLogoControllers;

import java.util.List;

import ExpressionTree.ExpressionNode;

public class InputController {
	
	String input;
	
	public void giveInput(String s){
		input = s; 
		System.out.println(s);

	}
	
	public List<ExpressionNode> getInstructions(){
		//return parse(input);
		return null;
	}
}
