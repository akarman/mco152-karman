package karman.interviews;

import java.util.Random;

public class NSort {

	public static void main(String[] args) {
		Random random = new Random();
		int numbers[] = new int[100];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(10001);
		}

		int array[] = new int[10001];
		for (int number : numbers) {
			array[number]++;
		}

		for (int i = 0; i < 10001; i++) {
			if (array[i] != 0) {
				System.out.println(i + " " + array[i]);
			}

		}
	}

}
