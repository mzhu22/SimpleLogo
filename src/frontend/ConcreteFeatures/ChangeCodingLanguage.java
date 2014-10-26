package frontend.ConcreteFeatures;

import frontend.Translator;
import frontend.AbstractFeatures.SLogoDropDown;

/**
 * This class represents a button that allows the user to 
 * change the language to code in.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class ChangeCodingLanguage extends SLogoDropDown{

	private Translator myTranslator;
	
	/**
	 * 
	 * @see SLogoDropDown#GUIFeatureWithDropDown(double, double, String)
	 * @param t The Translator object for this drop down.
	 */
	public ChangeCodingLanguage(double x, double y, String prompt, Translator t) {
		super(x, y, prompt, "src/resources/languages/");
		myTranslator = t;
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
