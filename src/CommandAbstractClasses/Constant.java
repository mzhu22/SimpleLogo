package CommandAbstractClasses;

/**
 * @author Dimeji Abidoye
 * 
 *
 */

import ExpressionTree.ExpressionNode;

public class Constant extends ExpressionNode {

	public Constant(){
		super (0); 
	}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myInfo;
	}
	
}
