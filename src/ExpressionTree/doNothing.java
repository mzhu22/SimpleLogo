package ExpressionTree;


public class doNothing extends ExpressionNode {

	/**
	 * Used for user-defined function declarations
	 */
	private String identifier;
	
	public doNothing() {
		super(0); 
	}
	
	public doNothing(String s){
		super(0); 
		identifier = s;
	}

	@Override
	public double evaluate() {
		return 0;
	}

	public String getIdentifier() {
		return identifier;
	}	
}
