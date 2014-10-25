package frontend.ConcreteFeatures;

import static frontend.SLogoTab.CANVAS_HEIGHT;
import static frontend.SLogoTab.CANVAS_WIDTH;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javafx.scene.text.Text;
import frontend.Turtle;
import frontend.TurtleCollection;
import frontend.AbstractFeatures.GUIFeatureWithUpdateableScrollPane;

public class TurtleStatsWindow extends GUIFeatureWithUpdateableScrollPane{

	TurtleCollection myTurtleCollection;

	public TurtleStatsWindow(double x, double y, double width, double height, TurtleCollection turtles) {
		super(x, y, width, height);
		myTurtleCollection = turtles;
	}

	@Override
	public void updatePane() {
		String finalOutput = "Active Turtle Statistics \n";
		myTurtleCollection.setActiveTurtles();
		for(Turtle myTurtle : myTurtleCollection)
		{
			Map<String, String> turtleInfo = new TreeMap<String, String>();
			turtleInfo.put("X:", ((Long) Math.round((myTurtle.getX() - CANVAS_WIDTH/2))).toString());
			turtleInfo.put("Y:", ((Long) Math.round(-1* (myTurtle.getY() - CANVAS_HEIGHT/2))).toString());
			turtleInfo.put("Heading:", ((Long) Math.round(myTurtle.getDirection())).toString());
			turtleInfo.put("Showing:", ((Boolean) myTurtle.isShowing()).toString());
			turtleInfo.put("Pen Down:", ((Boolean) myTurtle.getPen().isPenDown()).toString());

			for(String s : turtleInfo.keySet()){
				finalOutput += "\t" + s + "\t" + turtleInfo.get(s) + "\n";
			}
			finalOutput += "\n";
		}
		Text t = new Text(0, 0, finalOutput);
		t.setStyle("-fx-font-size: 14px");
		myWindow.setContent(t);

	}



}
