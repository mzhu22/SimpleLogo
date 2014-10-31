package expressionTree;
/**
 * Class that takes in String input from Parser representing all inputted Slogo commands.
 * 
 * Creates an expression tree from this String following the conventions of Slogo syntax. 
 * An ExpressionNodeFactory converts Strings into Nodes, then this class builds the Nodes
 * into a full tree structure.
 * 
 * Sends back a list of executable instructions to the frontend in correct order.
 * @author Dimeji Abidoye
 *
 */
import static frontend.GUIMaker.EPU;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

import displayCommands.DisplayNode;

public class ExpressionTreeBuilder {

	private ExpressionNodeFactory nodeGetter; 

	private List<DisplayNode> outputList;
	private List<ExpressionNode> nodeList;  

	public ExpressionTreeBuilder(String s){
		nodeGetter = new ExpressionNodeFactory(); 
		outputList = new ArrayList<>();
		nodeList = new ArrayList<>();
		Stack<ExpressionNode> process = nodeGetter.getAllNodes(s); 	
		getTree(process); 
		for(ExpressionNode n: nodeList){
			outputList.addAll(n.makeInstructionList());
		}
	}

	/**
	 * 
	 * @param processNodes
	 */
	private void getTree(Stack<ExpressionNode> processNodes){
		Stack<ExpressionNode> temp = new Stack<>() ;
		while(!processNodes.isEmpty()){ 
			try{
				ExpressionNode holder = processNodes.pop(); 
				holder.setChildren(temp);
			}
			catch (EmptyStackException e){ 
				EPU.display("Insufficient inputs for method", true);
			}
			
		}
		while( !temp.isEmpty()){
			ExpressionNode hold = temp.pop(); 
			hold.evaluate(); 
			nodeList.add(hold); 
		}
	}

	public List<DisplayNode> getOutputList(){
		return outputList;
	}
	
	public List<ExpressionNode> getAllNodes(){
		return nodeList; 
	}
}
