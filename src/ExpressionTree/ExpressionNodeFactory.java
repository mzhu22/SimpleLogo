package ExpressionTree;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import CommandAbstractClasses.Constant;
import Comparators.*;
import FundamentalInstructions.doNothing;
import MathOperations.*; 

public final class ExpressionNodeFactory implements Observable {


	public ExpressionNode getNode( String s){

		ExpressionNode toReturn; 
		double constant =0; 

		try{
			constant = Double.parseDouble(s); 
		}
		catch(NumberFormatException e ){


			switch (s) {
			case "SUM" : case  "+": return new Add(); 

			case "DIFFERENCE" : case "-": return new Difference(); 

			case  "PRODUCT" : case "*" : return new Product(); 

			case "QUOTIENT" : case "/" : return new Quotient(); 

			case "REMAINDER" : case "%" : return new Remainder(); 

			case "MINUS" : case "~": return new Minus(); 

			case "RANDOM" : return new Randoms();

			case "SIN" : return new Sine(); 

			case "COS" : return new Cosine(); 

			case "TAN" : return new Tangent(); 

			case "ATAN" : return new Arctan(); 

			case "LOG" : return new Log(); 

			case "POW" : return new Power(); 

			case "AND" : return new And(); 

			case "OR" : return new Or(); 

			case "NOT" : return new Not(); 

			case "NOTEQUAL?" : case "NOTEQUALP" :return new NotEqual(); 

			case "EQUAL?" : case "EQUALP" :return new Equal(); 

			case "GREATER?" : case "GREATERP" :return new Greater(); 

			case "LESS?" : case  "LESSP" : return new Less(); 

			default: return new doNothing(); 

			}
		}


		toReturn = new Constant(); 
		toReturn.setInfo(constant); 
		return toReturn; 

	}

	@Override
	public void addListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}


//	public static void main(String[] args){
//
//		String []  tester = {"SUM","+", "DIFFERENCE","-", "PRODUCT", "*", "QUOTIENT" , "/" , "REMAINDER", 
//				"%", "MINUS" ,  "~", "RANDOM", "SIN", "COS" , "TAN", "ATAN" , "LOG", "POW", "5", "boobs"
//				, "AND" , "OR" , "NOT" , "NOTEQUAL?" , "NOTEQUALP", "EQUAL?","EQUALP" , "GREATER?", "GREATERP", "LESS?",
//		"LESSP"}; 
//
//
//		for(String s: tester){
//
//			System.out.println(getNode(s).getClass().toString()); 
//		}
//	}

}


