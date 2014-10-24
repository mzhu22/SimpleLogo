package mathOperations;

import commandAbstractClasses.Operation;

public class Cosine extends Operation {

	public Cosine(){
		
		super(1);  
	}


	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return Math.cos((PI*getLeft().evaluate())/ONE_EIGHTY);
	}
}
