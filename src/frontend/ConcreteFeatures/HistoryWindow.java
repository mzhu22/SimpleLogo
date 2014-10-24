package frontend.ConcreteFeatures;

import javafx.scene.text.Text;
import expressionTree.HistoryCollection;
import expressionTree.VariableNodeMap;
import frontend.AbstractFeatures.GUIFeatureWithUpdateableScrollPane;

public class HistoryWindow extends GUIFeatureWithUpdateableScrollPane{

	private HistoryCollection myHistoryCollection;
	
	public HistoryWindow(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	@Override
	public void updatePane() {

	}

}
