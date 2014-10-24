package comparators;

import commandAbstractClasses.Operation;

public class Equal extends Operation {

	public Equal (){
		
		 super(2); 
	}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ( getLeft().evaluate() == getRight().evaluate()) ? 1 : 0 ; 
	}



}
