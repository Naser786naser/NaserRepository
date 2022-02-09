package locators;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://www.amazon.co.uk/");
		driver.findElement(By.cssSelector("#nav-link-accountList"));
		WebElement move = driver.findElement(By.id("twotabsearchtextbox"));
		Actions a = new Actions(driver);
		//moving cursor to an element
		a.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList"))).build().perform();
		
		//right click on an element
		a.contextClick(driver.findElement(By.cssSelector("#nav-link-accountList"))).build().perform();
		
		//typing in capital by holding the shift key down and then double clicking on the text to select.
		a.moveToElement(move).click().keyDown(Keys.SHIFT).sendKeys("Hello").doubleClick().build().perform();
		

	}

}
