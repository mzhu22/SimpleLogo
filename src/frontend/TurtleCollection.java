package frontend;

import java.util.Iterator;
import java.util.List;

public class TurtleCollection implements Iterable{

	private List<Turtle> myTurtles;
	
	@Override
	public Iterator iterator() {
		return new Iterator(){

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Object next() {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
	}
	
}
