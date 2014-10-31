import static org.junit.Assert.*;

import java.util.EmptyStackException;
import java.util.List;

import org.junit.Test;

import displayCommands.DisplayNode;
import expressionTree.ExpressionTreeBuilder;

public class AnalysisJUnitTests {

	@Test
	public void returnsRightNumberOfInstructionsDefault(){
		ExpressionTreeBuilder tester = new ExpressionTreeBuilder("Forward 50");
		assertEquals(tester.getOutputList().size(), 1);
		
		tester = new ExpressionTreeBuilder("Forward 50 Right 50 Right 50");
		assertEquals(tester.getOutputList().size(), 3);
	}
	
	@Test
	public void correctTreeStructureDefualt(){
		ExpressionTreeBuilder tester = new ExpressionTreeBuilder("Forward Forward 50");
		List<DisplayNode> list = tester.getOutputList();
		assertEquals(list.get(0).getNumChildren(), 1);
		assertEquals(list.get(1).getNumChildren(), 1);
	}
	
	@Test(expected=EmptyStackException.class)
	public void catchesSyntaxErrorsDefaultInput(){
		ExpressionTreeBuilder tester = new ExpressionTreeBuilder("Forward 50 50");
	}
	
	@Test
	public void returnsRightNumberOfInstructionsComplex(){
		ExpressionTreeBuilder tester = new ExpressionTreeBuilder("SetPalette 5 30 50 10");
		assertEquals(tester.getOutputList().size(), 1);
		
		tester = new ExpressionTreeBuilder("SetPalette SetPalette 5 30 50 10 5 10 40 SetPalette 3 5 1 20 3");		
	}
	
	@Test
	public void correctTreeStructureComplex(){
		ExpressionTreeBuilder tester = new ExpressionTreeBuilder("SetPalette 50 1 2 3");
		List<DisplayNode> list = tester.getOutputList();
		assertEquals(list.get(0).getNumChildren(), 4);
		
		tester = new ExpressionTreeBuilder("( sum 50 50 50 50 50 50 )");
		assertEquals(list.get(1).getNumChildren(), 6);	
	}
	
	@Test(expected=EmptyStackException.class)
	public void catchsSyntaxErrorsComplexInput(){
		ExpressionTreeBuilder tester = new ExpressionTreeBuilder("SetPalette 5");
		
		tester = new ExpressionTreeBuilder("SetPalette 1 1 1 1 1 1 1");
	}
}
	