package MathOperations;

import CommandAbstractClasses.Operation;

public class Quotient  extends Operation {

	public Quotient (){
		
		numChildren =2; 
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return getLeft().evaluate() / getRight().evaluate() ;
	}
}
