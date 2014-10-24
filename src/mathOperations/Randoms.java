package mathOperations;

import java.util.Random;

import commandAbstractClasses.Operation;
 

public class Randoms extends Operation {

	public Randoms () {
		super(1);  
	}
	
	@Override
	public double evaluate() {
		randomizer= new Random(); 
		return (randomizer.nextDouble()) * Math.abs(getLeft().evaluate());
	}
}
