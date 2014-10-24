package SLogoControllers;

import java.util.List;

import frontend.Translator;
import ExpressionTree.ExpressionNode;
import backend.Parser;



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
		
	}
	
	public List<ExpressionNode> getInstructions(){
		return parser.parse(input);
	}
}
