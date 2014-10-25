package frontend;

import java.util.List;

import displayCommands.DisplayNode;
import expressionTree.ExpressionNode;

public class TurtleMover {

	private TurtleCollection myTurtleCollection;
	
	public TurtleMover(TurtleCollection turtleCollection) {
		myTurtleCollection = turtleCollection;
	}
	
	public void startDrawing(List<ExpressionNode> instructions){
		for(ExpressionNode n : instructions){
			for(Turtle t : myTurtleCollection){
				((DisplayNode) n ).doAction(t);
			}
		}	
	}
}
