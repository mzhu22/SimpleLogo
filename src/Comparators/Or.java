package Comparators;

import CommandAbstractClasses.Operation;

public class Or extends Operation {



	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ( (getLeft().evaluate() + getRight().evaluate()) != 0 ) ? 1 : 0 ; 
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}