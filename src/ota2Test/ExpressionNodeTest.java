// This entire file is part of my masterpiece.
// Dimeji Abidoye
package ota2Test;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.Stack;
import mathOperations.*;

import org.junit.Test;

import commandAbstractClasses.*; 
import expressionTree.ExpressionNode;

public class ExpressionNodeTest {

	int childrenToTest = 20;
	Random helper = new Random(); 
	Stack<ExpressionNode> builder = new Stack<>();
	ExpressionNode testNode;   
	
	/**
	 * This is a test on a Node with some random functionality that I have defined as pleases me 
	 */
	@Test
	public void testExampleEvaluate() {
		
		testNode = new FlexibleSetChildrenTester(childrenToTest);
		builder.push(testNode); 
		
		int store =0 ; 
		for( int i = 0 ; i <childrenToTest ; i ++){
			int toAdd = helper.nextInt(20); 
			ExpressionNode temp = new Constant(); 
			store += toAdd; 
			temp.setValue(toAdd); 
			builder.push(temp); 
		}
		testNode.setChildren(builder);
		testNode.evaluate(); 
		assertEquals(store,60.0, testNode.getValue());
	}

	
	@Test
	public void testEvaluateSingleChild(){
		testNode = new FlexibleSetChildrenTester(childrenToTest);
		builder.push(testNode);
		for( int i = 0 ; i <childrenToTest ; i ++){
			int toAdd = helper.nextInt(20); 
			ExpressionNode temp = new Constant(); 
			temp.setValue(toAdd); 
			builder.push(temp); 
		}
		testNode.setChildren(builder); 
		
		builder.clear(); 
		ExpressionNode add = new Sum(); 
		builder.push(add);
		ExpressionNode fifty = new Constant(50);
		builder.push(fifty);
		ExpressionNode ten = new Constant(10); 
		builder.push(ten); 
		add.setChildren(builder);
		testNode.setChild(add, 1); 
		testNode.evaluateChild(1);
		assertEquals( 60, 60, testNode.getChild(1).getValue()); 
	}
	
	
	@Test
	public void testNumChildren(){
		testNode = new FlexibleSetChildrenTester(childrenToTest);
		assertEquals(childrenToTest,0.0, testNode.getChildrenNum()); 
	}

	

}
