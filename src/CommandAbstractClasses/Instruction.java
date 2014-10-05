package CommandAbstractClasses;

import Interfaces.IInstruction;

public class Instruction implements IInstruction {
	protected int myParameter; 
	@Override
	public Number doAction() {
		// TODO Auto-generated method stub
		return myParameter;
	}

}
