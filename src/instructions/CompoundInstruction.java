package instructions;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import backend.Instruction;
import FundamentalInstructions.FundamentalInstruction;

public class CompoundInstruction  extends Instruction implements Iterable<FundamentalInstruction> {
	protected List<FundamentalInstruction> myComponentInstructions; 
	
	
	
	public CompoundInstruction(){
		myComponentInstructions = new ArrayList<FundamentalInstruction>(); 
		
	}
	@Override
	public Iterator<FundamentalInstruction> iterator() {
		// TODO Auto-generated method stub
		Iterator<FundamentalInstruction> iter = myComponentInstructions.iterator();
        return iter; 
	}

	
	public Object doAction(){
		for(FundamentalInstruction someInstruction : this){
			someInstruction.doAction(); 
		}
		return null; 
	}
}
