package frontend;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


public class Translator {
	
	//AAAAAMERICA!
	public static final String DEFAULT_BUNDLE = "resources.languages/English";
	private static final String START_TO_BUNDLE = "resources.languages/";
	
	private ResourceBundle myLanguage;
	
	private Map<String, String> myDictionary;
	
	public Translator(String resourceString){
		myLanguage = ResourceBundle.getBundle(resourceString);
		setUpDictionary();
	}
	
	public Translator(){
		this(DEFAULT_BUNDLE);
	}
	
	public String translate(String s){
		String translated = "";
		String[] commands = s.split("\\s+");
		for(String cmd : commands){
			translated += translateOne(cmd) + " ";
		}
		return translated;
	}
	
	
	private String translateOne(String s){
		if(myDictionary.containsKey(s)){
			return myDictionary.get(s);
		}
		return s;
	}
	
	private void setUpDictionary(){
		myDictionary = new HashMap<String, String>();
		for(String key : myLanguage.keySet()){
			String[] vals = myLanguage.getString(key).split(",");
			for(String s : vals){
				myDictionary.put(s, key);
			}
		}
	}
	
	public void setLanguage(String s){
		myLanguage = ResourceBundle.getBundle(START_TO_BUNDLE + s);
		setUpDictionary();
	}
	
}
