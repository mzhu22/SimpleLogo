package CommandAbstractClasses;

/**
 * @author Dimeji Abidoye
 * 
 *
 */

import ExpressionTree.ExpressionNode;
import frontend.Turtle;



public  abstract class TurtleQuery extends ExpressionNode {

	protected Turtle myTurtle; 
	
	public TurtleQuery(Turtle actionable){
		myTurtle = actionable; 
		numChildren = 0; 
	}
	
	@Override
	public abstract double evaluate(); 

}
