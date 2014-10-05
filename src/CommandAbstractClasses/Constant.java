package CommandAbstractClasses;

import ExpressionTree.ExpressionNode;



public class Constant extends ExpressionNode {

	public Constant(double value) {
		super(null, null);
		myInfo = value; 
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myInfo;
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
