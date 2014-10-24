package comparators;

import commandAbstractClasses.Operation;

public class Or extends Operation {

	public Or(){
		super(2); 
	}


	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ( (getLeft().evaluate() + getRight().evaluate()) != 0 ) ? 1 : 0 ; 
	}
}
