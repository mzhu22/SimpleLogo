package backend;


/**
 * @author Dimeji Abidoye
 * Class that takes in front end inputs and returns front end actionables
 *
 */


import java.util.ArrayList;
import java.util.List;

import expressionTree.ExpressionNode;
import expressionTree.ExpressionTreeBuilder;

public class Parser {

	public List<ExpressionNode>  parse (String input){
		List<ExpressionNode> commandsForFrontEnd = new ArrayList<>(); 

		input = input.toUpperCase();

		String[] split = input.split("\n"); 
		for(String s : split){
			ExpressionTreeBuilder maker = new ExpressionTreeBuilder(s); 
			commandsForFrontEnd.addAll( maker.getOutputList());
		} 
		return commandsForFrontEnd; 
	}

}
