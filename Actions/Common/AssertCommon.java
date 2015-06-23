
package Common;
import org.testng.Assert;
import org.testng.Reporter;

public class AssertCommon {
		
		public static boolean verifyTrue(boolean condition, boolean halt) {
			boolean pass = true;
			if (halt == false) {
				try {
					Assert.assertTrue(condition);
				} catch (Throwable e) {
					pass = false;
					VerificationFailures.getFailures().addFailureForTest(
							Reporter.getCurrentTestResult(), e);
				}
			} else {
				Assert.assertTrue(condition);
			}
			return pass;
		}

		public static boolean verifyTrue(boolean condition) {
			return verifyTrue(condition, false);
		}

		public static boolean verifyFalse(boolean condition, boolean halt) {
			boolean pass = true;
			if (halt == false) {
				try {
					Assert.assertFalse(condition);
				} catch (Throwable e) {
					pass = false;
					VerificationFailures.getFailures().addFailureForTest(
							Reporter.getCurrentTestResult(), e);
				}
			} else {
				Assert.assertFalse(condition);
			}
			return pass;

		}

		public static boolean verifyFalse(boolean condition) {
			return verifyFalse(condition, false);
		}

		public static boolean verifyEquals(Object actual, Object expected, boolean halt) {
			boolean pass = true;
			if (halt == false) {
				try {				
					Assert.assertEquals(actual, expected);				
				} catch (Throwable e) {
					pass = false;
					VerificationFailures.getFailures().addFailureForTest(
							Reporter.getCurrentTestResult(), e);
				}
			} else {
				Assert.assertEquals(actual, expected);
			}
			return pass;
		}

		public static boolean verifyEquals(Object actual, Object expected) {
			return verifyEquals(actual, expected, false);
		}
		public static boolean verifyNotEquals(Object actual, Object expected, boolean halt)
		{
			boolean pass = false;
			if (halt == false) {
				try {				
					Assert.assertNotEquals(actual, expected);				
				} catch (Throwable e) {
					pass = false;
					VerificationFailures.getFailures().addFailureForTest(
							Reporter.getCurrentTestResult(), e);
				}
			} else {
				Assert.assertNotEquals(actual, expected);
			}
			return pass;
		}
		public static boolean verifyNotEquals(Object actual, Object expected)
		{		
			return verifyNotEquals(actual, expected, false);
		}
	}


