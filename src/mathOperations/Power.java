package mathOperations;

import commandAbstractClasses.Operation;

public class Power extends Operation {


	
	public Power (){
		
		super(2); 
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return Math.pow(getLeft().evaluate(), getRight().evaluate());
	}
}
