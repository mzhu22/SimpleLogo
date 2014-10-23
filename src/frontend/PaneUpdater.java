package frontend;

import java.util.List;

import frontend.AbstractFeatures.GUIFeatureWithUpdateableScrollPane;

public class PaneUpdater {

	private List<GUIFeatureWithUpdateableScrollPane> myUpdateables;
	
	public PaneUpdater(List<GUIFeatureWithUpdateableScrollPane> updateables) {
		myUpdateables = updateables;
	}

	public void updateAll()
	{
		for(GUIFeatureWithUpdateableScrollPane f: myUpdateables)
		{
			f.updatePane();
		}
	}
}
