package ExpressionTree;

import java.util.ArrayList;
import java.util.List;

import FundamentalInstructions.FundamentalInstruction;

public abstract class ExpressionNode {
	protected double myInfo; 
	protected ExpressionNode myRight; 
	protected ExpressionNode myLeft; 
	protected int numChildren; 
	protected List<FundamentalInstruction> instructionList = new ArrayList<>();


	public abstract double evaluate(); 

	public void makeInstructionList(){
		
			if(getLeft()!=null){
				getLeft().makeInstructionList();
				instructionList.addAll(getLeft().instructionList);
			}
			if(FundamentalInstruction.class.isAssignableFrom(this.getClass())){
				instructionList.add((FundamentalInstruction)this);
			}
			if(getRight()!=null){
				getRight().makeInstructionList();
				instructionList.addAll(getRight().instructionList);
			}
	}
	
	public List<FundamentalInstruction> getInstructionList(){
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
	
	

	//public abstract void doAction(); 

	public int  getNumChildren(){
		
		return numChildren; 
		
	}
}
