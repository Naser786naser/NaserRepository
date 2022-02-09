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

public class WindowHandleAssignment {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.cssSelector("a[href*='windows']")).click();
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		System.out.println(driver.findElement(By.cssSelector("h3")).getText());
		driver.switchTo().window(parent);
		System.out.println(driver.findElement(By.xpath("//h3")).getText());
		
		/*
		 * String email =
		 * driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].
		 * trim().split(" ")[0] .trim(); driver.switchTo().window(parent);
		 * driver.findElement(By.id("username")).sendKeys(email);
		 */
		/*
		 * driver.get("https://the-internet.herokuapp.com/");
		 * driver.findElement(By.linkText("Multiple Windows")).click(); Set<String>
		 * window = driver.getWindowHandles(); Iterator<String> it = window.iterator();
		 * String parent = it.next(); String child = it.next(); String child2 =
		 * it.next(); driver.switchTo().window(child);
		 * System.out.println(driver.findElement(By.cssSelector("h3")).getText());
		 */
		/*
		 * driver.findElement(By.linkText("Click Here")).click(); Set<String>window2
		 * =driver.getWindowHandles(); Iterator<String> it2= window2.iterator();
		 * driver.switchTo().window(child2);
		 */

	}

}
