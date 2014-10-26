package frontend.ConcreteFeatures;

import static frontend.SLogoWorkspace.CANVAS_HEIGHT;
import static frontend.SLogoWorkspace.CANVAS_WIDTH;

import java.util.Map;
import java.util.TreeMap;

import frontend.Turtle;
import frontend.TurtleCollection;
import frontend.AbstractFeatures.SLogoScrollPane;

/**
 * This class represents a pane on which the 
 * active turtles' statistics are displayed.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class TurtleStatsWindow extends SLogoScrollPane{

	TurtleCollection myTurtleCollection;

	/**
	 * Constructor
	 * 
	 * @see SLogoScrollPane#GUIFeatureWithUpdateableScrollPane(double, double, double, double)
	 * @param turtles The turtles to display the statistics of
	 */
	public TurtleStatsWindow(double x, double y, double width, double height, TurtleCollection turtles) {
		super(x, y, width, height, "\t Active Turtle Statistics \n");
		myTurtleCollection = turtles;
	}

	/**
	 * Adds the stats of the current active turtles to the pane.
	 * The stats include: X, Y, Heading, Showing, and Pen Down.
	 */
	@Override
	public void updatePane() {
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
				finalOutput += s + "\t" + turtleInfo.get(s) + "\n";
			}
			finalOutput += "\n";
		}
		super.updatePane();
	}
}
