package comparators;

import commandAbstractClasses.Operation;


public class And extends Operation {

	public And() {
		super(2); 
	}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ( (getLeft().evaluate() * getRight().evaluate()) != 0 ) ? 1 : 0 ; 
	}
}
