package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class End2EndJourney {

	public static void main(String[] args) throws InterruptedException {
		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.linkText("Delhi (DEL)")).click();
		driver.findElement(By.xpath("(//a[@text= 'Chennai (MAA)'])[2]")).click();

		// calendar selection
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

		// select the checkbox
		System.out.println(driver.findElement(By.cssSelector("input[id*= 'SeniorCitizenDiscount']")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*= 'SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*= 'SeniorCitizenDiscount']")).click();
		// System.out.println(driver.findElement(By.cssSelector("input[id*=
		// 'SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*= 'SeniorCitizenDiscount']")).isSelected());
		// System.out.println(driver.findElements(By.cssSelector("input[type=
		// 'checkbox']")).size());

		driver.findElement(By.cssSelector("input[id*= 'SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*= 'SeniorCitizenDiscount']")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*= 'SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*= 'SeniorCitizenDiscount']")).click();
		// System.out.println(driver.findElement(By.cssSelector("input[id*=
		// 'SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*= 'SeniorCitizenDiscount']")).isSelected());
		// System.out.println(driver.findElements(By.cssSelector("input[type=
		// 'checkbox']")).size());

		// select number of passengers
		driver.findElement(By.id("divpaxinfo")).click();
		for (int i = 0; i < 4; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("btnclosepaxoption")).click();

		WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select staticDropDown = new Select(dropdown);
		staticDropDown.selectByIndex(3);
		System.out.println(staticDropDown.getFirstSelectedOption().getText());

		staticDropDown.selectByVisibleText("AED");
		System.out.println(staticDropDown.getFirstSelectedOption().getText());
		staticDropDown.selectByValue("INR");
		System.out.println(staticDropDown.getFirstSelectedOption().getText());

		driver.findElement(By.cssSelector("input[type='submit']")).click();

		driver.quit();
	}

}
