package CommandAbstractClasses;

import Interfaces.IInstruction;

public class Instruction extends AnyCommands implements IInstruction {
	protected int myParameter; 
	@Override
	public Number doAction() {
		// TODO Auto-generated method stub
		return myParameter;
	}

}
