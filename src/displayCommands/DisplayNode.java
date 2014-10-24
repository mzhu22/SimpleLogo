package displayCommands;

import expressionTree.ExpressionNode;
import frontend.Turtle;

public abstract class DisplayNode extends ExpressionNode{
	
	
	public DisplayNode( int i) {
		super(i); 
	}
	
	protected static final int ONE = 1; 
	protected static final int ZERO = 0; 

	public String toString(){
		StringBuilder toRet = new StringBuilder(); 
	
		toRet.append(getClass().toString() + " :" + myValue); 	
		return toRet.toString(); 
	}

	public abstract void doAction(Turtle turtle);
	
	// TO DO pass doaction actionable frontend object	

}

