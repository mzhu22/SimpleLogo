package frontend.ConcreteFeatures;

import javafx.scene.Group;
import static frontend.SLogoWorkspace.GUI_PREFERENCES;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import frontend.AbstractFeatures.SLogoButton;

/**
 * This class represents a button that allows
 * the user to access a help page.
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class Help extends SLogoButton {

	private final static int WIDTH = 800;
	private final static int HEIGHT = 600;
	private final static String DEFAULT_ADDRESS = GUI_PREFERENCES.getString("HelpAddress");
	private final static String TITLE = "Help Page";
	private String myWebAddress;
	
	/**
	 * Constructor with custom web address.
	 * 
	 * @see SLogoButton#GUIFeatureWithButton(double, double, String)
	 * @param address The web address to go to.
	 */
	public Help(double x, double y, String buttonName, String address)
	{
		super(x,y, buttonName);
		this.myWebAddress = address;
		
	}
	
	/**
	 * Constructor that loads default address.
	 * 
	 * @see SLogoButton#GUIFeatureWithButton(double, double, String)
	 */
	public Help(double x, double y, String buttonName) {
		this(x, y, buttonName, DEFAULT_ADDRESS);
	}

	/**
	 * {@inheritDoc}
	 * Opens up a web browser window at the specified address.
	 */
	@Override
	public void action() {
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		webEngine.load(this.myWebAddress);
		Group g = new Group();
		g.getChildren().add(browser);
		Stage s = new Stage();
		s.setTitle(TITLE);
		s.setScene(new Scene(g, WIDTH, HEIGHT));
		s.show();
	}

}
