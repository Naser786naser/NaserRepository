package locators;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.apache.commons.io.FileUtils;

public class Screenshot {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {

		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Convert web driver object to TakeScreenshot

		
		  TakesScreenshot scrShot = ((TakesScreenshot) driver);
		  
		  // Call getScreenshotAs method to create image file
		  
		  File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		  
		  // Move image file to new destination
		  
		  File DestFile = new File("C:\\Naser\\SeleniumPaidTraining\\Screenshots\\Screenshot.png");
		  
		  // Copy file at destination
		  
		  FileUtils.copyFile(SrcFile, DestFile);
		 
		
		/*
		 * File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 * FileUtils.copyFile(src,new
		 * File("C:\\Naser\\SeleniumPaidTraining\\Screenshots\\Screenshot.png"));
		 */

	}

}
