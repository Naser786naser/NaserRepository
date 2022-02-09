package locators;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CssLocators2 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {

		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String name = "rahul";

		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String passwordArray2 = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();;

		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[name='inputPassword']")).sendKeys(passwordArray2);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'You are successfully logged in.')]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'You are successfully logged in.')]")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.xpath("//h2")).getText(), "Hello " + name + ",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
		driver.quit();
	}
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		String passwordText = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
		String[] passwordArray = passwordText.split("'");
		String passwordArray2 = passwordArray[1];
		return passwordArray2;
	}
}
