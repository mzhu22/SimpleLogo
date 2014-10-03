package CommandAbstractClasses;

public abstract class Operation extends AnyCommands {
	protected Object myFirstOperand; 
	protected Object mySecondOperand;
	
	public Operation( Object first, Object second){
		myFirstOperand = first; 
		mySecondOperand = second; 
	} 
	
	public abstract int operate();
	
}
