package instructions;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import backend.ScreenObjectModel;

public class doNothing extends FundamentalInstruction {

	public doNothing(List<Integer> parameters) {
		super(parameters,0, null, null);
	}
}
