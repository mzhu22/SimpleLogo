package backend;

import java.util.List;

import ExpressionTree.InputToNode;

public class Parser {
	
	
	public List<String> parse (String input){
		
		InputToNode tokenGenerator = new InputToNode(); 	

    	return tokenGenerator.splitIntoTokens(input); 
	}
	
	public static void main (String[] args){
		
		String check = "fd sum sum sum sum 10 20 30 5 5"; 

		Parser toParse = new Parser(); 
		List<String> tester = toParse.parse(check); 
			
			System.out.println(tester.toString() + " " );
		
	}
	
}
