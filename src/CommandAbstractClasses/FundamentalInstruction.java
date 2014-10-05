package CommandAbstractClasses;

import Interfaces.IInstruction;

public abstract class FundamentalInstruction extends Instruction{
   	public FundamentalInstruction(String code, int parameter){}
   	   	
   	public abstract Number doAction();

	public String toString(){return null;}
}


