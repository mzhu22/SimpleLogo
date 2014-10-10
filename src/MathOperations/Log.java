package MathOperations;

import CommandAbstractClasses.Operation;

public class Log extends Operation {

	public Log (){
		
		numChildren = 1; 
	}
	

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return Math.log(getLeft().evaluate());
	}

}
