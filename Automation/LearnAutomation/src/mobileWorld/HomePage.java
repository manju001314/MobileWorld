package mobileWorld;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage {
	static {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Manjunatha.MS\\Downloads\\chromedriver_win32\\chromedriver.exe");
	}
	WebDriver driver;

	@Test(priority = 1)
	public void launchBrowser() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://mobileworld.azurewebsites.net/");
	}

	@Test(priority = 2)
	public void verifyWelcome() throws InterruptedException {
		String welcomeNote = driver.findElement(By.xpath("//section[@id='home']/h1")).getText();
		Assert.assertTrue(welcomeNote.equalsIgnoreCase("Welcome To Our Mobile World!"));
	}

	@Test(priority = 3)
	public void verifyLatest() throws InterruptedException {
		String latest = driver.findElement(By.xpath("//div/ul/li[2]/a")).getText();
		Assert.assertTrue(latest.contains("Latest"));
	}

	@Test(priority = 4)
	public void clickOnVerify() throws InterruptedException {
		driver.findElement(By.xpath("//div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Samsung']")).click();
		String mobName = driver.findElement(By.xpath("//h4[text()='Samsung S21 FE ']")).getText();
		Assert.assertTrue(mobName.contains("SAMSUNG"));
	}

	@Test(priority = 5)
	public void clickOnMore() throws InterruptedException {
		driver.findElement(By.xpath("(//a[text()='More Details'])[1]")).click();
		String title = driver.findElement(By.xpath("//b[text()='All Mobile Details']")).getText();
		Assert.assertTrue(title.equalsIgnoreCase("All Mobile Details"));
		driver.navigate().back();
		Thread.sleep(2000);
	}

	@Test(priority = 6)
	public void clickOnSupport() throws InterruptedException {
		driver.findElement(By.xpath("//div/ul/li[4]/a")).click();
		String title = driver.findElement(By.xpath("//div/ul/li[4]/a")).getText();
		Assert.assertTrue(title.equalsIgnoreCase("Support"));
	}

	@Test(priority = 7)
	public void clickOnContact() throws InterruptedException {
		driver.findElement(By.xpath("(//a[text()='Contact Us'])[1]")).click();
		Thread.sleep(2000);
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		String titleOfPage = driver.getTitle();
		Assert.assertTrue(titleOfPage.equalsIgnoreCase("Contact"));
		driver.quit();
	}

}
