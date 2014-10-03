package instructions;

import java.util.List;

public class InstructionFactory {


	public Instruction getInstruction( String instruction, List<Integer> parameters){

		switch (instruction) {

		case "ft": return new Forward(parameters);  


		default : return new doNothing(parameters); 
		}



	}

}
