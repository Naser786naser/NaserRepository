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

public class CalendarHandling2 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.id("travel_date")).click();
		//List<WebElement> dates = driver.findElements(By.cssSelector("td.new.day"));
		int count = driver.findElements(By.cssSelector("td.new.day")).size();
		for(int i=0; i<count;i++)
		{
		String text = 	driver.findElements(By.cssSelector("td.new.day")).get(i).getText();
		
		if(text.equalsIgnoreCase("8"))
		{
			driver.findElements(By.cssSelector("td.new.day")).get(i).click();
			break;
		}
		}

	
	}
}
