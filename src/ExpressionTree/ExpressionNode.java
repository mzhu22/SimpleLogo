package ExpressionTree;

public abstract class ExpressionNode {
	protected double myInfo; 
	protected ExpressionNode myRight; 
	protected ExpressionNode myLeft; 



	public abstract double evaluate(); 

	public ExpressionNode getLeft(){
		return myLeft; 
	}

	public ExpressionNode getRight(){	
		return myRight; 
	}

	public void setLeft( ExpressionNode toSet){
		myLeft = toSet; 
	}

	public void setRight( ExpressionNode toSet){
		myRight = toSet; 
	}


	public void setInfo(int a){

		myInfo = a; 

	}

	public abstract void doAction(); 
}
