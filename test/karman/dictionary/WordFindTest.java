package karman.dictionary;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class WordFindTest {
	
	private WordFind aWordFind;
	private ArrayList<String> words;

	@Before
	public void setUp() {
		try {
			aWordFind=new WordFind("redfigo".toCharArray());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		words=aWordFind.getPossibleWords();
		
	}
	
	@Test
	public void testGetPossibleWords(){
		assertTrue(words.contains("red"));
		assertTrue(words.contains("fig"));
		assertTrue(words.contains("grid"));
		assertTrue(words.contains("rid"));
		assertTrue(words.contains("fried"));
		assertTrue(words.contains("frog"));
	}
	
	@Test
	public void testDoesNotGetImpossibleWords(){
		assertTrue(!words.contains("redfigo"));
		assertTrue(!words.contains("fgordi"));
		assertTrue(!words.contains("ddref"));
		assertTrue(!words.contains("orfgid"));
	}

}
