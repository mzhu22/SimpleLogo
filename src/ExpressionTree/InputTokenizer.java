package ExpressionTree;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputTokenizer {


	
	public static List<String> splitIntoTokens(String s){
		ArrayList<String> tokensToReturn = new ArrayList<String>();

		StringTokenizer split = new StringTokenizer(s, " ");
		while (split.hasMoreTokens()) {
			tokensToReturn.add(split.nextToken()); 
			
		}
		return tokensToReturn;
	}


}

