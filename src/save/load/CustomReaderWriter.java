package save.load;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import expressionTree.UserFunctionMap;
import expressionTree.VariableNodeMap;

public class CustomReaderWriter {
	/**
	 * Used to write user-defined methods and functions to and from a .sav file. Extracts
	 * these parameters from the VariableNodeMap and UserFunctionMap for write, updates 
	 * them for read.
	 */
	public CustomReaderWriter(){
		
	}
	
	public void writeToFile() throws IOException{
		FileOutputStream file = new FileOutputStream("slogo_variables.sav");
		ObjectOutputStream writer = new ObjectOutputStream(file);
		
		VariableNodeMap currentVariables = VariableNodeMap.getVariableNodeMap();
		UserFunctionMap currentFunctions = UserFunctionMap.getUserFunctionMap();
		
		CustomParameters output = new CustomParameters(currentVariables, currentFunctions);
		
		writer.writeObject(output);
		
		writer.close();
	}
	
	public void readFromFile() throws IOException, ClassNotFoundException{
		FileInputStream file = new FileInputStream("slogo_variables.sav");
		ObjectInputStream reader = new ObjectInputStream(file);		
		VariableNodeMap currentVars = VariableNodeMap.getVariableNodeMap();
		UserFunctionMap currentFuncs = UserFunctionMap.getUserFunctionMap();
		
		CustomParameters params = (CustomParameters) reader.readObject();
		
		currentVars.applyLoadedMap(params.getVariables());
		currentFuncs.applyLoadedMap(params.getFunctions());
		
		reader.close();
	}
}
