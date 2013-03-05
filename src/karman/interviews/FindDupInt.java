package karman.interviews;

public class FindDupInt {

	public int[] numbers;

	public FindDupInt(int[] numbers) {
		this.numbers = numbers;
	}

	public int findDup() {
		int mid;
		int low = 0;
		int high = numbers.length - 1;

		while (low <= high) {
			mid = (high + low) / 2;
			int midValue=numbers[mid];
			if (midValue < mid) {
				if (midValue==numbers[mid-1]) {
					return midValue;
				}
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

}
