package Comparators;

import CommandAbstractClasses.Operation;

public class Less extends Operation {


	public Less () {
		numChildren = 2; 
		
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ( getLeft().evaluate() < getRight().evaluate()) ? 1 : 0 ; 
	}
}
