package karman.acm;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MaxSumTest {

	private MaxSum aMaxSum;

	@Before
	public void setUp() {
		int[] array = { 0, -2, -7, 0, 9, 2, -6, 2, -4, 1, -4, 1, -1, 8, 0, -2 };

		try {
			aMaxSum = new MaxSum(4, array);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testMaxSum() {
		int max = aMaxSum.getMaxSum();
		assertEquals(15, max);
	}

	@Test
	public void testGetOriginRow() {
		aMaxSum.getMaxSum();
		assertEquals(1, aMaxSum.getOriginRow());
	}

	@Test
	public void testGetOriginCol() {
		aMaxSum.getMaxSum();
		assertEquals(0, aMaxSum.getOriginCol());
	}

	@Test
	public void testGetEndRow() {
		aMaxSum.getMaxSum();
		assertEquals(3, aMaxSum.getEndRow());
	}

	@Test
	public void testGetEndCol() {
		aMaxSum.getMaxSum();
		assertEquals(1, aMaxSum.getEndCol());

	}

}
