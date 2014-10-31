// This entire file is part of my masterpiece.
// Dimeji Abidoye

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
 * @author Dimeji Abidoye 
 *
 */
public class Repeat extends DisplayNode{

	public Repeat (){
		super(2) ; 
	}
	
	@Override
	public double evaluate() {
		evaluateAllChildren(); 
		return myValue;
	}

	public void doAction(Turtle turtle) {
		
	}

	@Override
	public List<DisplayNode> makeInstructionList(){

		List<DisplayNode> instructionList = new ArrayList<>();	

		for(int i =0 ; i < getChild(MY_LEFT_CHILD).evaluate(); i++){
			instructionList.addAll(super.makeInstructionList()); 
		}
		return instructionList;
	}
}
