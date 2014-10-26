package expressionTree;


public class UnrecognizedFunction extends ExpressionNode {

	/**
	 * Used for user-defined function declarations
	 */
	private String identifier;
	
	public UnrecognizedFunction() {
		super(0); 
	}
	
	public UnrecognizedFunction(String s){
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
