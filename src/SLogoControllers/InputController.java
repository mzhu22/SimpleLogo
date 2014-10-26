package SLogoControllers;

import java.util.List;

import backend.Parser;
import expressionTree.ExpressionNode;
import frontend.Translator;



public class InputController {
	private Parser parser = new Parser(); 	
	String input;
	private Translator myTranslator;
	
	public InputController(Translator t){
		myTranslator = t;
	}
	
	public InputController(){
		this(new Translator());
	}
	
	public void giveInput(String s){
		input = myTranslator.translate(s);
//		System.out.println(input);
	}
	
	public List<ExpressionNode> getInstructions(){
		return parser.parse(input);
	}
}
