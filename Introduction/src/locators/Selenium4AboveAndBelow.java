package locators;

import java.time.Duration;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Selenium4AboveAndBelow {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditBox = driver.findElement(By.xpath("//input[@name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		// 
		WebElement dob = driver.findElement(By.xpath("//label[contains(text(),'Date of Birth')]"));
		//driver.findElement(with(By.tagName("label")).below(dob)).sendKeys("Hello")
		driver.findElement(with(By.tagName("input")).below(dob)).click();
		
		WebElement iceCreateLabel = driver.findElement(By.xpath("//label[contains(text(),'Check me out if you Love IceCreams!')]"));
		driver.findElement(with (By.tagName("input")).toLeftOf(iceCreateLabel)).click();
		
		WebElement stu = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
		System.out.println(driver.findElement(with (By.tagName("label")).toRightOf(stu)).getText());
		
	}

}
