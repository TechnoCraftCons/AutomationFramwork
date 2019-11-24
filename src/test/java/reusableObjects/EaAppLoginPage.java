package reusableObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EaAppLoginPage {

	WebDriver driver;

	public EaAppLoginPage(WebDriver driver) {

		this.driver = driver;
	}

	By userName = By.xpath("//input[@id='UserName']");
	By passWord = By.xpath("//input[@id='Password']");
	By rememberMe = By.xpath("//input[@id='RememberMe']");
	By loginBtn = By.xpath("//input[@class='btn btn-default']");
	By invalidAttempt = By.xpath("//li[contains(text(),'Invalid login attempt.')]");
	By validateAbout = By.xpath("//h2[contains(text(),'About')]");

	public WebElement UserName() {
		return driver.findElement(userName);
	}

	public WebElement PassWord() {
		return driver.findElement(passWord);
	}

	public WebElement RememberMe() {
		return driver.findElement(rememberMe);
	}

	public WebElement LoginClick() {
		return driver.findElement(loginBtn);
	}

	public WebElement InvalidAttempt() {
		return driver.findElement(invalidAttempt);
	}
	
	public WebElement ValidateAbout() {
		return driver.findElement(validateAbout);
	}

}
