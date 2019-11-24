package tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import reusableObjects.EaAppHomePge;
import reusableObjects.EaAppLoginPage;



public class LoginApplicationTest {

	WebDriver driver;

	@BeforeTest()
	public void SetupEnvt() throws Throwable {
		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream("C:\\Users\\nebiy\\OneDrive\\Desktop\\Master-WorkSpace\\POM\\src\\dataDriven.properties");
		prop.load(fis);

		System.setProperty("webdriver.chrome.driver","C:\\Users\\nebiy\\OneDrive\\Desktop\\ChromeDrive\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\nebiy\\OneDrive\\Desktop\\Firefox Driver\\geckodriver.exe");

		if(prop.getProperty("browser").contains("chrome")) {
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").contains("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@DataProvider
	public Object[][] GetData() {
		
		Object[][] data = new Object[3][2];

		//1st set
		data[0][0] = "good";
		data[0][1] = "password";

		//2nd set
		data[1][0] = "bad";
		data[1][1] = "password2";

		//3rd set
		data[2][0] = "Excellent";
		data[2][1] = "password3";

		return data;
	}

	@Test
	public void GoToLoginPage() {
		EaAppHomePge ea = new EaAppHomePge(driver);
		ea.LoginElement().click();
	}

	@Test(dataProvider="GetData")
	public void InvalidLoginToApplication(String un,String pwd) {
		EaAppLoginPage el = new EaAppLoginPage(driver);
		el.UserName().sendKeys(un);
		el.PassWord().sendKeys(pwd);
		el.RememberMe().click();
		el.LoginClick().click();
		String attempt = el.InvalidAttempt().getText();
		Assert.assertEquals(attempt, "Invalid login attempt.");
		el.UserName().clear();
		el.UserName().clear();
	}
	
	@Test(timeOut=2000)
	public void ValidLogin() {
		EaAppLoginPage el = new EaAppLoginPage(driver);
		el.UserName().sendKeys("mytester");
		el.PassWord().sendKeys("Asdf1234@1234");
		el.RememberMe().click();
		el.LoginClick().click();
		String validationAbout = el.ValidateAbout().getText();
		Assert.assertEquals(validationAbout, "About");
		//String attempt = el.InvalidAttempt().getText();
		//Assert.assertEquals(attempt, "Invalid login attempt.");
		
	}

	@AfterTest
	public void CleanUp() {
		//driver.close();
	}

}
