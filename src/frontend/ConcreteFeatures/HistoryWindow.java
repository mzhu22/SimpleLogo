package frontend.ConcreteFeatures;

import javafx.scene.text.Text;
import expressionTree.HistoryCollection;
import frontend.AbstractFeatures.GUIFeatureWithUpdateableScrollPane;

/**
 * This class represents a window with an updateable history of commands run.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class HistoryWindow extends GUIFeatureWithUpdateableScrollPane{

	private HistoryCollection myHistoryCollection;
	
	/**
	 * Constructor.
	 * 
	 * @see GUIFeatureWithUpdateableScrollPane#GUIFeatureWithUpdateableScrollPane(double, double, double, double)
	 * @param hc The HistoryCollection to grab the history from.
	 */
	public HistoryWindow(double x, double y, double width, double height, HistoryCollection hc) {
		super(x, y, width, height);
		this.myHistoryCollection = hc;
	}

	/**
	 * {@inheritDoc}
	 * Adds new history commands to the pane.
	 */
	@Override
	public void updatePane() {
		String finalOutput = "\t History \n";
		for(String s : this.myHistoryCollection)
		{
			finalOutput +=  s + "\n";
		}
		Text t = new Text(0, 0, finalOutput);
		t.setStyle("-fx-font-size: 14px");
		myWindow.setContent(t);
	}

}
