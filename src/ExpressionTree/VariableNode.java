package ExpressionTree;



public class VariableNode extends ExpressionNode {
	
	private String identifier; 
	
	public VariableNode () {
		super(0); 		 
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


	public double getInfo(){
		return myValue; 
	}


}
