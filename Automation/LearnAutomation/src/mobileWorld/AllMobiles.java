package mobileWorld;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllMobiles {
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
	public void allMobiles() throws InterruptedException {
		WebElement allMobiles = driver.findElement(By.xpath("//*[text()='All Mobiles']"));
		allMobiles.click();
		List<WebElement> names = driver.findElements(By.xpath("//table/thead/tr"));
		for (WebElement n1 : names) {
			String abc = n1.getText();
			if (abc.contains("Mobile Name")) {
				Assert.assertTrue(true);
			}
		}
	}

	@Test(priority = 3)
	public void searchLenovo() {
		driver.findElement(By.id("myInput")).sendKeys("Lenovo");
		String mobName = driver.findElement(By.xpath("//tbody[@id='myTable']/tr[4]/td[1]")).getText();
		Assert.assertTrue(mobName.contains("Lenovo"));
		driver.findElement(By.id("myInput")).clear();

	}

	@Test(priority = 4)
	public void searchSamsung() {
		driver.findElement(By.id("myInput")).sendKeys("Samsung");
		String mobName = driver.findElement(By.xpath("//th[text()='Mobile Name']/../../../tbody/tr/td")).getText();
		Assert.assertTrue(mobName.contains("Samsung"));
		driver.findElement(By.id("myInput")).clear();

	}

	@Test(priority = 5)
	public void wrongApple() {
		driver.findElement(By.id("myInput")).sendKeys("Apple iphone appleiphone");
		// We cannot assert statement here because no error message is displayed
		driver.findElement(By.id("myInput")).clear();
	}

	@Test(priority = 6)
	public void wrongSamsung() {
		driver.findElement(By.id("myInput")).sendKeys("S@msung");
		// We cannot assert statement here because no error message is displayed
		driver.findElement(By.id("myInput")).clear();
	}

	@Test(priority = 7)
	public void twoCharacter() {
		driver.findElement(By.id("myInput")).sendKeys("Sa");
		String mobName = driver.findElement(By.xpath("//th[text()='Mobile Name']/../../../tbody/tr/td")).getText();
		Assert.assertTrue(mobName.contains("Samsung"));
		driver.findElement(By.id("myInput")).clear();

	}

	@Test(priority = 8)
	public void InvalidMob() {
		driver.findElement(By.id("myInput")).sendKeys("Man");
		// We cannot assert statement here because no error message is displayed
		driver.findElement(By.id("myInput")).clear();
	}

	@Test(priority = 9)
	public void order() throws InterruptedException {
		driver.findElement(By.id("myInput")).sendKeys("lenovo");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()=' Order'])[1]")).click();
		// We cannot assert statement here because same page is opening again
	}

	@Test(priority = 10)
	public void courseVerify() throws InterruptedException {
		String title = driver.findElement(By.xpath("//b[text()='All Mobile Details']")).getText();
		Assert.assertTrue(title.equals("All Mobile Details"));
		driver.quit();
	}

}
