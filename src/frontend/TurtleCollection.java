package frontend;

import java.util.ArrayList;
import static frontend.GUIMaker.EPU;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import errorsAndExceptions.ErrorPopUp;
import errorsAndExceptions.NoActiveTurtlesException;
import javafx.scene.canvas.Canvas;

public class TurtleCollection implements Iterable<Turtle>{

	private Map<Integer, Turtle> myTurtles;	
	
	private List<Turtle> myActiveTurtles;	
	
	private Canvas myCanvas;
	
	public TurtleCollection (List<Turtle> turtles, Canvas canvas){
		myCanvas = canvas;
		
		myTurtles = new HashMap<Integer, Turtle>();
		myActiveTurtles = new ArrayList<Turtle>();
		for(int i = 0; i < turtles.size(); i++){
			Turtle t = turtles.get(i);
			myTurtles.put(i, t);
			if(t.getIsActive())
			{
				myActiveTurtles.add(t);
			}
		}
	}
	
	public Turtle getLastActiveTurtle() throws NoActiveTurtlesException
	{
		try
		{
			return this.myActiveTurtles.get(this.myActiveTurtles.size() - 1);
		}
		catch (NullPointerException e)
		{
			String error = "No active turtles.";
			EPU.display(error);
			throw new NoActiveTurtlesException(error);
		}
	}
	
	public void setActiveTurtles(){
		myActiveTurtles = new ArrayList<Turtle>();
		for(Integer i : myTurtles.keySet()){
			if(myTurtles.get(i).getIsActive()){
				myActiveTurtles.add(myTurtles.get(i));
			}
		}
	}
	
	public void addTurtle(Turtle t){
		myTurtles.put(myTurtles.size(), t);
		if(t.getIsActive())
		{
			myActiveTurtles.add(t);
		}
	}
	
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
				t = new Turtle(myCanvas);
				myTurtles.put(i, t);
			}
			myActiveTurtles.add(t);
		}
	}
	
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
	
	public SLogoCanvas getCanvas(){
		return (SLogoCanvas) myCanvas;
	}
	
}
