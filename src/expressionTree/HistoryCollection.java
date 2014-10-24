package expressionTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HistoryCollection<T> implements Iterable<T>{

	private List<T> myHistory;
	
	public HistoryCollection(){
		myHistory = new ArrayList<T>();
	}
	
	public void add(T s){
		myHistory.add(s);
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			
			private int myCounter = 0;

			@Override
			public boolean hasNext() {
				return (myCounter < myHistory.size());
			}

			@Override
			public T next() {
				myCounter++;
				return myHistory.get(myCounter-1);
				
			}
			
		};
	}
	
	
}
