package mathOperations;

import java.util.Random;

import commandAbstractClasses.Operation;
 

public class SlogoRandom extends Operation {

	public SlogoRandom () {
		super(1);  
	}
	
	@Override
	public double evaluate() {
		randomizer= new Random(); 
		return (randomizer.nextDouble()) * Math.abs(getLeft().evaluate());
	}
}
