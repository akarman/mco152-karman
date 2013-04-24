package karman.regex;

import static org.junit.Assert.*;

import org.junit.Test;

public class PhoneNumberVerifierTest {

	@Test
	public void testVerify() {
		PhoneNumberVerifier verifier = new PhoneNumberVerifier();
		assertTrue(verifier.verify("2562345668"));
		assertTrue(verifier.verify("2345668"));
		assertFalse(verifier.verify("22"));
		assertFalse(verifier.verify("12342345")); //one without area code
		assertTrue(verifier.verify("1-2222345678"));
		assertTrue(verifier.verify("1 2222345678"));
		assertTrue(verifier.verify("1 222 234 5678"));
		assertTrue(verifier.verify("1-222-234-5678"));
	}

}
