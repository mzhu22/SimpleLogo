package backend;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import FundamentalInstructions.*;

public class ParserTest {

	public List<Instruction> testInstructions = new ArrayList<Instruction>();
	public Forward forward = new Forward(0);
	
	
	@Test
	public void checkNotNull(){
		assertTrue(forward != null);
	}
	
	@Test
	public void checkSubclassFund(){
		assertTrue("is instance of Fundamental Instruction", forward instanceof FundamentalInstruction);
	}
	
	@Test
	public void checkSubclassInstr(){		
		assertTrue("is instance of Instruction", forward instanceof Instruction);
	}
	
	@Test 
	public void checkToString(){
		assertEquals("toString is correct", "fd :0", forward.toString());
	}

	@Test
	public void checkAction(){
		//will be better once the forward instruction is implemented
		assertEquals("doAction working", forward.doAction(), 0);
	}

}
