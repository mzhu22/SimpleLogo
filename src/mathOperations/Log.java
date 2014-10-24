package mathOperations;

import commandAbstractClasses.Operation;

public class Log extends Operation {

	public Log (){
		
		super(1);  
	}
	

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return Math.log(getLeft().evaluate());
	}

}
