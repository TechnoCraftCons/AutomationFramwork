package reusableObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EaAppHomePge {

	WebDriver driver;

	public  EaAppHomePge(WebDriver driver) {
		this.driver = driver;
	}

	By Login =	By.xpath("//a[@id='loginLink']");

	public WebElement LoginElement() {

		return driver.findElement(Login);

	}



}
