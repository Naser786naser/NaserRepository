package locators;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssLocators {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://sso.teachable.com/secure/9521/identity/login");

		driver.findElement(By.cssSelector("input#email")).sendKeys("Naser");
		driver.findElement(By.cssSelector("input#password")).sendKeys("Ahmad");
		driver.findElement(By.cssSelector("input.btn-primary.button.p-v-2-xs.p-h-5-xs.m-v-3-xs.col-12-xs")).click();
		System.out.println(
				driver.findElement(By.cssSelector("div.bodySmall.m-b-3-xs.text-center-xs.auth-flash-error")).getText());
		//driver.findElement(By.xpath("//div[contains(@class,'odySmall')"].
		driver.findElement(By.linkText("Forgot Password")).click();
		driver.findElement(By.linkText("Forgot Password")).click();
		
		int tag = driver.findElements(By.tagName("div")).size();
		System.out.println(tag);

	}

}
