package frontend;

import java.util.List;

import displayCommands.DisplayNode;
import expressionTree.ExpressionNode;

/**
 * This class has the ability to read commands to
 * call them on turtles.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 * 
 */
public class TurtleMover {

	private TurtleCollection myTurtleCollection;
	
	/**
	 * Constructor.
	 * 
	 * @param turtleCollection The collection of turtles on which to run the commands.
	 */
	public TurtleMover(TurtleCollection turtleCollection) {
		myTurtleCollection = turtleCollection;
	}
	
	/**
	 * Runs the list of commands on the turtles.
	 * 
	 * @param instructions List of commands to execute.
	 */
	public void startDrawing(List<ExpressionNode> instructions){
		myTurtleCollection.setActiveTurtles();
		
		TurtleSnapshot.getTurtleSnapshot().update(myTurtleCollection.getLastActiveTurtle());
		for(ExpressionNode n : instructions){
			((DisplayNode) n ).doAction(myTurtleCollection);
		}	
	}
}
