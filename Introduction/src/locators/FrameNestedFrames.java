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

public class FrameNestedFrames {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
	

		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Nested Frames")).click();
		driver.switchTo().frame(driver.findElement(By.name("frame-top")));
		driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
		System.out.println(driver.findElement(By.id("content")).getText());
		/*
		 * // how to find using web element
		 * //driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		 * 
		 * //how to find using frame index
		 * System.out.println(driver.findElements(By.tagName("iframe")).size());
		 * driver.switchTo().frame(0); driver.findElement(By.id("draggable")).click();
		 * Actions a = new Actions(driver);
		 * a.dragAndDrop(driver.findElement(By.id("draggable")),
		 * driver.findElement(By.cssSelector("div[id='droppable']"))).build().perform();
		 * //to switch back to html driver.switchTo().defaultContent();
		 * driver.findElement(By.xpath("//a[text()='Accept']")).click();
		 */
		

		

	}

}
