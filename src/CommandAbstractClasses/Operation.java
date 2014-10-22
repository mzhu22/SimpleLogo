package CommandAbstractClasses;

/**
 * @author Dimeji Abidoye
 * 
 *
 */

import java.util.Random;

import ExpressionTree.ExpressionNode;

public abstract class Operation extends ExpressionNode {

	
	
	public Operation(int numChild) {
		super(numChild);
	}
	protected static final int ONE_EIGHTY = 180; 
	protected static final double PI = Math.PI; 
	protected static Random randomizer = new Random(); 
	


	
}
