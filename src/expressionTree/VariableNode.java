package expressionTree;

import java.io.Serializable;



public class VariableNode extends ExpressionNode implements Serializable{
	
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
