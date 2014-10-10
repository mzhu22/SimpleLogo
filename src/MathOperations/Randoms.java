package MathOperations;

import java.util.Random;

import CommandAbstractClasses.Operation;
 

public class Randoms extends Operation {

	public Randoms () {
		numChildren = 1; 
	}
	
	@Override
	public double evaluate() {
		randomizer= new Random(); 
		return (randomizer.nextDouble()) * Math.abs(getLeft().evaluate());
	}
}
