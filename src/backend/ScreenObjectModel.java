package backend;

import java.lang.reflect.InvocationTargetException;

import instructions.FundamentalInstruction;

public abstract class ScreenObjectModel {
	
	

	public void actionTaker(FundamentalInstruction  action){		
		try {
			try {
				action.doAction(this);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	protected abstract void moveForward( double displacement);
	
	protected abstract void rotateDegrees( double degrees); 

	protected abstract void doNothing(); 
}
