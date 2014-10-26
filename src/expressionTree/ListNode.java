package expressionTree;

import java.util.ArrayList;
import java.util.List;

import displayCommands.DisplayNode;

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
	private List<DisplayNode> myFundamentals; 
	private ExpressionTreeBuilder myBuilder;
	private List<ExpressionNode> allMyChildren; 
	
	
	public ListNode(){
		super(0); 
		myLogoCode = new StringBuilder();
		myFundamentals = new ArrayList<>();
	}

	@Override
	public double evaluate() { 
		myBuilder = new ExpressionTreeBuilder(myLogoCode.toString());
		myFundamentals.addAll(myBuilder.getOutputList());
		allMyChildren = myBuilder.getAllNodes(); 
		return myValue = allMyChildren.get(0).getValue();
	}

	public void add(String s){
		myLogoCode.append(" " + s.trim()) ;
	}

	@Override
	public List<DisplayNode> makeInstructionList(){
		List<DisplayNode> toReturn = new ArrayList<>(); 
		for(DisplayNode instr : myFundamentals){		
//			if(!toReturn.contains(instr)) 
				toReturn.add(instr); 
		}
		return toReturn; 
	}
	
	public List<ExpressionNode> getListContents(){
		return allMyChildren; 
	}
	
}