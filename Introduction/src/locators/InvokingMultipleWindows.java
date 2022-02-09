package locators;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import java.time.Duration;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class InvokingMultipleWindows {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {

		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it =handles.iterator();
		String parent = it.next();
		String child = it.next();
		
		driver.switchTo().window(child);
		driver.get("https://courses.rahulshettyacademy.com/courses");
		String text = driver.findElement(By.xpath("//div[contains(text(),'All-Access Membership')]")).getText();
		driver.switchTo().window(parent);
		
		WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
		name.sendKeys(text);
		File file = name.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File ("C:\\Naser\\SeleniumPaidTraining\\Screenshots\\Screenshot.png"));

	}

}
