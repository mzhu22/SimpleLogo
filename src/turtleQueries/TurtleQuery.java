package turtleQueries;

/**
 * @author Dimeji Abidoye
 * 
 *
 */

import expressionTree.ExpressionNode;
import frontend.Turtle;



public  abstract class TurtleQuery extends ExpressionNode {

	protected Turtle myTurtle; 
	
	public TurtleQuery(){
		super(0);
	}
	
	public void setTurtle(Turtle actionable){
		myTurtle = actionable; 
	}
	
	@Override
	public abstract double evaluate(); 

}
