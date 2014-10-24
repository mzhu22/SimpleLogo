package frontend;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TurtleCollection implements Iterable<Turtle>{

	private Map<Integer, Turtle> myTurtles;
	
	
	public TurtleCollection (List<Turtle> turtles){
		myTurtles = new HashMap<Integer, Turtle>();
		for(int i = 0; i < turtles.size(); i++){
			myTurtles.put(i, turtles.get(i));
		}
	}
	
	public void addTurtle(Turtle t){
		myTurtles.put(myTurtles.size(), t);
	}
	
	@Override
	public Iterator<Turtle> iterator() {
		return new Iterator<Turtle>(){
			
			private int myCounter = -1;

			@Override
			public boolean hasNext() {
				return myCounter < myTurtles.size()-1;
			}

			@Override
			public Turtle next() {
				myCounter++;
				return myTurtles.get(myCounter);
			}
			
		};
	}
	
}
