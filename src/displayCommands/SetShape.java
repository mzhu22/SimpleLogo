package displayCommands;

import java.util.Arrays;

import static frontend.GUIMaker.EPU;
import errorsAndExceptions.InvalidImageIndexException;
import frontend.Turtle;
import static frontend.SLogoTab.IMAGE_LIST;

public class SetShape extends DisplayNode{

	public SetShape() {
		super(1);
	}

	@Override
	public void doAction(Turtle turtle) throws InvalidImageIndexException{
		try{
			turtle.changeImage(IMAGE_LIST[(int) myValue].trim());
		}
		catch(ArrayIndexOutOfBoundsException e){
			String error = "Not valid image index.";
			EPU.display(error);
			throw new InvalidImageIndexException(error);
		}
	}

	@Override
	public double evaluate() {
		return myValue = myLeft.evaluate();
	}

}
