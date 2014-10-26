package turtleQueries;
import expressionTree.ExpressionNode;

/**
 * Abstract class for TurtleQuery commands. TurtleQuery commands are backend classes that
 * access information of turtles stored on the frontend. Therefore they depend heavily
 * on the singleton structure TurtleSnapshot containing latest turtle data and
 * accessible globally.
 * @author Dimeji Abidoye
 */

public  abstract class TurtleQuery extends ExpressionNode {
	
	public TurtleQuery(){
		super(0);
	}
	
	@Override
	public abstract double evaluate(); 

}
