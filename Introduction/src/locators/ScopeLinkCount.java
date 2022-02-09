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

public class ScopeLinkCount {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		int tagNames = driver.findElements(By.tagName("a")).size();
		System.out.println(tagNames);
		// Limiting the webdriver scope
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		// h //tbody/tr/td[1]/ul[1]
		WebElement footerSubFerDriver = driver.findElement(By.xpath(" //tbody/tr/td[1]/ul[1]"));
		System.out.println(footerSubFerDriver.findElements(By.tagName("a")).size());

		// To go through each link and click to ensure the link is not broken
		/*
		 * for(int i=1; i<footerSubFerDriver.findElements(By.tagName("a")).size(); i++)
		 * { footerSubFerDriver.findElements(By.tagName("a")).get(i).click();
		 * driver.navigate().back(); }
		 */

		// opening pages in separate tabs
		for (int i = 1; i < footerSubFerDriver.findElements(By.tagName("a")).size(); i++)

		{
			String tabToOpen = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footerSubFerDriver.findElements(By.tagName("a")).get(i).sendKeys(tabToOpen);
		}
			Set<String> title = driver.getWindowHandles();
			Iterator<String> it = title.iterator();
			
			while(it.hasNext())
			{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}

	}
}
