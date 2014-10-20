package controlStructures;


import java.util.ArrayList;
import java.util.List;

import FundamentalInstructions.FundamentalInstruction;
import frontend.Turtle;

public class Repeat extends FundamentalInstruction{

	
	public Repeat (){
		
		numChildren = 2 ; 
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
	public List<FundamentalInstruction> makeInstructionList(){

		List<FundamentalInstruction> instructionList = new ArrayList<>();	

		for(int i =0 ; i < getLeft().evaluate(); i++){
			if(getLeft()!=null){
				instructionList.addAll(getLeft().makeInstructionList());
			}
			if(FundamentalInstruction.class.isAssignableFrom(getClass())){
				instructionList.add((FundamentalInstruction)this);
			}
			if(getRight()!=null){
				instructionList.addAll(getRight().makeInstructionList());
			}
		}
		return instructionList;
	}
}
