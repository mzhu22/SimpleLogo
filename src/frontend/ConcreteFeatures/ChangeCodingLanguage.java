package frontend.ConcreteFeatures;

import java.io.File;

import frontend.Translator;
import frontend.AbstractFeatures.GUIFeatureWithDropDown;

/**
 * This class represents a button that allows the user to 
 * change the language to code in.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class ChangeCodingLanguage extends GUIFeatureWithDropDown{

	private static final String LANGUAGE_FOLDER_NAME = "src/resources/languages/";
	private static final int LANGUAGE_FOLDER_NAME_LENGTH = LANGUAGE_FOLDER_NAME.length();
	private Translator myTranslator;
	
	/**
	 * 
	 * @see GUIFeatureWithDropDown#GUIFeatureWithDropDown(double, double, String)
	 * @param t The Translator object for this drop down.
	 */
	public ChangeCodingLanguage(double x, double y, String prompt, Translator t) {
		super(x, y, prompt);
		myTranslator = t;
	}

	/**
	 * Grabs the language folders and fills the drop down with those file names.
	 */
	@Override
	public void fillItemList() {
		File[] files = new File(LANGUAGE_FOLDER_NAME).listFiles();
		
		for (File file : files) {
			myItems.add(file.toString().substring(
					file.toString().indexOf(LANGUAGE_FOLDER_NAME) + LANGUAGE_FOLDER_NAME_LENGTH,
					file.toString().length()));
		}
	}

	/**
	 * {@inheritDoc}
	 * Sets the chosen language.
	 */
	@Override
	public void doDropDownClickAction(String chosen) {
		myTranslator.setLanguage(chosen.split("\\.")[0]);
	}

}
