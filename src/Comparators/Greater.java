package Comparators;

import CommandAbstractClasses.Operation;

public class Greater extends Operation {

	public Greater (){
		numChildren = 2; 
	}


	@Override
	public double evaluate() {
		return ( getLeft().evaluate() > getRight().evaluate()) ? 1 : 0 ; 
	}
}
