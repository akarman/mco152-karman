package karman.interviews;

import java.util.HashMap;

public class NoDupStrings {

	private String[] words;
	private HashMap<String, String> wordsToPrint;

	public NoDupStrings(String[] words) {
		this.words = words;
		wordsToPrint = new HashMap<String, String>();

	}

	public void printWords() {
		for (int i = 0; i < words.length; i++) {
			if (!wordsToPrint.containsKey(words[i])) {
				wordsToPrint.put(words[i], words[i]);
				System.out.println(words[i]);
			}
		}
	}
	
	public static void main(String[] args){
		String[] letters= new String[]{
				"A", "B", "C", "A", "B"
		};
		
		NoDupStrings test= new NoDupStrings(letters);
		test.printWords();
	}

}