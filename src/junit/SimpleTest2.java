package junit;

import org.junit.Test;

import junit.framework.Assert;

public class SimpleTest2 {

	public static void main(String[] args) {
		@Test
		public void testSum() {
			int actual = 2+2;
			int expected =4;
			Assert.assertEquals(expected, actual);
		}

	}

}
