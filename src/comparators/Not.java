package comparators;

import commandAbstractClasses.Operation;

public class Not  extends Operation{

	public Not(){
		super( 1); 
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ( getLeft().evaluate()==0 ) ? 1 : 0;
	}
}
