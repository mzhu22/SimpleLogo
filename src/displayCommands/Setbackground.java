package displayCommands;
import frontend.Turtle;

public class Setbackground extends DisplayNode {

	public Setbackground() {
		super(1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction(Turtle turtle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myValue = myLeft.evaluate();
	}

}
