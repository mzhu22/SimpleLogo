package ExpressionTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import displayCommands.DisplayNode;

public abstract class ExpressionNode {
	protected double myValue; 
	protected ExpressionNode myRight; 
	protected ExpressionNode myLeft; 
	protected int numChildren; 
	
	protected List<DisplayNode> instructionList ; 
	
	/**
	 * Default number of children is 2. The vast majority of Slogo commands follows this
	 * syntax
	 */
	public ExpressionNode(){
		numChildren = 2;
	} 

	public ExpressionNode(int numChild){
		numChildren = numChild;		
	}

	public abstract double evaluate(); 

	public List<DisplayNode> makeInstructionList(){
		instructionList = new ArrayList<>();

		if(getLeft()!=null){
			instructionList.addAll(getLeft().makeInstructionList());
		}
		if(DisplayNode.class.isAssignableFrom(this.getClass())){
			instructionList.add((DisplayNode)this);
		}
		if(getRight()!=null){
			instructionList.addAll(getRight().makeInstructionList());
		}
		return instructionList;
}

	protected ExpressionNode getLeft(){
		return myLeft; 
	}

	protected ExpressionNode getRight(){	
		return myRight; 
	}

	private void setLeft( ExpressionNode toSet){
		myLeft = toSet; 
		numChildren --; 
	}

	private void setRight( ExpressionNode toSet){
		myRight = toSet;
		numChildren--; 
	}

	public void setInfo(double a){
		myValue = a; 
	}
	private int  getNumChildren(){

		return numChildren; 	
	}
	public double getInfo(){
		return myValue; 
	}

	public void setChildren( Stack<ExpressionNode> childStack){
		if(getNumChildren() == 1){
			setLeft(childStack.pop());
		}
		else if(getNumChildren() == 2){
			setLeft(childStack.pop());
			setRight(childStack.pop());
		}
		childStack.push(this); 
	}


	
}
