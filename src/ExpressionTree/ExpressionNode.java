package ExpressionTree;

public abstract class ExpressionNode {
	protected double myInfo; 
	protected ExpressionNode myRight; 
	protected ExpressionNode myLeft; 
	protected int numChildren; 


	public abstract double evaluate(); 

	public ExpressionNode getLeft(){
		return myLeft; 
	}

	public ExpressionNode getRight(){	
		return myRight; 
	}

	public void setLeft( ExpressionNode toSet){
		myLeft = toSet; 
		numChildren --; 
	}

	public void setRight( ExpressionNode toSet){
		myRight = toSet;
		numChildren--; 
	}


	public void setInfo(double a){

		myInfo = a; 

	}

	//public abstract void doAction(); 

	public int  getNumChildren(){
		
		return numChildren; 
		
	}
}
