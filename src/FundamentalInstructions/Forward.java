package FundamentalInstructions;

public class Forward extends FundamentalInstruction{



	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return (myInfo = myLeft.evaluate());
	}
}
