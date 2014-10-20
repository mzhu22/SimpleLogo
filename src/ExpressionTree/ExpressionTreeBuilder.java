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

	private static ExpressionNodeFactory nodeGetter; 
	private static Stack<ExpressionNode> temp;
	private static List<FundamentalInstruction> outputList;
	private static List<ExpressionNode> nodeList; 
	private static int balance; 

	public ExpressionTreeBuilder(String s){
		outputList = new ArrayList<>();
		nodeList = new ArrayList<>();
		Stack<ExpressionNode> process = getNodes(s); 
		getTree(process); 

		for(ExpressionNode n: nodeList){
			outputList.addAll(n.makeInstructionList());
		}
	}

	public static void getTree(Stack<ExpressionNode> processNodes){
		temp = new Stack<>() ;
		while(!processNodes.isEmpty()){
			ExpressionNode holder = processNodes.pop(); 

			//error checking here regarding # of inputs, etc. 
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

	public static Stack<ExpressionNode> getNodes(String s){
		nodeGetter = new ExpressionNodeFactory();

		Stack<ExpressionNode> returnNodes = new Stack<ExpressionNode>();

		String[] split = s.trim().split(" "); 

		for(String string : split ){

			//Case for code organized in brackets (e.g., for repeats)
			if(string.matches("\\[") ){
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
				else {				
					ListNode list = (ListNode) returnNodes.pop();
					list.add(string);
					returnNodes.push(list);
				}
			}

		}
		return returnNodes;
	}

	public List<FundamentalInstruction> getOutputList(){
		return outputList;
	}

	//	public static void main(String[] main) {
	//
	//
	//
	//		@SuppressWarnings("resource")
	//		Scanner sc = new Scanner(System.in);
	//
	//		String s = sc.nextLine(); 
	//		
	//		
	//		while(s != "END"){
	//			
	//			s = s.toUpperCase();
	//			System.out.println(s + " this is the input string"); 
	//			
	//			ExpressionTreeBuilder builder = new ExpressionTreeBuilder(s); 	
	//			
	//			for(ExpressionNode a :outputList ){
	//				System.out.println(a.myInfo + " "+ a.getClass() + " these are the fundamental nodes in the tree"); 
	//			}
	//			
	//			for(String  a : myVariables.keySet()){
	//				System.out.println( a + " "+ myVariables.getVariable(a).getInfo()); 
	//			
	//			}
	//		 s = sc.nextLine();
	//		} 
	//
	//		
	//		System.out.println( "this is the end"); 
	//	}

}
