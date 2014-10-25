package frontend.ConcreteFeatures;

import javafx.scene.text.Text;
import expressionTree.HistoryCollection;
import expressionTree.VariableNodeMap;
import frontend.AbstractFeatures.GUIFeatureWithUpdateableScrollPane;

public class HistoryWindow extends GUIFeatureWithUpdateableScrollPane{

	private HistoryCollection myHistoryCollection;
	
	public HistoryWindow(double x, double y, double width, double height, HistoryCollection hc) {
		super(x, y, width, height);
		this.myHistoryCollection = hc;
	}

	@Override
	public void updatePane() {
		String finalOutput = "History \n";
		for(String s : this.myHistoryCollection)
		{
			finalOutput +=  "\t" + s + "\n";
		}
		Text t = new Text(0, 0, finalOutput);
		t.setStyle("-fx-font-size: 14px");
		myWindow.setContent(t);
	}

}
