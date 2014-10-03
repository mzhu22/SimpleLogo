package FundamentalInstructions;
import java.util.List;
public abstract class FundamentalInstruction {
	
	protected int myNumParameters ;  
	protected List<Integer> myParameters;
	protected static String myCode; //Change for different languages later


	public FundamentalInstruction( List<Integer> parameters, int numParameters, String Code){
		myParameters = parameters; 
		myNumParameters = numParameters ;
		myCode = Code; 
	}


	public String toString(){
		StringBuilder toRet = new StringBuilder(); 
		
		toRet.append("my Parameters are : "); 
		
		for(Integer i : myParameters){
			toRet.append(i +" " + "\n"); 
		}
		toRet.append(" . I have "+myNumParameters +" parameters."); 	
		return toRet.toString(); 
	}
	

	public abstract Object doAction();
	
	// TO DO pass doaction actionable frontend object

	protected List<Integer> getParameters(){
		return myParameters; 
	}	
}

