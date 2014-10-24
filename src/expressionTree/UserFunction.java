package expressionTree;

import java.util.ArrayList;
import java.util.List;

import displayCommands.DisplayNode;

public class UserFunction extends ExpressionNode{

	private ListNode myVariables; 
	private ListNode myCommands; 
	
	public UserFunction() {
		super(0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return 1;
	}

	
	public void setMyVariables( ListNode variables){
		myVariables = variables; 
	}


	public void setMyCommands( ListNode commands){
		myCommands = commands; 
	}
	
	
	@Override
	public List<DisplayNode> makeInstructionList(){
		List<DisplayNode> toReturn = new ArrayList<>(); 
		
		for( ExpressionNode node : myCommands.getListContents() ){
			toReturn.addAll(node.makeInstructionList()); 
		}
		return toReturn; 
	}
}

