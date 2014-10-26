package frontend;

import static frontend.GUIMaker.EPU;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javafx.scene.canvas.Canvas;
import errorsAndExceptions.SLogoException;

/**
 * A class representing a wrapper for a collection of turtles.
 * Only allows specific things to be done, including iterating over it, 
 * adding a turtle, and setting new turtles.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class TurtleCollection implements Iterable<Turtle>{

	private Map<Integer, Turtle> myTurtles;	//Maps ID to a turtle
	private List<Turtle> myActiveTurtles;	//has active turtles 
	private Canvas myCanvas;
	
	/**
	 * Constructor. Also sets up the turtles map and active turtles list.
	 * 
	 * @param turtles The initial list of turtles to be in this collection.
	 * @param canvas The canvas the turtles are added to.
	 */
	public TurtleCollection (List<Turtle> turtles, Canvas canvas){
		myCanvas = canvas;
		myTurtles = new HashMap<Integer, Turtle>();
		myActiveTurtles = new ArrayList<Turtle>();
		for(int i = 0; i < turtles.size(); i++){
			Turtle t = turtles.get(i);
			myTurtles.put(t.getID(), t);
			checkAndAddActiveTurtle(t);
		}
	}
	
	/**
	 * Gets the last active turtle for queries.
	 * Throws a SLogoException is there are 
	 * no active turtles.
	 * 
	 * @return The last active turtle.
	 */
	public Turtle getLastActiveTurtle() throws SLogoException
	{
		try
		{
			return this.myActiveTurtles.get(this.myActiveTurtles.size() - 1);
		}
		catch (NullPointerException e)
		{
			String error = "No active turtles.";
			EPU.display(error, false);
			throw new SLogoException(error);
		}
	}
	
	/**
	 * Adds a turtle to the turtle map 
	 * and to the active list if it is active.
	 * 
	 * @param t The turtle to be added.
	 */
	public void addTurtle(Turtle t){
		myTurtles.put(myTurtles.size(), t);
		checkAndAddActiveTurtle(t);
	}

	/**
	 * @param t
	 */
	private void checkAndAddActiveTurtle(Turtle t) {
		if(t.getIsActive())
		{
			myActiveTurtles.add(t);
		}
	}
	
	/**
	 * Takes a list of turtles and makes these, and only
	 * these, active. Used with Tell.
	 * 
	 * @param turtles List of turtles to be added as active.
	 */
	public void setActiveTurtles(List<Integer> turtles){
		for(Turtle t : myActiveTurtles)
		{
			t.setActive(false);
		}
		myActiveTurtles = new ArrayList<Turtle>();
		for(Integer i : turtles)
		{
			Turtle t;
			if(myTurtles.containsKey(i))
			{
				t = myTurtles.get(i);
				t.setActive(true);
			}
			else
			{
				t = new Turtle(myCanvas, i);
				myTurtles.put(t.getID(), t);
			}
			myActiveTurtles.add(t);
		}
	}
	
	/**
	 * Manually sets the active turtle list
	 * based on the current turtle map. Used after a user
	 * clicks on turtles to toggle their activeness.
	 */
	public void setActiveTurtles(){
		myActiveTurtles = new ArrayList<Turtle>();
		for(Integer i : myTurtles.keySet()){
			this.checkAndAddActiveTurtle(myTurtles.get(i));
		}
	}
	
	/**
	 * Iterator that iterates only the active turtles.
	 */
	@Override
	public Iterator<Turtle> iterator() {
		return new Iterator<Turtle>(){
			
			private int myCounter = -1;

			@Override
			public boolean hasNext() {
				return myCounter < myActiveTurtles.size()-1;
			}

			@Override
			public Turtle next() {
				myCounter++;
				return myActiveTurtles.get(myCounter);
			}
			
		};
	}
	
	/**
	 * Gets the canvas turtles are added to. 
	 * @return The canvas turtles are added to.
	 */
	public SLogoCanvas getCanvas(){
		return (SLogoCanvas) myCanvas;
	}
	
}
