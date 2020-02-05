
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;

import Worldline.uk.Assignment.Poker;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	final static Logger logger = Logger.getLogger(AppTest.class);

	final static String[] stubbedData = { "5H 5C 6S 7S KD 2C 3S 1S 1D TD", "5D 8C 9S JS AC 2C 5C 7D QS QH",
			"6H 2C 3S 4S 5D 2D 3D 6S KD AD", "2D 3D 6S KD AD 6H 2C 3S 4S 5D", "AS AC AH 4S 5D 2D 3D 6S KD AD",
			"2D 3D 6S KD 6H AS AC AH 4S 5D" };

	Class<Poker> pokerClass;
	Method method;
	Method methodWinners;

	@Override
	protected void setUp() throws Exception {

		pokerClass = Poker.class;
		Class<Poker> pokerClass = Poker.class;
		method = pokerClass.getDeclaredMethod("parseHands", String.class);
		methodWinners = pokerClass.getDeclaredMethod("winner", long[].class);
		method.setAccessible(true);
		methodWinners.setAccessible(true);
	}

	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	public void testPositivePairs() throws IOException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		long[] r = (long[]) method.invoke(null, stubbedData[0]);
		int k = (int) methodWinners.invoke(null, r);
		assertEquals(k, 1);
	}

	public void testNegativePairs() throws IOException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		long[] r = (long[]) method.invoke(null, stubbedData[1]);
		int k = (int) methodWinners.invoke(null, r);
		assertNotSame(k, 1);
	}

	public void testPositiveStraight() throws IOException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		long[] r = (long[]) method.invoke(null, stubbedData[2]);
		int k = (int) methodWinners.invoke(null, r);
		assertEquals(k, 1);
	}

	public void testNegativeStraight() throws IOException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		long[] r = (long[]) method.invoke(null, stubbedData[3]);
		int k = (int) methodWinners.invoke(null, r);
		assertNotSame(k, 1);
	}

	public void testPositive3OfKind() throws IOException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		long[] r = (long[]) method.invoke(null, stubbedData[4]);
		int k = (int) methodWinners.invoke(null, r);
		assertEquals(k, 1);
	}

	public void testNegative3OfKind() throws IOException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		long[] r = (long[]) method.invoke(null, stubbedData[5]);
		int k = (int) methodWinners.invoke(null, r);
		assertNotSame(k, 1);
	}
}
