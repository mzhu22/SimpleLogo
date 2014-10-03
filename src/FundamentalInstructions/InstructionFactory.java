package FundamentalInstructions;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InstructionFactory {

	public Map<String, Class<?>> myFundamentalInstructions;
	
	public FundamentalInstruction getInstruction( String instruction, List<Integer> parameters){
		
		myFundamentalInstructions = new HashMap<String, Class<?>>();
		myFundamentalInstructions.put("fd", new Forward(parameters).getClass());
		myFundamentalInstructions.put("rt", new Rotate(parameters).getClass());
		
		
		return makeInstructionInstance(instruction, parameters);
				
	}

	private FundamentalInstruction makeInstructionInstance(String instruction,
			List<Integer> parameters) {
		
		Class<?> instructionType = myFundamentalInstructions.get(instruction);
		Constructor<?> constructor = null;
		
		
		try {
			constructor = instructionType.getConstructor(parameters.getClass());
			
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		
		try {
			return (FundamentalInstruction) constructor.newInstance(parameters);
			
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
				
		
		return null;
	}

}
