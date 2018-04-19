/**
 * 
 */
package by.htp.gmailtest.pages;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Артем
 *
 */
public class IncomingMessagesPage extends AbstractPage {

	public IncomingMessagesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public List<WebElement> getUnreadedLetters() {
		List<WebElement> unreadedLetters = driver
				.findElements(By.xpath("//*[@id=':34']/tbody//span[@class='zF' and @email='artemkaptur@mail.ru']"));
		return unreadedLetters;
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}
}
