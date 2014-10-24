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

	private void getTree(Stack<ExpressionNode> processNodes){
		Stack<ExpressionNode> temp = new Stack<>() ;
		while(!processNodes.isEmpty()){
			ExpressionNode holder = processNodes.pop(); 
			holder.setChildren(temp);
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
}
