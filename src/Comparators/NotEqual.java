package Comparators;

import CommandAbstractClasses.Operation;

public class NotEqual extends Operation {



	@Override
	public double evaluate() {
		return ( getLeft().evaluate() != getRight().evaluate()) ? 1 : 0 ; 
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
