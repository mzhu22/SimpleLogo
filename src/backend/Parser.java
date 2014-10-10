package backend;

import java.util.ArrayList;
import java.util.List;

import ExpressionTree.ExpressionNode;
import ExpressionTree.ExpressionTreeBuilder;

public class Parser {
	private List<ExpressionNode> commandsForFrontEnd = new ArrayList<>(); 
	private ExpressionTreeBuilder maker; 
	
	public List<ExpressionNode>  parse (String input){
		input = input.toUpperCase();
		maker = new ExpressionTreeBuilder(input); 
		commandsForFrontEnd.addAll( maker.getOutputList()); 
		return commandsForFrontEnd; 
	}
	
}
