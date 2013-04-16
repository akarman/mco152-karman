package karman.dictionary;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class WordFind {

	private TileFactory tileFactory;
	private char[] tiles;
	private Dictionary dictionary;
	private ArrayList<String> words;

	public WordFind(int numTiles) throws FileNotFoundException {
		try {
			dictionary = new Dictionary("./wordlist.txt");
		} catch (FileNotFoundException e) {
			throw e;
		}
		tileFactory = new TileFactory();
		tiles = new char[numTiles];
		chooseTiles(numTiles);
		words = new ArrayList<String>();
	}

	public WordFind(char[] tiles) throws FileNotFoundException {
		try {
			dictionary = new Dictionary("./wordlist.txt");
		} catch (FileNotFoundException e) {
			throw e;
		}
		this.tiles = tiles;
		words = new ArrayList<String>();
	}

	private void chooseTiles(int numTiles) {
		for (int i = 0; i < numTiles; i++) {
			tiles[i] = tileFactory.getRandomTile();
			System.out.println(tiles[i]);
		}
	}

	private ArrayList<String> findAnagrams(String prefix, String word) {
		if (word.length() < 1) {
			words.add(prefix);
		} else
			for (int i = 0; i < word.length(); i++) {
				String currentPrefix = word.substring(i, i + 1);
				String before = word.substring(0, i);
				String after = word.substring(i + 1);

				findAnagrams(prefix + currentPrefix, before + after);
			}
		return words;
	}

	private ArrayList<String> findAllPermutations(ArrayList<String> allAnagrams) {
		ArrayList<String> permutations = new ArrayList<String>();
		for (String anagram : allAnagrams) {
			for (int i = 0; i < anagram.length(); i++) {
				permutations.add(anagram.substring(i, anagram.length()));
			}
		}
		return permutations;

	}

	private ArrayList<String> convertToArrayList(
			HashMap<String, String> possibleWords) {
		ArrayList<String> words = new ArrayList<String>();
		Iterator<Entry<String, String>> mapIter = possibleWords.entrySet()
				.iterator();
		String word;
		while (mapIter.hasNext()) {
			word = mapIter.next().getValue();
			words.add(word);
		}

		return words;

	}

	public ArrayList<String> getPossibleWords() {
		String allChars = String.valueOf(tiles);
		
		ArrayList<String> allAnagrams = findAnagrams("", allChars);

		ArrayList<String> permutations = findAllPermutations(allAnagrams);
		HashMap<String, String> possibleWordsMap = new HashMap<String, String>();
		for (String permutation : permutations) {
			if (dictionary.contains(permutation)) {
				if (!possibleWordsMap.containsKey(permutation)) {
					possibleWordsMap.put(permutation, permutation);
				}
			}
		}
		return convertToArrayList(possibleWordsMap);
	}                                                                                       

}