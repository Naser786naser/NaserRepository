package locators;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsJavaScriptHandling {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String text = "Naser Ahmad";

		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("input[id='name']")).sendKeys(text);
		driver.findElement(By.cssSelector("input[id='alertbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		driver.findElement(By.cssSelector("input[id='name']")).sendKeys(text);
		driver.findElement(By.cssSelector("input[id='confirmbtn']")).click();
	

		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		driver.quit();
		

	}

}
