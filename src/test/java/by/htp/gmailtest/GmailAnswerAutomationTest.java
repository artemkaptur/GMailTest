/**
 * 
 */
package by.htp.gmailtest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.gmailtest.steps.Steps;

/**
 * @author Артем
 *
 */
public class GmailAnswerAutomationTest {
	private Steps steps;
	private final String LOGIN = "testacc@gmail.com";
	private final String PASSWORD = "pa$$w0rd";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(description = "Answer on last unreaded letter")
	public void gmailAnswerTest() {
		steps.login(LOGIN, PASSWORD);
		steps.answerIfLetterIs(LOGIN);
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
