package locators;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StaticDropdowns {

	public static void main(String[] args) throws InterruptedException {

		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select staticDropDown = new Select(dropdown);
		staticDropDown.selectByIndex(3);
		System.out.println(staticDropDown.getFirstSelectedOption().getText());

		staticDropDown.selectByVisibleText("AED");
		System.out.println(staticDropDown.getFirstSelectedOption().getText());
		staticDropDown.selectByValue("INR");
		System.out.println(staticDropDown.getFirstSelectedOption().getText());

		/**
		 * @param args
		 * @another way to handle dropdown
		 */

		driver.findElement(By.id("divpaxinfo")).click();
		for (int i = 0; i < 4; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("btnclosepaxoption")).click();

		// How to deal with dynamic dropdowns

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.linkText("Bengaluru (BLR)")).click();
		driver.findElement(By.xpath("(//a[@text= 'Chennai (MAA)'])[2]")).click();
		//Suggestive dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> elements =driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a"));
		for(WebElement element:elements)
		{
			System.out.println(element.getText());
			if (element.getText().equalsIgnoreCase("india")) {
				element.click();
				break;
				
			}
			}
		//driver.quit();
		}
		
	}

