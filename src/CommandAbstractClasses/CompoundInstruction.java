package CommandAbstractClasses;

import java.util.List;
import java.util.Iterator;

import ExpressionTree.ExpressionNode;
import FundamentalInstructions.FundamentalInstruction;

public class CompoundInstruction extends ExpressionNode  implements Iterable<FundamentalInstruction> {
	
	
	protected List<FundamentalInstruction> myComponentInstructions; 
	protected List<Number> myComponentParameters; 
	
	
	
	@Override
	public Iterator<FundamentalInstruction> iterator() {
		// TODO Auto-generated method stub
		Iterator<FundamentalInstruction> iter = myComponentInstructions.iterator();
        return iter; 
	}

	
	public void doAction(){
		for(FundamentalInstruction someInstruction : this){
			someInstruction.doAction(); 
		}
	}
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return 0;
	}
}
