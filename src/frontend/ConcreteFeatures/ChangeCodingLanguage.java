package frontend.ConcreteFeatures;

import java.io.File;
import java.util.Arrays;

import frontend.Translator;
import frontend.AbstractFeatures.GUIFeatureWithDropDown;

public class ChangeCodingLanguage extends GUIFeatureWithDropDown{

	private static final String LANGUAGE_FOLDER_NAME = "src/resources/languages/";
	private static final int LANGUAGE_FOLDER_NAME_LENGTH = LANGUAGE_FOLDER_NAME.length();
	private Translator myTranslator;
	
	public ChangeCodingLanguage(double x, double y, String prompt, Translator t) {
		super(x, y, prompt);
		myTranslator = t;
	}

	@Override
	public void fillItemList() {
		File[] files = new File(LANGUAGE_FOLDER_NAME).listFiles();
		
		for (File file : files) {
			myItems.add(file.toString().substring(
					file.toString().indexOf(LANGUAGE_FOLDER_NAME) + LANGUAGE_FOLDER_NAME_LENGTH,
					file.toString().length()));
		}
	}

	@Override
	public void doDropDownClickAction(String chosen) {
		myTranslator.setLanguage(chosen.split("\\.")[0]);
	}

}
