package expressionTree;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import static frontend.GUIMaker.EPU;

import displayCommands.DisplayNode;
import errorsAndExceptions.ErrorPopUp;

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

	protected void setLeft( ExpressionNode toSet){
		myLeft = toSet; 
		numChildren --; 
	}

	protected void setRight( ExpressionNode toSet){
		myRight = toSet;
		numChildren--; 
	}

	public void setValue(double a){
		myValue = a; 
	}
	protected int  getNumChildren(){

		return numChildren; 	
	}
	public double getValue(){
		return myValue; 
	}

	/**
	 * Throws error when an EmptyStackException occurs, indicating that user did not follow
	 * correct Slogo syntax (likely has too few arguments for a given method)
	 * @param childStack
	 */
	public void setChildren( Stack<ExpressionNode> childStack){
		if(getNumChildren() == 1){
			try{
				setLeft(childStack.pop());
			}
			catch (EmptyStackException e){
				EPU.display("Insufficient arguments for method", true);
				return;
			}
		}
		else if(getNumChildren() == 2){
			setLeft(childStack.pop());
			setRight(childStack.pop());
		}
		childStack.push(this); 
	}
	
}
