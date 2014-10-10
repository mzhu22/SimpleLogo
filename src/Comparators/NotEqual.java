package Comparators;

import CommandAbstractClasses.Operation;

public class NotEqual extends Operation {

	public NotEqual (){
		
		numChildren = 2; 
	}


	@Override
	public double evaluate() {
		return ( getLeft().evaluate() != getRight().evaluate()) ? 1 : 0 ; 
	}
}
