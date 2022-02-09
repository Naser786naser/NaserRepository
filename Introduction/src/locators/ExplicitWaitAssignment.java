package locators;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ExplicitWaitAssignment {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver, 8);
		
	
		driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");
		driver.findElement(By.xpath("//a[text()='Click to load get data via Ajax!']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));
	
		System.out.println(driver.findElement(By.id("results")).getText());
		
	
		}

	}



