package karman.interviews;

public class AlphabetSort {

	private char[] letters;

	public AlphabetSort(String book) {
		letters = book.toCharArray();
	}

	public int[] sortLetters() {
		int[] array = new int[256];
		for (int i = 0; i < letters.length; i++) {
			array[letters[i]]++;
		}
		return array;
	}

	public static void main(String[] args) {
		AlphabetSort mySort = new AlphabetSort("Hi how are you?\n");
		int[] letters=mySort.sortLetters();
		
		for(int i=0; i<letters.length;i++){
			System.out.println((char)i+": " + letters[i]);
		}
	}
}
