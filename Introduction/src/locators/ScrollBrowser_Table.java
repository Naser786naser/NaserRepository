package locators;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ScrollBrowser_Table {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		int totalNumbers = 0;
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		for(int i  =0; i<values.size();i++)
		{
			//use Integer.parseInt to convert a String to integer
			int total = Integer.parseInt(values.get(i).getText());
			totalNumbers = totalNumbers + total;
					
		}
		System.out.println(totalNumbers);
		
		int sum = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(totalNumbers, sum);
		
		
		
		
		//Table 2
		int sum2=0;
		List<WebElement> values2 = driver.findElements(By.cssSelector("table[name='courses']  td:nth-child(3)"));
		
		for (int x=0; x<values2.size();x++)
		{
			int tot = Integer.parseInt(values2.get(x).getText());
			sum2= sum2+ tot;
		}
		System.out.println(sum2);
		}
	

	
	}

