package ExpressionTree;

import java.util.Stack;

import FundamentalInstructions.FundamentalInstruction;

public class ExpressionTreeBuilder {

	private static ExpressionNodeFactory nodeGetter; 
	private static Stack<ExpressionNode> temp;
	private static Stack<ExpressionNode> outputStack;

	public ExpressionTreeBuilder( String s){
		outputStack = new Stack<>();
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
		return temp.pop(); // if this has worked correctly 
	}



	public static Stack<ExpressionNode>  getNodes(String s){
		nodeGetter = new ExpressionNodeFactory();

		Stack<ExpressionNode> returnNodes = new Stack<ExpressionNode>();

		String[] split = s.trim().split(" "); 
		for(String string : split ){
			
			returnNodes.push(nodeGetter.getNode(string)); 
			Class<? extends ExpressionNode> nodeClass = nodeGetter.getNode(string).getClass();
			System.out.println(nodeClass.toString());
			
			//Checks if the instruction is a FundamentalInstruction
			if(FundamentalInstruction.class.isAssignableFrom(nodeClass)){
				System.out.println("BOOM");
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
			outputStack.push(curr);
		}
		makeOutputStack(curr.myRight);
	}

	public static void main(String[] main) {
		outputStack = new Stack<>();

		String origInput = "FD SUM FD 50 50"; 

		ExpressionNode finalTest =getTree( getNodes(origInput)); 
		System.out.println(finalTest.evaluate());
		
		makeOutputStack(finalTest);
	} 

}
