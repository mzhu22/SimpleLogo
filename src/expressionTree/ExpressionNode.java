// This entire file is part of my masterpiece.
// Dimeji Abidoye


package expressionTree;

import static frontend.GUIMaker.EPU;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

import displayCommands.DisplayNode;

/**
 * Superclass for node representation of all instructions within the expression tree. 
 * Refactored to still compile, number of children now do not matter
 * @author Dimeji Abidoye
 *
 */
public abstract class ExpressionNode {
	protected double myValue; 
	protected List<ExpressionNode> myChildren; 
	protected static final int MY_LEFT_CHILD = 0 ; 
	protected static final int MY_RIGHT_CHILD = 1 ; 
	protected int numChildren; 
	protected List<DisplayNode> instructionList ; 


	public ExpressionNode(int numChild){
		numChildren = numChild;		
		myChildren =new ArrayList<>(); 
	}

	public abstract double evaluate(); 

	/**
	 * Extracts the displayNodes (those nodes sent to the frontend and run to move the
	 * turtle) using in-order traversal starting from this node. Thus returns insns
	 * in the order that they were typed.
	 * 
	 * This allows for nested "recursive" instructions.
	 * @return
	 */
	public List<DisplayNode> makeInstructionList(){
		instructionList = new ArrayList<>();

		if(getChild(MY_LEFT_CHILD)!=null){
			instructionList.addAll(getChild(MY_LEFT_CHILD).makeInstructionList());
		}
		if(DisplayNode.class.isAssignableFrom(this.getClass())){
			instructionList.add((DisplayNode)this);
		}
		if(getChild(MY_RIGHT_CHILD)!=null){
			instructionList.addAll(getChild(MY_RIGHT_CHILD).makeInstructionList());
		}
		return instructionList;

	}
	

	/**
	 * returns the child node at index n
	 */
	public ExpressionNode getChild(int n){
		return myChildren.get(n); 
	} 


	/**
	 * sets the child not at index to toSet
	 */
	public void setChild( ExpressionNode toSet, int index ){
		myChildren.set(index, toSet); 
	}

	public void setValue(double a){
		myValue = a; 
	}

	public int getChildrenNum(){
		return getNumChildren(); 
	}
	
	protected int getNumChildren(){
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
		while(numChildren !=0 ){
			try{
				myChildren.add(childStack.pop());
				numChildren --; }
			catch (EmptyStackException e){
				EPU.display("Insufficient arguments for method", true);
			}
		}
		childStack.push(this); 
	}

	/**
	 * Evaluates all children
	 */
	protected void evaluateAllChildren(){
		for( ExpressionNode n : myChildren ){
			n.evaluate();
		}
	}
	
	/**
	 * Evaluates a specified range of children from start(inclusive) to end (exclusive) 
	 */
	protected void evaluateChildRange(int start, int end){
	
		for( ExpressionNode n : myChildren.subList(start, end)){
			n.evaluate(); 
		}
	}
	
	public void evaluateChild(int child){
		myChildren.get(child).evaluate(); 
	}
	
}

