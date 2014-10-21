package ExpressionTree;



public class VariableNode extends ExpressionNode {
	
	private String identifier; 
	
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
		return identifier ; 	
	}


	public double getInfo(){
		return myInfo; 
	}


}
