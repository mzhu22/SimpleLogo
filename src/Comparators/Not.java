package Comparators;

import CommandAbstractClasses.Operation;

public class Not  extends Operation{

	public Not(){
		numChildren = 1; 
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ( getLeft().evaluate()==0 ) ? 1 : 0;
	}
}
