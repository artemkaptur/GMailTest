/**
 * 
 */
package by.htp.gmailtest.steps;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import by.htp.gmailtest.driver.DriverSingleton;
import by.htp.gmailtest.pages.IncomingMessagesPage;
import by.htp.gmailtest.pages.LoginPage;
import by.htp.gmailtest.pages.MainPage;
import by.htp.gmailtest.pages.WriteLetterPage;

/**
 * @author Артем
 *
 */
public class Steps {
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void login(String log, String passw) {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.clickOnLoginButton();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.fillLoginPassw(log, passw);
		logger.info("Login performed");
	}

	public String answerIfLetterIs(String login) {
		List<WebElement> unreadedLetters = getUnreadedLetters();
		if (unreadedLetters.size() > 0) {
			if (writeAnswer(unreadedLetters).equals("Письмо отправлено."))
				return "positive";
			else
				return "negative";
		} else {
			System.out.println("Sorry, but you haven't recived any letters from " + login);
			return "positive";
		}
	}

	private List<WebElement> getUnreadedLetters() {
		IncomingMessagesPage messagesPage = new IncomingMessagesPage(driver);
		return messagesPage.getUnreadedLetters();
	}

	private String writeAnswer(List<WebElement> unreadedLetters) {
		unreadedLetters.get(0).click();
		WriteLetterPage writeLetterPage = new WriteLetterPage(driver);
		return writeLetterPage.sendAnswer();
	}

}
