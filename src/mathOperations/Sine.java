package mathOperations;

import commandAbstractClasses.Operation;

public class Sine extends Operation {
	
	public Sine () {
		
		super(1); 
	}
	

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return Math.sin((PI*getLeft().evaluate())/ONE_EIGHTY);
	}
}
