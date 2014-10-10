package ExpressionTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import FundamentalInstructions.FundamentalInstruction;

public class ExpressionTreeBuilder {

	private static ExpressionNodeFactory nodeGetter; 
	private static Stack<ExpressionNode> temp;
	private static List<ExpressionNode> outputList;

	public ExpressionTreeBuilder( String s){
		outputList = new ArrayList<>();
		Stack<ExpressionNode> process =getNodes(s); 
		ExpressionNode processTree = getTree(process); 
		System.out.println(processTree.myInfo + " is the value I have evaluated"); 
		makeOutputStack(processTree); 
	}

	public static ExpressionNode getTree( Stack<ExpressionNode> processNodes){
		temp = new Stack<>() ;
		while(!processNodes.isEmpty()){
			ExpressionNode holder = processNodes.pop(); 

			//error checking here regarding # of inputs, etc. 
			if( holder.getNumChildren() == 1){
				holder.setLeft(temp.pop());
			}

			else if( holder.getNumChildren() == 2){
				holder.setLeft(temp.pop());
				holder.setRight(temp.pop());
			}

			
			//Need to check if it is a fundamental instruction
				//add a copy to the "list or stack thing" to send to frontend
				//only fundamental instructions: fd, turn, penup, pendown, turtle on/off, compounds, stamp
			temp.push(holder);

		}
		temp.peek().evaluate(); 
		return temp.pop(); // if this has worked correctly 
	}



	public static Stack<ExpressionNode>  getNodes(String s){
		nodeGetter = new ExpressionNodeFactory();

		Stack<ExpressionNode> returnNodes = new Stack<ExpressionNode>();

		String[] split = s.trim().split(" "); 
		for(String string : split ){
			
			returnNodes.push(nodeGetter.getNode(string)); 
			Class<? extends ExpressionNode> nodeClass = nodeGetter.getNode(string).getClass();
			//System.out.println(nodeClass.toString());
			
			//Checks if the instruction is a FundamentalInstruction
			if(FundamentalInstruction.class.isAssignableFrom(nodeClass)){
				//System.out.println("BOOM");
			}
		}
		return returnNodes;
	}
	
	
	/**
	 * Go through the ExpressionTree using in-order traversal (left-root-right) to push
	 * fundamental instructions to the output stack in order of their declaration
	 * @param head
	 */
	public static void makeOutputStack(ExpressionNode head){
		ExpressionNode curr = head;
		if(curr == null){
			return;
		}
		
		makeOutputStack(curr.myLeft);
		if(FundamentalInstruction.class.isAssignableFrom(curr.getClass())){
			outputList.add(curr);
		}
		makeOutputStack(curr.myRight);
	}

	public List<ExpressionNode> getOutputList(){
		return outputList; 
	}
	
	public static void main(String[] main) {
		outputList = new ArrayList<>();
		String origInput = "REPEAT 5 FD 50";
		
		ExpressionTreeBuilder builder = new ExpressionTreeBuilder( origInput); 
		
		for(ExpressionNode s :outputList ){
			System.out.print(s.myInfo + " "); 
		}
	} 

}
