// This entire file is part of my masterpiece
// MIKE ZHU

package expressionTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import displayCommands.DisplayNode;

/**
 * MASTERPIECE REWRITE - now handles any number of children without needing to overwrite
 * setChildren or similar methods. Default constructor still creates node for expression
 * with 2 input params.	
 * 
 * Superclass for node representation of all instructions within the expression tree. 
 * 
 * Default assumes that Node has two children, as the vast majority of Slogo commands take
 * in either one or two inputs. 
 * 
 * Only evaluate() is abstract. Evaluate() sets the node's value by recursively evaluating
 * its children - this method differs for different types of commands.
 * 
 * @author Mike Zhu
 *
 */
public abstract class ExpressionNode {
	protected double myValue; 
	private List<ExpressionNode> myChildren;
	protected int numChildren; 
	
	protected List<DisplayNode> instructionList; 
	
	/**
	 * Default number of children is 2. The vast majority of Slogo commands are part of 
	 * this group
	 */	
	public ExpressionNode(){
		numChildren = 2; 
		myChildren = new ArrayList<ExpressionNode>();
	} 

	/**
	 * Constructor used for those Slogo instructions that do not take in 2 input parameters
	 * @param numChild
	 */
	public ExpressionNode(int numChild){
		numChildren = numChild;		
		myChildren = new ArrayList<ExpressionNode>();
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

		for(int i=0; i<myChildren.size()-1; i++){
			if(myChildren.get(i)!=null){
				instructionList.addAll(myChildren.get(i).makeInstructionList());
			}
		}
		if(DisplayNode.class.isAssignableFrom(this.getClass())){
			instructionList.add((DisplayNode)this);
		}
		if(getLastChild()!=null){
			instructionList.addAll(getLastChild().makeInstructionList());
		}
		
		return instructionList;
	}
	
	protected ExpressionNode getChild(int i){
		return myChildren.get(i);
	}
	
	protected ExpressionNode getLastChild(){
		if(myChildren.size()==0){
			return null;
		}
		return myChildren.get(myChildren.size()-1);
	}
	
	protected void addChild(ExpressionNode toAdd){
		myChildren.add(toAdd);
		numChildren--;
	}
	
	public int getNumChildren(){
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
		while(numChildren!=0){
			addChild(childStack.pop());
		}
		childStack.push(this); 
	}

	public void setValue(double constant) {
		myValue = constant;
	}
	
}
