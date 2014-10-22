package ExpressionTree;

import java.util.ArrayList;
import java.util.List;

import FundamentalInstructions.FundamentalInstruction;

public abstract class ExpressionNode {
	protected double myInfo; 
	protected ExpressionNode myRight; 
	protected ExpressionNode myLeft; 
	protected int numChildren; 
	protected List<FundamentalInstruction> instructionList ; 
	public ExpressionNode( int numChild){
		numChildren = numChild;		
	}
	
	public abstract double evaluate(); 

	public List<FundamentalInstruction> makeInstructionList(){
			instructionList = new ArrayList<>();
			
			if(getLeft()!=null){
				instructionList.addAll(getLeft().makeInstructionList());
			}
			if(FundamentalInstruction.class.isAssignableFrom(this.getClass())){
				instructionList.add((FundamentalInstruction)this);
			}
			if(getRight()!=null){
				instructionList.addAll(getRight().makeInstructionList());
			}
			return instructionList;
	}
	
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
	
	public int  getNumChildren(){
		
		return numChildren; 
		
	}
	
	public double getInfo(){
		return myInfo; 
	}
}
