package frontend.ConcreteFeatures;

import expressionTree.HistoryCollection;
import static frontend.SLogoWorkspace.GUI_NAMES;
import frontend.AbstractFeatures.SLogoScrollPane;

/**
 * This class represents a window with an updateable history of commands run.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class HistoryWindow extends SLogoScrollPane{

	private HistoryCollection myHistoryCollection;
	
	/**
	 * Constructor.
	 * 
	 * @see SLogoScrollPane#GUIFeatureWithUpdateableScrollPane(double, double, double, double)
	 * @param hc The HistoryCollection to grab the history from.
	 */
	public HistoryWindow(double x, double y, double width, double height, HistoryCollection hc) {
		super(x, y, width, height,"\t" + GUI_NAMES.getString("History") + "\n");
		this.myHistoryCollection = hc;
	}

	/**
	 * {@inheritDoc}
	 * Adds new history commands to the pane.
	 */
	@Override
	public void updatePane() {
		finalOutput = initialString;
		for(String s : this.myHistoryCollection)
		{
			finalOutput +=  s + "\n";
		}
		super.updatePane();
	}

}
