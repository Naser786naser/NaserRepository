package locators;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AvoidHardcodingAssignment {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String text = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
		System.out.println(text);
		WebElement element =driver.findElement(By.id("dropdown-class-example"));
		
		Select dropDown = new Select(element);
		dropDown.selectByVisibleText(text);
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		
		String s= driver.switchTo().alert().getText();
		System.out.println(s);
		if (s.contains(text)) {
			System.out.println("Option2 exists on the alert");
		}
	
	}
}
