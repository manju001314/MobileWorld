package mobileWorld;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SignIn {
	static {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Manjunatha.MS\\Downloads\\chromedriver_win32\\chromedriver.exe");
	}
	WebDriver driver;

	@Test(priority = 1)
	public void launchBrowser() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://mobileworld.azurewebsites.net/sign.html");
	}

	@Test(priority = 2)
	public void enterUserName() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("Manjunatha M S");
	}

	@Test(priority = 3)
	public void enterPassword() throws InterruptedException {
		driver.findElement(By.id("password")).sendKeys("1234");
	}

	@Test(priority = 4)
	public void clickOnLogin() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Log In']")).click();
		driver.quit();
	}

}
