package ExpressionTree;


public class doNothing extends ExpressionNode {

	/**
	 * Used for user-defined function declarations
	 */
	private String identifier;
	
	public doNothing() {
		numChildren = 0; 
	}
	
	public doNothing(String s){
		identifier = s;
		numChildren = 0;
	}

	@Override
	public double evaluate() {
		return 0;
	}

	public String getIdentifier() {
		return identifier;
	}	
}
