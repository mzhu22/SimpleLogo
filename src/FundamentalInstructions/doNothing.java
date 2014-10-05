package FundamentalInstructions;


public class doNothing extends FundamentalInstruction {

	public doNothing() {
		super( null);
		myCode = "nada"; 
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
