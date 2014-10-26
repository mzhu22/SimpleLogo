package mathOperations;

import java.util.Random;

import commandAbstractClasses.Operation;
 
/**
 * This class is named SlogoRandom because there is already a class named Random.
 * @author Mike Zhu
 *
 */

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
