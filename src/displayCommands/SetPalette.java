package displayCommands;

import static frontend.GUIMaker.EPU;

import java.util.EmptyStackException;
import java.util.Stack;

import turtleClasses.Turtle;
import turtleClasses.TurtleCollection;
import expressionTree.ExpressionNode;

public class SetPalette extends DisplayNode {

	private ExpressionNode myIndexNode;
	private ExpressionNode myBlueNode;

	private double index;
	private double r;
	private double g;
	private double b;

	public SetPalette() {
		super(4);
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
		index = myIndexNode.evaluate();
		r = myLeft.evaluate();
		g = myRight.evaluate();
		b = myBlueNode.evaluate();
		return myValue = index;
	}

	@Override
	/**
	 * setChildren implementation for 4 children used for SetPalette 
	 */
	public void setChildren( Stack<ExpressionNode> childStack){
		try{
			myIndexNode = childStack.pop();
			myLeft = childStack.pop();
			myRight = childStack.pop();
			myBlueNode = childStack.pop();
		}
		catch (EmptyStackException e){
			EPU.display("Insufficient arguments for method", true);
		}

		childStack.push(this);
	}

}
