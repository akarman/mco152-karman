package karman.dictionary;

import java.util.Random;

public class TileFactory {

	private Random random;
	private char[] letters;

	public TileFactory() {
		letters = new char[] { 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a',
				'a', 'a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c', 'd', 'd',
				'd', 'd', 'd', 'd', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e',
				'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'f', 'f',
				'f', 'g', 'g', 'g', 'g', 'h', 'h', 'h', 'i', 'i', 'i', 'i',
				'i', 'i', 'i', 'i', 'i', 'i', 'i', 'i', 'j', 'j', 'k', 'k',
				'l', 'l', 'l', 'l', 'l', 'm', 'm', 'm', 'n', 'n', 'n', 'n',
				'n', 'n', 'n', 'n', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o',
				'o', 'o', 'o', 'p', 'p', 'p', 'q', 'q', 'r', 'r', 'r', 'r',
				'r', 'r', 'r', 'r', 'r', 's', 's', 's', 's', 's', 's', 't',
				't', 't', 't', 't', 't', 't', 't', 't', 'u', 'u', 'u', 'u',
				'u', 'u', 'v', 'v', 'v', 'w', 'w', 'w', 'x', 'x', 'y', 'y',
				'y', 'z', 'z' };
		random = new Random();
	}
	
	public char getRandomTile(){
		int index=random.nextInt(145);
		return letters[index];
	}
}
