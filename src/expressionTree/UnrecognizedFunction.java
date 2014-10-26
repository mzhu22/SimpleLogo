package expressionTree;

/**
 * UnrecognizedFunction objects are created by ExpressionNodeFactory when the String 
 * command is not an implemented ExpressionNode class. This happens either when the user
 * wants to define custom functions, in which case an object of this class is a child
 * of MakeUserInstruction, or when the user types in incorrect commands, in which case an
 * error popup is thrown.
 * 
 * @author Mike Zhu
 *
 */
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
