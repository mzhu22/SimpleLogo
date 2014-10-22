package MathOperations;

import CommandAbstractClasses.Operation;

public class Quotient  extends Operation {

	public Quotient (){
		
		super(2);  
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return getLeft().evaluate() / getRight().evaluate() ;
	}
}
