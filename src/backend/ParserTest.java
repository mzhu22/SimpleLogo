package backend;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

public class ParserTest {

	@Test
	public void test() {
		String toTest = "The quick brown fox jumps over the lazy dog"; 
		Parser parse = new Parser(); 
		List<String> checker = parse.parse(toTest); 
		
		fail("Not yet implemented");
	}

}
