package comparators;

import commandAbstractClasses.Operation;

public class GreaterThan extends Operation {

	public GreaterThan (){
		super(2); 
	}


	@Override
	public double evaluate() {
		return ( getLeft().evaluate() > getRight().evaluate()) ? 1 : 0 ; 
	}
}
