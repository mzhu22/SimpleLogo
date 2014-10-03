package FundamentalInstructions;

public class Right extends FundamentalInstruction {

	public Right(int parameter) {
		super(parameter);
		myCode = "rt"; 
		// TODO Auto-generated constructor stub
	}

	@Override
	public Number doAction() {
		// TODO Auto-generated method stub
		return myParameter;
	}

}
