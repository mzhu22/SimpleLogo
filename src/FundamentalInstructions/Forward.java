package FundamentalInstructions;
import java.util.List;

import Interfaces.IInstruction;


public class Forward extends FundamentalInstruction implements IInstruction{

	public Forward( List<Integer> parameters){
		super(parameters, 1, "fd");
	}

	@Override
	public Object doAction() {
		return null;
		// TODO Auto-generated method stub
		
	}
}
