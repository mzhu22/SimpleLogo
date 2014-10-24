package ExpressionTree;
/**
 * @author Dimeji Abidoye
 * 
 *
 */
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;
import java.util.Stack;

import FundamentalInstructions.FundamentalInstruction;

public class ExpressionTreeBuilder {

	private ExpressionNodeFactory nodeGetter; 
	private List<FundamentalInstruction> outputList;
	private List<ExpressionNode> nodeList; 
	private int balance; 

	public ExpressionTreeBuilder(String s){
		outputList = new ArrayList<>();
		nodeList = new ArrayList<>();
		Stack<ExpressionNode> process = getNodes(s); 
				
		getTree(process); 

		for(ExpressionNode n: nodeList){
			outputList.addAll(n.makeInstructionList());
		}
	}

	public  void getTree(Stack<ExpressionNode> processNodes){
		Stack<ExpressionNode> temp = new Stack<>() ;
		while(!processNodes.isEmpty()){
			ExpressionNode holder = processNodes.pop(); 

			//TODO: Refactor so this doesn't just do setLeft() and setRight()
			if(holder.getNumChildren() == 1){
				holder.setLeft(temp.pop());
			}

			else if( holder.getNumChildren() == 2){
				holder.setLeft(temp.pop());
				holder.setRight(temp.pop());
			}

			temp.push(holder);

		}
		while( !temp.isEmpty()){
			ExpressionNode hold = temp.pop(); 
			hold.evaluate(); 
			nodeList.add(hold); 
		}
	}

	public  Stack<ExpressionNode> getNodes(String s){
		nodeGetter = new ExpressionNodeFactory();
		balance = 0; 
		Stack<ExpressionNode> returnNodes = new Stack<ExpressionNode>();

		String[] split = s.trim().split(" "); 

		for(String string : split ){

			//Case for code organized in brackets (e.g., for repeats)
			if(string.matches("\\[") && balance == 0){
				balance ++ ; 	
				returnNodes.push(new ListNode());
			}
			else if(string.matches("\\]")){
				balance -- ; 				
			}
			else{
				if( balance == 0 ){
					returnNodes.push(nodeGetter.getNode(string)); 
				}
				else  {				
					ListNode list = (ListNode) returnNodes.peek();
					list.add(string);
					//returnNodes.push(list);
				}
			}

		}
		return returnNodes;
	}

	public List<FundamentalInstruction> getOutputList(){
		return outputList;
	}
}