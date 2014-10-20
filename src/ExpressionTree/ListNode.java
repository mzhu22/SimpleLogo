package ExpressionTree;

import java.util.ArrayList;
import java.util.List;

import ExpressionTree.ExpressionNode;
import ExpressionTree.ExpressionTreeBuilder;
import FundamentalInstructions.FundamentalInstruction;

/**
 * ListNode represents a sequence of Expressions. ListNode enables storage of expressions 
 * written within brackets for repeats and user-defined functions (e.g., for repeat 3 
 * [ fd 50 rt 90 ], a ListNode stores the fd and rt commands) . ListNode's evaluate() 
 * method runs through the stored commands sequentially, evaluating each and returning a 
 * list of executable FundamentalInstructions.
 * 
 * @author Mike Zhu
 *
 */
public class ListNode extends ExpressionNode {

	private StringBuilder myLogoCode;
	private List<FundamentalInstruction> myFundamentals = new ArrayList<>();
	private ExpressionTreeBuilder myBuilder;

	public ListNode(){
		myLogoCode = new StringBuilder();
		numChildren = 0 ;
	}

	@Override
	public double evaluate() {
		myBuilder = new ExpressionTreeBuilder(myLogoCode.toString());
		myFundamentals.addAll(myBuilder.getOutputList());
		return 0;
	}

	public void add(String s){
		myLogoCode.append(" " + s.trim()) ;
	}

	@Override
	public List<FundamentalInstruction> makeInstructionList(){
		return myFundamentals;
	}
	
}