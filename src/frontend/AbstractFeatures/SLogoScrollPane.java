package frontend.AbstractFeatures;

import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;

/**
 * This class represents a GUIFeature that uses a ScrollPane to display information.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 */
public abstract class SLogoScrollPane extends GUIFeature {

	private double myWidth;
	private double myHeight;
	protected ScrollPane myWindow;
	protected String finalOutput;
	protected String initialString;
	
	/**
	 * Constructor.
	 * 
	 * @see GUIFeature#GUIFeature(double, double)
	 * @param width The width of the ScrollPane.
	 * @param height The height of the ScrollPane.
	 * @param s The final output header.
	 */
	public SLogoScrollPane(double x, double y, double width, double height, String s) {
		super(x, y);
		myWidth = width;
		myHeight = height;
		finalOutput = s;
		initialString = s;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void action() {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Group makeTool() {
		Group g = new Group();
		myWindow = new ScrollPane();
		myWindow.setLayoutX(myX);
		myWindow.setLayoutY(myY);
		myWindow.setPrefSize(myWidth, myHeight);
		updatePane();
		g.getChildren().add(myWindow);
		return g;
	}
	
	/**
	 * Update the ScrollPane to represent the new data.
	 */
	public void updatePane()
	{
		Text t = new Text(0, 0, finalOutput);
		t.setStyle("-fx-font-size: 14px");
		myWindow.setContent(t);
	}

}
