//This entire file is part of my masterpiece.
//Dimeji Abidoye
package controlStructures;

import expressionTree.ExpressionNode;

/**
 * Stores an expression to be evaluated in the left child, a set of commands to be run on 
 * the right when expression==true.
 * @author Dimeji Abidoye
 *
 */
public class If extends ExpressionNode {

	public If() {
		super(2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		 if (getChild(MY_LEFT_CHILD).evaluate() !=0 )  return myValue = getChild(MY_RIGHT_CHILD).evaluate();
	
		 else return myValue; 
	}
}
