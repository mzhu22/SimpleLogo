package controlStructures;

import java.util.List;

import ExpressionTree.ExpressionNode;

public class Repeat extends ExpressionNode{

	protected List<ExpressionNode> myInstructions;
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		for(int i=1; i<getLeft().evaluate(); i++){
			myInstructions.add(getRight());
		}
		return 0;
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		for(ExpressionNode insn: myInstructions){
			insn.doAction();
		}
	}

}
