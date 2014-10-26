package backend;


/**
 * Class that takes in front end inputs and returns front end actionables. Front end sends
 * all entered commands before RUN is hit at once, receives a list of instructions
 * corresponding to that input.

 * @author Dimeji Abidoye
 *
 */
import java.util.ArrayList;
import java.util.List;

import expressionTree.ExpressionNode;
import expressionTree.ExpressionTreeBuilder;

public class Parser {
	public List<ExpressionNode>  parse (String input){
		List<ExpressionNode> commandsForFrontEnd = new ArrayList<>(); 


		String[] split = input.split("\n"); 
		for(String s : split){
			ExpressionTreeBuilder maker = new ExpressionTreeBuilder(s); 
			commandsForFrontEnd.addAll( maker.getOutputList());
		} 
		return commandsForFrontEnd; 
	}

}
