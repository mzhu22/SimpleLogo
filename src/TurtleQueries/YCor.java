package TurtleQueries;

import frontend.ActionObject;
import CommandAbstractClasses.TurtleQuery;

public class YCor  extends TurtleQuery {

	public YCor(ActionObject actionable) {
		super(actionable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myActionable.getY();
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
