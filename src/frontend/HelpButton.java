package frontend;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class HelpButton extends GUIFeatureWithButton {

	private final static int WIDTH = 800;
	private final static int HEIGHT = 600;
	private final static String DEFAULT_ADDRESS = "http://www.cs.duke.edu/courses/compsci308/current/assign/03_slogo/commands.php";
	private final static String TITLE = "Help Page";
	private String myWebAddress;
	
	public HelpButton(double x, double y, String buttonName, String address)
	{
		super(x,y, buttonName);
		this.myWebAddress = address;
		
	}
	public HelpButton(double x, double y, String buttonName) {
		this(x, y, buttonName, DEFAULT_ADDRESS);
	}

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
