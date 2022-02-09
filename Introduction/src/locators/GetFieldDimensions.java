package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetFieldDimensions {

	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		
		System.out.println(driver.findElement(By.xpath("//input[@name='name']")).getSize().getHeight());

	}

}
