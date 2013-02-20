package karman.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {

	private HashMap<String, String> dictionary;

	public Dictionary(String fileName) throws FileNotFoundException {
		dictionary = new HashMap<String, String>();
		File wordFile = new File(fileName);
		String currWord;
		try {
			Scanner scanner = new Scanner(wordFile);
			while (scanner.hasNext()) {
				currWord = scanner.nextLine();
				dictionary.put(currWord, currWord);
			}
		} catch (FileNotFoundException e) {
			throw e;
		}

	}

	public boolean contains(String word) {
		return dictionary.containsKey(word);
	}

	public boolean isAnagramLoop(String word1, String word2) {
		boolean isAnagram = true;

		char[] letters = new char[word1.length()];
		for (int i = 0; i < word1.length(); i++) {
			letters[i] = word1.charAt(i);
		}

		boolean[] hasLetters = new boolean[word1.length()];

		char currLetter;
		for (int i = 0; i < word2.length(); i++) {
			currLetter = word2.charAt(i);
			for (int j = 0; j < letters.length; j++) {
				if (currLetter == letters[j]) {
					if (!hasLetters[j]) {
						hasLetters[j] = true;
					}
				}
			}
		}

		for (boolean b : hasLetters) {
			if (!b) {
				isAnagram = false;
			}
		}

		return isAnagram;

	}

	public boolean isAnagramSort(String word1, String word2) {
		char[] letters1 = word1.toCharArray();
		char[] letters2 = word2.toCharArray();

		Arrays.sort(letters1);
		Arrays.sort(letters2);

		return Arrays.equals(letters1, letters2);

	}

	public boolean isAnagramMap(String word1, String word2) {
		HashMap<Character, Integer> letters = new HashMap<Character, Integer>();
		char currLetter;
		int num;
		boolean isAnagram = true;

		for (int i = 0; i < word1.length(); i++) {
			currLetter = word1.charAt(i);
			if (letters.containsKey(currLetter)) {
				num = letters.get(currLetter);
				letters.put(currLetter, ++num);
			} else {
				letters.put(currLetter, 1);
			}
		}

		for (int i = 0; i < word2.length(); i++) {
			currLetter = word2.charAt(i);
			if (letters.containsKey(currLetter)) {
				num = letters.get(currLetter);
				if (num == 0) {
					isAnagram = false;
				} else {
					letters.put(currLetter, --num);
				}
			} else {
				isAnagram = false;
			}
		}

		for (int i = 0; i < word1.length(); i++) {
			currLetter = word1.charAt(i);
			num = letters.get(currLetter);
			if (num != 0) {
				isAnagram = false;
			}
		}
		return isAnagram;
	}
}
