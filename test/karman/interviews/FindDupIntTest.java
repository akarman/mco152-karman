package karman.interviews;

import org.junit.Assert;
import org.junit.Test;

public class FindDupIntTest {
		
	@Test
	
	public void testFindDup(){
		int[] numbers= new int[]{0,1,2,3,4,5,6,7,8,8};
		FindDupInt duplicateFinder= new FindDupInt(numbers);
		Assert.assertEquals(8, duplicateFinder.findDup());
	}
	
	@Test
	public void testNoDup(){
		int[] numbers= new int[]{0,1,2,3,4,5,6,7,8,9};
		FindDupInt duplicateFinder= new FindDupInt(numbers);
		Assert.assertEquals(-1, duplicateFinder.findDup());
	}

}