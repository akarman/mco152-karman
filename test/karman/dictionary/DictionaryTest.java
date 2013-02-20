package karman.dictionary;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

import karman.dictionary.Dictionary;

import org.junit.Before;
import org.junit.Test;

public class DictionaryTest {

	Dictionary myDictionary;

	@Before
	public void setUp() {
		try {
			myDictionary = new Dictionary("./wordlist.txt");
		} catch (FileNotFoundException e) {
			fail("file error");
		}
	}

	@Test
	public void testContains() {
		assertTrue(myDictionary.contains("hello"));
	}

	@Test
	public void testDoesNotContain() {
		assertTrue(!myDictionary.contains("aaaa"));
	}
	
	@Test
	public void testIsAnagramLoop(){
		assertTrue(myDictionary.isAnagramLoop("pears", "spear"));
	}
	
	@Test
	public void testIsNotAnagramLoop(){
		assertTrue(!myDictionary.isAnagramLoop("hello", "hi"));
	}
	
	@Test
	public void testIsAnagramSort(){
		assertTrue(myDictionary.isAnagramSort("pears", "spear"));
	}
	
	@Test
	public void testIsNotAnagramSort(){
		assertTrue(!myDictionary.isAnagramSort("hello", "heloo"));
	}
	
	@Test
	public void testIsAnagramMap(){
		assertTrue(myDictionary.isAnagramMap("apple", "aplpe"));
	}
	
	@Test
	public void testIsNotAnagramMap(){
		assertTrue(!myDictionary.isAnagramMap("apple", "aplle"));
	}

}
