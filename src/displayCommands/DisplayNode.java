package displayCommands;

import turtleClasses.Turtle;
import turtleClasses.TurtleCollection;
import expressionTree.ExpressionNode;

/**
 * Superclass for all instructions that are sent to the frontend and run to move the
 * turtle. DisplayNode itself extends ExpressionNode and adds doAction methods. 
 * 
 * doAction methods take in Turtle input and manipulate the turtle directly.
 * 
 * Specifications for what each displayNode instruction does can be found on the Slogo
 * information sheet online
 * @author Mike Zhu
 *
 */
public abstract class DisplayNode extends ExpressionNode{
	
	
	public DisplayNode(int i) {
		super(i); 
	}
	
	protected static final int ONE = 1; 
	protected static final int ZERO = 0; 

	public String toString(){
		StringBuilder toRet = new StringBuilder(); 
	
		toRet.append(getClass().toString() + " :" + myValue); 	
		return toRet.toString(); 
	}
	
	/**
	 * Takes in collection of all active turtles, iterating through them to run the 
	 * abstract doAction method for individual turtles.
	 * @param turtles
	 */
	public void doAction(TurtleCollection turtles)
	{
		for(Turtle t : turtles)
		{
			doAction(t);
		}
	}
	
	/**
	 * Abstract method - each subclass manipulates the turtle in a different way.
	 * @param turtle
	 */
	protected abstract void doAction(Turtle turtle);
	
}

