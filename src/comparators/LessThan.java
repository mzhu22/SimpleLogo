package comparators;

import commandAbstractClasses.Operation;

public class LessThan extends Operation {


	public LessThan () {
		super(2); 
		
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ( getLeft().evaluate() < getRight().evaluate()) ? 1 : 0 ; 
	}
}
