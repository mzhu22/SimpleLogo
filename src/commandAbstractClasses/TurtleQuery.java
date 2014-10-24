package commandAbstractClasses;

/**
 * @author Dimeji Abidoye
 * 
 *
 */

import expressionTree.ExpressionNode;
import frontend.Turtle;



public  abstract class TurtleQuery extends ExpressionNode {

	protected Turtle myTurtle; 
	
	public TurtleQuery(Turtle actionable){
		super(0); 
		myTurtle = actionable; 
	}
	
	@Override
	public abstract double evaluate(); 

}
