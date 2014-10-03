package CommandAbstractClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import FundamentalInstructions.FundamentalInstruction;

public class CompoundInstruction  extends Instruction implements Iterable<FundamentalInstruction> {
	protected List<FundamentalInstruction> myComponentInstructions; 
	protected List<Number> myComponentParameters; 
	
	
	
	public CompoundInstruction(){
		myComponentInstructions = new ArrayList<FundamentalInstruction>(); 
		
	}
	@Override
	public Iterator<FundamentalInstruction> iterator() {
		// TODO Auto-generated method stub
		Iterator<FundamentalInstruction> iter = myComponentInstructions.iterator();
        return iter; 
	}

	
	public Number doAction(){
		for(FundamentalInstruction someInstruction : this){
			someInstruction.doAction(); 
		}
		return null; 
	}
}
