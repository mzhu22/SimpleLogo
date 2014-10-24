package save.load;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import expressionTree.VariableNodeMap;

public class FileWriter {
	public FileWriter(){
		
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	public void writeToFile() throws IOException{
		FileOutputStream file = new FileOutputStream("slogo_configs.sav");
		ObjectOutputStream writer = new ObjectOutputStream(file);
		
		VariableNodeMap currentVariables = VariableNodeMap.getVariableNodeMap();
		
		writer.writeObject(currentVariables);
		
		writer.close();
	}
	
	public void readFromFile() throws IOException, ClassNotFoundException{
		FileInputStream file = new FileInputStream("slogo_configs.sav");
		ObjectInputStream reader = new ObjectInputStream(file);
		VariableNodeMap readVariables = (VariableNodeMap) reader.readObject();
		
		//TODO: output readVariables
		
		reader.close();
	}
	
	/**
	 * For testing
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main (String[] args) throws IOException, ClassNotFoundException{
		FileWriter tester = new FileWriter();
		tester.writeToFile();
		tester.readFromFile();
	}
}
