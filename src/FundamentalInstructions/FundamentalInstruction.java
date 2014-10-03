package FundamentalInstructions;
import backend.Instruction;
public abstract class FundamentalInstruction extends Instruction {
	 
	protected int myParameter;
	protected static String myCode; //Change for different languages later


	public FundamentalInstruction( int parameter, String Code){
		myParameter = parameter; 
		myCode = Code; 
	}


	public String toString(){
		StringBuilder toRet = new StringBuilder(); 
	
		toRet.append(myCode + " :" + myParameter); 	
		return toRet.toString(); 
	}
	

	public abstract Number doAction();
	
	// TO DO pass doaction actionable frontend object

	protected int getParameters(){
		return myParameter; 
	}	
}

