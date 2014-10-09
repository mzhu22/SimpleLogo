package FundamentalInstructions;


public class doNothing extends FundamentalInstruction {

	
	public doNothing() {
		
		numChildren = 0; 
	}

	@Override
	public double evaluate() {
		return ZERO;
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}
}
