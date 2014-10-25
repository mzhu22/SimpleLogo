package displayCommands;

import java.util.Stack;

import expressionTree.ExpressionNode;
import frontend.Turtle;
import frontend.TurtleCollection;

public class SetPalette extends DisplayNode {

	public SetPalette() {
		super(4);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction(TurtleCollection turtles)
	{
		//turtles.getCanvas().addColor(index, r, g, b);
	}
	
	@Override
	protected void doAction(Turtle turtle) {
		// TODO Auto-generated method stub

	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setChildren( Stack<ExpressionNode> childStack){
		
		
		
	}

}
