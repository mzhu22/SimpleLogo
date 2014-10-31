// This entire file is part of my masterpiece.
// Dimeji Abidoye

package displayCommands;

import static frontend.GUIMaker.EPU;
import static frontend.SLogoWorkspace.IMAGE_LIST;
import turtleClasses.Turtle;

public class SetShape extends DisplayNode{

	public SetShape() {
		super(1);
	}

	@Override
	public void doAction(Turtle turtle) {
		try{
			turtle.changeImage(IMAGE_LIST[(int) myValue].trim());
		}
		catch(ArrayIndexOutOfBoundsException e){
			EPU.display("Not valid image index.", true);
		}
	}

	@Override
	public double evaluate() {
		return myValue = getChild(MY_LEFT_CHILD).evaluate();
	}

}
