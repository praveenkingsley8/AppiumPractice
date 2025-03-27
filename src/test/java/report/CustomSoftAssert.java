package report;

import org.testng.Reporter;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

public class CustomSoftAssert extends SoftAssert {

	// Override assertTrue to add custom logging behavior
	@Override
	public void assertTrue(final boolean condition, final String message) {
		if (condition) {
			ReportLogger.pass(message);
		} else {
			ReportLogger.fail(message);
		}
	}

	// Simplified assertTrue to just pass message if condition is true
	public void assertTrue(final String message) {
		ReportLogger.pass(message);
	}

	// Custom assertFalse using the assertTrue logic
	@Override
	public void assertFalse(final boolean condition, final String message) {
		assertTrue(!condition, message);
	}

	// Simplified assertFalse to pass the message if condition is false
	public void assertFalse(final String message) {
		assertTrue(false, message);
	}

	// Custom info logging (useful for additional context or logs during tests)
	public void assertInfo(boolean condition, final String message) {
		if (condition) {
			ReportLogger.info(message);  // Assuming info is another logging type
		} else {
			ReportLogger.fail(message);
		}
	}

	// Overloaded method for info logs
	public void assertInfo(final String message) {
		ReportLogger.info(message);
	}

	// Custom assertEquals for boolean values
	@Override
	public void assertEquals(final boolean actual, final boolean expected, final String message) {
		if (actual == expected) {
			ReportLogger.pass(message);
		} else {
			ReportLogger.fail(message);
		}
	}

	// Custom assertEquals for string values
	@Override
	public void assertEquals(final String actual, final String expected, final String message) {
		if (actual.equals(expected)) {
			ReportLogger.pass(message);
		} else {
			ReportLogger.fail(message);
		}
	}

	// Logging after an assertion is made
	@SuppressWarnings("rawtypes")
	@Override
	public void onAfterAssert(IAssert a) {
		Reporter.log("Expected: " + a.getExpected());
		Reporter.log("Actual: " + a.getActual());
		Reporter.log("");
		super.onAfterAssert(a);
	}

	// Logging before an assertion is made
	@SuppressWarnings("rawtypes")
	@Override
	public void onBeforeAssert(IAssert a) {
		Reporter.log("Test Case Description: " + a.getMessage());
	}

	// Custom handling for assertion failure
	@SuppressWarnings("rawtypes")
	@Override
	public void onAssertFailure(IAssert a, AssertionError ex) {
		Reporter.log("TEST Case Failed ->" + ex.getMessage());
		// super.onAssertFailure(a, ex); // Uncomment if you need to invoke parent method
	}
}
