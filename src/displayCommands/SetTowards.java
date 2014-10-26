package displayCommands;

import frontend.Turtle;

public class SetTowards extends DisplayNode {
	
	private double myNewHeading;

	public SetTowards(){
		super(2); 
	}


	@Override
	public void doAction(Turtle turtle) {
		turtle.setDirection(myNewHeading);
	}

	/**
	 * Sets myValue equal to the change in heading
	 */
	@Override
	public double evaluate() {
		double x1 = myLeft.evaluate();
		double y1 = myRight.evaluate();
		
		double currentHeading = 0; //Get this from Heading query
		
		double x0 = 0; //Get this from XCoordinate query
		double y0 = 0; //Get this from YCoordinate query
		
		double xDist = x1-x0;
		double yDist = y1-y0;
		
		if(xDist==0){
			if(yDist>0){
				myNewHeading = 90;
			}
			else if(yDist<0){
				myNewHeading = 270;
			}
			else{
				myNewHeading = 0;
			}
		}
		else{
			myNewHeading = Math.atan(yDist/xDist);
		}
		
		return myValue = myNewHeading-currentHeading;
	}

}
