/**
 * 
 */
package by.htp.gmailtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Артем
 *
 */
public class IncomingMessagesPage extends AbstractPage {

	// *[@id=':23']//*[@email='artemkaptur@mail.ru' and @class='zF']
	@FindBy(xpath = "//*[@id=':2v']/tbody//*[@email='artemkaptur@mail.ru' and @class='zF']")
	private WebElement lastUnreadedLetter;	
	
	@FindBy(xpath = "//*[@id=':8j']/div/div[2]/span/a")
	private WebElement sendedLetters;

	public IncomingMessagesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void chooseLastUnreadedLetter() {
		lastUnreadedLetter.click();
	}
	
	public void chooseSendedLetters() throws InterruptedException {
		Thread.sleep(5000);
		sendedLetters.click();
	}

	@Override
	public void openPage() {

	}
}
