package backend;

import java.util.ArrayList;
import java.util.List;

public class Parser {
	public List<String> parse (String input){
    	input = input.toLowerCase();
    	
    	List<String> insnList = new ArrayList<>();
    	String[] splitInput = input.split(" ");
    	
    	for(String s: splitInput){
    		String insn = s;
    		insnList.add(insn);
    	}
    	
    	return insnList;
    }

}
