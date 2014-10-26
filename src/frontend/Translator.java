package frontend;

import java.util.HashMap;
import static frontend.SLogoWorkspace.GUI_PREFERENCES;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * This class represents a translator to translate
 * entered SLogo commands into English, the language 
 * that the parser recognizes.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class Translator {
	
	public static final String DEFAULT_BUNDLE = "resources.languages/" + GUI_PREFERENCES.getString("StartingLanguage");
	private static final String START_TO_BUNDLE = "resources.languages/";
	
	private ResourceBundle myLanguage;
	
	private Map<String, String> myDictionary;
	
	/**
	 * Constructor.
	 * 
	 * @param resourceString The String representing the resource bundle to be the language.
	 */
	public Translator(String resourceString){
		myLanguage = ResourceBundle.getBundle(resourceString);
		setUpDictionary();
	}
	
	/**
	 * Constructor that uses the default bundle.
	 */
	public Translator(){
		this(DEFAULT_BUNDLE);
	}
	
	/**
	 * This method takes in a string, splits it by whitespace, translates
	 * each element, and concatenates it together and returns it.
	 * 
	 * @param s The String to translate.
	 * @return The translated String according the the language resource bundle.
	 */
	public String translate(String s){
		String translated = "";
		String[] commands = s.split("\\s+");
		for(String cmd : commands){
			translated += translateOne(cmd) + " ";
		}
		return translated;
	}
	
	/**
	 * Translates one command based on the resource bundle.
	 * 
	 * @param s The String to translate, which is one translateable command.
	 * @return The translated String.
	 */
	private String translateOne(String s){
		s = s.toLowerCase();
		if(myDictionary.containsKey(s)){
			return myDictionary.get(s);
		}
		return s;
	}
	
	/**
	 * Sets up the dictionary that allows translation. Essentially
	 * inverts the map given by the resource bundle so that
	 * the other language commands are the keys and the English 
	 * translations used by the parser are the values.
	 */
	private void setUpDictionary(){
		myDictionary = new HashMap<String, String>();
		for(String key : myLanguage.keySet()){
			String[] vals = myLanguage.getString(key).split(",");
			for(String s : vals){
				myDictionary.put(s, key);
			}
		}
	}
	
	/**
	 * Sets the language resource bundle.
	 * 
	 * @param s The String representing the resource bundle language to be set.
	 */
	public void setLanguage(String s){
		myLanguage = ResourceBundle.getBundle(START_TO_BUNDLE + s);
		setUpDictionary();
	}
	
}
