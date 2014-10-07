package backend;

import java.util.List;

import ExpressionTree.ExpressionNode;
import FundamentalInstructions.doNothing;

public class ExpressionTreeBuilder {

	
	private List<String> toTree ; 
	
	
	public ExpressionNode ExpressionTreeBuilder( List<String> tree){
		toTree = tree;	
		//TODO fill out this place
		processor(); 
		return new doNothing(); 
	}
	
	private void processor(){
		
		for(String string : toTree ){
			
			ExpressionNode toAdd = OperatorFactory(string); 
			
		}
		
		
	}
	
	
	
}
