package FundamentalInstructions;
import ExpressionTree.ExpressionNode;


public class Forward extends FundamentalInstruction{

	public Forward( int parameter, ExpressionNode myRight){
		super(myRight);
		myCode = "fd"; 
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return (myInfo = myRight.evaluate());
	}
}
