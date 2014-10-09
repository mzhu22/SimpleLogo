package ExpressionTree;


public class doNothing extends ExpressionNode {

	
	public doNothing() {
		
		numChildren = 0; 
	}

	@Override
	public double evaluate() {
		return 0;
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}
}
