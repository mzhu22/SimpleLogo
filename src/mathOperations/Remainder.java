package mathOperations;

import commandAbstractClasses.Operation;

public class Remainder extends Operation {

	
	public Remainder (){
		
		super(2); 
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return getLeft().evaluate() % getRight().evaluate();
	}
}
