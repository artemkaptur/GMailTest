/**
 * 
 */
package by.htp.gmailtest.pages;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Артем
 *
 */
public class WriteLetterPage extends AbstractPage {
	@FindBy(xpath = "//*[@id=':c1']/table/tbody/tr/td[2]/div/div")
	private WebElement writtingLeterField;

	@FindBy(name = ":fz")
	private WebElement sendLetter;

	@FindBy(xpath = "/html/body/div[7]/div[3]/div[1]/div[1]/div[5]/div[1]/div/div[3]/div/div/div[2]")
	private WebElement sendingProof;

	public WriteLetterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public String sendAnswer() {
		writtingLeterField.click();
		writtingLeterField.sendKeys("Hi, buddy, how about going to the cinema this weekend?!");
		sendLetter.click();
		return sendingProof.getText();
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}
}
