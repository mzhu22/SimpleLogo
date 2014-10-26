package controlStructures;


import java.util.ArrayList;
import java.util.List;

import turtleClasses.Turtle;
import displayCommands.DisplayNode;

/**
 * Used to enable repeat instructions and for loops. Repeat simply holds subsequent 
 * instructions as children. When makeInstructionList is called, Repeat calls 
 * makeInstructionList on its children N times, where N is the input to Repeat.
 * 
 * Repeat relies heavily on the ListNode class, as the Logo syntax for repeat is 
 * repeat N [ commands ]. In this case, Repeat holds the ListNode representing all 
 * commands in the [] as a child.
 *  
 * @author Mike Zhu
 *
 */
public class Repeat extends DisplayNode{

	public Repeat (){
		super(2) ; 
	}
	
	@Override
	public double evaluate() {
		//Evaluate this node == evaluate all children first (make sure each node has a val)
		
		getLeft().evaluate();
		getRight().evaluate();
		return 0;
	}

	public void doAction(Turtle turtle) {
		
	}

	@Override
	public List<DisplayNode> makeInstructionList(){

		List<DisplayNode> instructionList = new ArrayList<>();	

		for(int i =0 ; i < getLeft().evaluate(); i++){
			if(getLeft()!=null){
				instructionList.addAll(getLeft().makeInstructionList());
			}
			if(DisplayNode.class.isAssignableFrom(getClass())){
				instructionList.add((DisplayNode)this);
			}
			if(getRight()!=null){
				instructionList.addAll(getRight().makeInstructionList());
			}
		}
		return instructionList;
	}
}
