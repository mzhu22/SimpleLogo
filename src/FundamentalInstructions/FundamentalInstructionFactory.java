package FundamentalInstructions;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class FundamentalInstructionFactory {

	public Map<String, Class<?>> myFundamentalInstructions;
	
	public FundamentalInstruction getInstruction( String instruction, int parameters){
		
		myFundamentalInstructions = new HashMap<String, Class<?>>();
		myFundamentalInstructions.put("FD", new Forward(parameters).getClass());
		myFundamentalInstructions.put("FORWARD",new Forward(parameters).getClass()); 
		
		
		return makeInstructionInstance(instruction, parameters);
				
	}

	private FundamentalInstruction makeInstructionInstance(String instruction,
			int parameter) {
		
		Class<?> instructionType = myFundamentalInstructions.get(instruction);
		Constructor<?> constructor = null;
		
		
		try {
			constructor = instructionType.getConstructor(int.class);
			
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		
		try {
			return (FundamentalInstruction) constructor.newInstance(parameter);
			
			
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
