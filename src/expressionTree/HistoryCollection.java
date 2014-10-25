package expressionTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HistoryCollection implements Iterable<String>{

	private List<String> myHistory;
	
	public HistoryCollection(){
		myHistory = new ArrayList<String>();
	}
	
	public void add(String s){
		myHistory.add(s);
	}
	
	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>(){
			
			private int myCounter = 0;

			@Override
			public boolean hasNext() {
				return (myCounter < myHistory.size());
			}

			@Override
			public String next() {
				myCounter++;
				return myHistory.get(myCounter-1);
				
			}
			
		};
	}
	
	
}
