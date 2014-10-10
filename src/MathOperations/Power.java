package MathOperations;

import CommandAbstractClasses.Operation;

public class Power extends Operation {


	
	public Power (){
		
		numChildren = 2; 
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return Math.pow(getLeft().evaluate(), getRight().evaluate());
	}
}
