package frontend;

import java.util.List;

import frontend.AbstractFeatures.GUIFeatureWithUpdateableScrollPane;

/**
 * This class updates the panes that show updateable
 * information, like History and Turtle Stats. 
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class PaneUpdater {

	private List<GUIFeatureWithUpdateableScrollPane> myUpdateables;
	
	/**
	 * Constructor.
	 * 
	 * @param updateables List of panes with updateable information.
	 */
	public PaneUpdater(List<GUIFeatureWithUpdateableScrollPane> updateables) {
		myUpdateables = updateables;
	}

	/**
	 * Loops through the updateable panes and updates them. 
	 */
	public void updateAll()
	{
		for(GUIFeatureWithUpdateableScrollPane f: myUpdateables)
		{
			f.updatePane();
		}
	}
}
