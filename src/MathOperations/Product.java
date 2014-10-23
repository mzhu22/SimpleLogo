package MathOperations;

import CommandAbstractClasses.Operation;

public class Product extends Operation{

	
	public Product() {
		
		super(2); 
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return getRight().evaluate()*getLeft().evaluate() ;
	}
}
