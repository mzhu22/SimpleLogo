package ExpressionTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import FundamentalInstructions.FundamentalInstruction;

public class ExpressionTreeBuilder {



	private  ExpressionNodeFactory nodeGetter; 
	private static Stack<ExpressionNode> temp;
	
	private static List<ExpressionNode> fundamentalNodes = new ArrayList<ExpressionNode>();

	public ExpressionTreeBuilder( String s){
		getTree( getNodes(s)); 
	}

	public static List<ExpressionNode> getTree( Stack<ExpressionNode> processNodes){
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
			
			
			if(holder instanceof FundamentalInstruction) fundamentalNodes.add(holder); 
			temp.push(holder);

		}
		//return temp.pop(); // if this has worked correctly 
		System.out.println(temp.pop());
		return fundamentalNodes; 
	}



	public Stack<ExpressionNode>  getNodes(String s){
		nodeGetter = new ExpressionNodeFactory();

		Stack<ExpressionNode> returnNodes = new Stack<ExpressionNode>();

		String[] split = s.trim().split(" "); 
		for(String string : split ){
			returnNodes.push(nodeGetter.getNode(string)); 
			//System.out.println(nodeGetter.getNode(string).getClass().toString());
		}
		return returnNodes;
	}

	
	
	public List<ExpressionNode> getFundamentalInstructions(){
		
		return fundamentalNodes; 
	}

//	public static void main(String[] main) {
//
//		String origInput = " - + +  50 50 50 50"; 
//
//		ExpressionNode finalTest =getTree( getNodes(origInput)); 
//		System.out.println(finalTest.evaluate()); 
//		//finalTest.evaluate(); 
//		
//		for( ExpressionNode node : fundamentalNodes ){
//			System.out.println(node.myInfo); 
//		}
//		
//	} 

}
