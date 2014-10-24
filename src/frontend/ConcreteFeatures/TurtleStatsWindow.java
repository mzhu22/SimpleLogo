package frontend.ConcreteFeatures;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.Group;
import javafx.scene.text.Text;
import frontend.Turtle;
import frontend.AbstractFeatures.GUIFeatureWithUpdateableScrollPane;
import static frontend.SLogoTab.CANVAS_HEIGHT;
import static frontend.SLogoTab.CANVAS_WIDTH;

public class TurtleStatsWindow extends GUIFeatureWithUpdateableScrollPane{

	Turtle myTurtle;
	
	public TurtleStatsWindow(double x, double y, double width, double height, Turtle turtle) {
		super(x, y, width, height);
		myTurtle = turtle;
	}

	@Override
	public void updatePane() {
		Map<String, String> turtleInfo = new HashMap<String, String>();
		turtleInfo.put("X:", ((Long) Math.round((myTurtle.getX() - CANVAS_WIDTH/2))).toString());
		turtleInfo.put("Y:", ((Long) Math.round(myTurtle.getY() - CANVAS_HEIGHT/2)).toString());
		turtleInfo.put("Heading:", ((Long) Math.round(myTurtle.getDirection())).toString());
		turtleInfo.put("Showing:", ((Boolean) myTurtle.isShowing()).toString());
		turtleInfo.put("Pen Down:", ((Boolean) myTurtle.getPen().isPenDown()).toString());

		String finalOutput = "Statistics \n";
		
		for(String s : turtleInfo.keySet()){
			finalOutput += "\t" + s + "\t" + turtleInfo.get(s) + "\n";
		}
		Text t = new Text(0, 0, finalOutput);
		t.setStyle("-fx-font-size: 14px");
		myWindow.setContent(t);
		
	}

	

}
