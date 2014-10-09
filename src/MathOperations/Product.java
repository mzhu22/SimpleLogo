package MathOperations;

import CommandAbstractClasses.Operation;

public class Product extends Operation{

	
	public Product() {
		
		numChildren =2; 
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return getRight().evaluate()*getLeft().evaluate() ;
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
