package ExpressionTree;

import java.util.Stack;

public class ExpressionTreeBuilder {



	private static ExpressionNodeFactory nodeGetter; 
	private static Stack<ExpressionNode> temp;

	public ExpressionTreeBuilder( String s){

	}

	public static ExpressionNode getTree( Stack<ExpressionNode> processNodes){
		temp = new Stack<>() ;
		while(!processNodes.isEmpty()){
			ExpressionNode holder = processNodes.pop(); 

			if( holder.getNumChildren() == 1){
				holder.setLeft(temp.pop());
			}

			else if( holder.getNumChildren() == 2){
				holder.setLeft(temp.pop());
				holder.setRight(temp.pop());
			}

			temp.push(holder);

		}
		return temp.pop(); // if this has worked correctly th
	}



	public static Stack<ExpressionNode>  getNodes(String s){
		nodeGetter = new ExpressionNodeFactory();

		Stack<ExpressionNode> returnNodes = new Stack<ExpressionNode>();

		String[] split = s.trim().split(" "); 
		for(String string : split ){
			returnNodes.push(nodeGetter.getNode(string)); 
			System.out.println(nodeGetter.getNode(string).getClass().toString());
		}
		return returnNodes;
	}


	public static void main(String[] main) {

		String origInput = "* - + 50 30 2 3"; 



		ExpressionNode finalTest =getTree( getNodes(origInput)); 
		System.out.println(finalTest.evaluate()); 

	} 

}
