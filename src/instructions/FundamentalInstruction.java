package instructions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import backend.ScreenObjectModel;

public abstract class FundamentalInstruction {
	
	protected int myNumParameters ; 
	protected String myMethodName; 
	private List<Integer> myParameters; 
	protected static String myCode; //Change for different languages later


	public FundamentalInstruction( List<Integer> parameters, int numParameters, String Code, String methodName ){
		myParameters = parameters; 
		myNumParameters = numParameters ;
		myCode = Code; 
		myMethodName = methodName; 
	}


	public String toString(){
		StringBuilder toRet = new StringBuilder(); 
		
		toRet.append("I am going to perform "+ myMethodName+". my Parameters are : "); 
		
		for(Integer i : myParameters){
			toRet.append(i +" " + "\n"); 
		}
		toRet.append(" . I have "+myNumParameters +" parameters."); 	
		return toRet.toString(); 
	}
	

	public void doAction( ScreenObjectModel actionable) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		Method method = actionable.getClass().getMethod(myMethodName, getParameters().getClass());
		method.invoke(actionable, getParameters() );
		
	} 

	protected List<Integer> getParameters(){
		return myParameters; 
	}

}

