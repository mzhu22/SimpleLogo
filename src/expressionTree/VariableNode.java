package expressionTree;

import java.io.Serializable;

/**
 * VariableNode holds user-defined variables. Contains an identifier for the name of the 
 * variable and stores the value in myValue.
 * 
 * Implements Serializable so VariableNodes can be written to a file for save/load.
 * @author Mike Zhu
 *
 */

public class VariableNode extends ExpressionNode implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9180533161032934656L;
	private String identifier; 
	
	public VariableNode () {
		super(0); 		 
	}
	
	public VariableNode (int value){
		super(0);
		SetInfo(value);
	}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myValue;
	}

	public void SetInfo(int x ){
		myValue = x; 
	} 
	
	public String getIdentifier(){
		return identifier ; 	
	}


	public double getValue(){
		return myValue; 
	}


}
