package Comparators;

import CommandAbstractClasses.Operation;

public class Not  extends Operation{



	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ( getLeft().evaluate()==0 ) ? 1 : 0;
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
