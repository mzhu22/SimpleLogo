package CommandAbstractClasses;

public abstract class Comparator extends Operation{

	public Comparator(Number first, Number second) {
		super(first, second);
	}

	
	public int operate(){
		return compare(); 
	}
	
	public abstract int compare(); 
	
}
