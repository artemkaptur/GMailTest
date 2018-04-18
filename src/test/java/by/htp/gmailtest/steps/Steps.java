/**
 * 
 */
package by.htp.gmailtest.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.htp.gmailtest.driver.DriverSingleton;
import by.htp.gmailtest.pages.IncomingMessagesPage;
import by.htp.gmailtest.pages.LoginPage;
import by.htp.gmailtest.pages.MainPage;

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

	public void chooseLastUnreadedLetter() {
		IncomingMessagesPage messagePage = new IncomingMessagesPage(driver);
		messagePage.chooseLastUnreadedLetter();
	}
	
	public void chooseSendedLetters() throws InterruptedException {
		IncomingMessagesPage messagePage = new IncomingMessagesPage(driver);
		messagePage.chooseSendedLetters();
	}

}
