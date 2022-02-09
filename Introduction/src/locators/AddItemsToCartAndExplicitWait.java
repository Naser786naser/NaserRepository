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

public class AddItemsToCartAndExplicitWait {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver, 5);
		
		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		//launchBrowser(driver);
		AddItemsToCartAndExplicitWait add = new AddItemsToCartAndExplicitWait();
		AddItemsToCartAndExplicitWait.launchBrowser(driver, w);
			
		}
	public static void launchBrowser(WebDriver driver, WebDriverWait w)
	{
	
	List<WebElement> names = driver.findElements(By.cssSelector("h4.product-name"));
	
	for(int i=0;i<names.size();i++)
	{
		String product = names.get(i).getText();
		if(product.contains("Cucumber"))
		{
		driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
			break;
		}
	}
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()= 'PROCEED TO CHECKOUT']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class= 'promoBtn']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText(), "Code applied ..!");
		//driver.quit();
		

	}
	}



