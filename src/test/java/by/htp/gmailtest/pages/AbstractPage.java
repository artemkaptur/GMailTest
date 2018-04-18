/**
 * 
 */
package by.htp.gmailtest.pages;

import org.openqa.selenium.WebDriver;

/**
 * @author Артем
 *
 */
public abstract class AbstractPage {
	protected WebDriver driver;

	public abstract void openPage();

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}
}
