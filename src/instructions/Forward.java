package instructions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import backend.ScreenObjectModel;
import Interfaces.IInstruction;


public class Forward extends FundamentalInstruction implements IInstruction{

	public Forward( List<Integer> parameters){
		super(parameters, 1, "fd", "moveForward");
	}
}
