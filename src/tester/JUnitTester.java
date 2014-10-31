package tester;

import static org.junit.Assert.assertTrue;
import java.util.ResourceBundle;
import org.junit.Test;
import frontend.SLogoCanvas;
import frontend.AbstractFeatures.GUIFeature;
import frontend.AbstractFeatures.SLogoButton;
import frontend.ConcreteFeatures.ToggleGridLines;

public class JUnitTester {

	SLogoCanvas myCanvas = new SLogoCanvas(0,0,0,0);
	ToggleGridLines myGridToggler = new ToggleGridLines(0, 0, "Toggle", myCanvas);
	
	@Test
	public void checkProperInstance(){
		assertTrue(myGridToggler instanceof GUIFeature && myGridToggler instanceof SLogoButton);
	}
	
	@Test
	public void checkPosition(){
		assertTrue(myGridToggler.getX() == 0);
	}
	
	@Test
	public void checkName(){
		assertTrue(myGridToggler.getName().equals("Toggle"));
	}
	
	@Test
	public void checkLanguage(){
		ResourceBundle lang = ResourceBundle.getBundle("resources.buttonLanguages/SpanishButtonNames");
		ToggleGridLines toggler = new ToggleGridLines(0, 0, lang.getString("ToggleGrid"), myCanvas);
		assertTrue(toggler.getName().equals("Alternar Cuadro"));
	}
	
	/**
	 * It is very difficult to test the functionality
	 * of this button, since it affects a grid which is
	 * private to a canvas which is private to the button.
	 * I had to write 2 getters to simply write these tests.
	 */
}
