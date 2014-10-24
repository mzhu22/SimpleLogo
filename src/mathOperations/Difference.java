package mathOperations;

import commandAbstractClasses.Operation;

public class Difference extends Operation {

	public Difference (){
		
		super(2); 
	}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return getLeft().evaluate() - getRight().evaluate();
	}
}
