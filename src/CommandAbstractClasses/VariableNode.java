package CommandAbstractClasses;

import ExpressionTree.ExpressionNode;

public class VariableNode extends ExpressionNode {
	
	private String indentifier; 
	
	public VariableNode () {
		numChildren =0; 		 
	}
	
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myInfo;
	}

	public void SetInfo(int x ){
		myInfo = x; 
	} 
	
	public String getIdentifier(){
		return indentifier ; 	
	}


	public double getInfo(){
		return myInfo; 
	}


}
