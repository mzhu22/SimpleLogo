package displayCommands;

import expressionTree.ExpressionNode;
import frontend.Turtle;
import frontend.TurtleCollection;

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
	
	public void doAction(TurtleCollection turtles)
	{
		for(Turtle t : turtles)
		{
			doAction(t);
		}
	}
	
	protected abstract void doAction(Turtle turtle);
	
}

