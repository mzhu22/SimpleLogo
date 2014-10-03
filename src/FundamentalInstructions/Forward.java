package FundamentalInstructions;
import Interfaces.IInstruction;


public class Forward extends FundamentalInstruction implements IInstruction{

	public Forward( int parameter){
		super(parameter);
		myCode = "fd"; 
	}

	@Override
	public Number doAction() {
		return myParameter;
		// TODO Auto-generated method stub
		
	}
}
