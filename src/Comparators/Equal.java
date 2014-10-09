package Comparators;

import CommandAbstractClasses.Operation;

public class Equal extends Operation {

	public Equal (){
		
		numChildren = 2; 
	}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ( getLeft().evaluate() == getRight().evaluate()) ? 1 : 0 ; 
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
