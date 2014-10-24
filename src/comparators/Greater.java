package comparators;

import commandAbstractClasses.Operation;

public class Greater extends Operation {

	public Greater (){
		super(2); 
	}


	@Override
	public double evaluate() {
		return ( getLeft().evaluate() > getRight().evaluate()) ? 1 : 0 ; 
	}
}
