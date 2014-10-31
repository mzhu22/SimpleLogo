// This entire file is part of my masterpiece.
// Dimeji Abidoye
package ota2Test;

import expressionTree.ExpressionNode;

public class FlexibleSetChildrenTester extends ExpressionNode {

	public FlexibleSetChildrenTester(int numChildren) {
		super(numChildren);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		for( ExpressionNode n : myChildren){
			
			myValue +=  n.evaluate()*3 ; 
		}
		return myValue; 
	}

}
