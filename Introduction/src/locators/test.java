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

public class test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {

		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver, 5);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		test t = new test();
		t.getPage(driver, w);
	
		
	
	}
		
		public void getPage(WebDriver driver, WebDriverWait w)
		{
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		
	
	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div/button[1]/following-sibling::button[1]/parent::div/parent::header/div/button[1]")));
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]/parent::div/parent::header/div/button[1]")).getText());
		
		driver.close();
		
}
}

