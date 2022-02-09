package AutoIT;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// This is the structure to follow   http:// Username: Password@SiteURL  
		driver.get("https://airconvertpdftojpg.com/");
		driver.findElement(By.id("dropzoneInput-label")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Naser\\SeleniumPaidTrainingAttempt2\\E2EProject\\uploadFile\\fileUpload.exe");
		
		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver, 15);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*= 'g-btn--medium']")));
		driver.findElement(By.cssSelector("button[class*= 'g-btn--medium']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class*= 'g-btn-auto-width']")));
		driver.findElement(By.cssSelector("a[class*= 'g-btn-auto-width']")).click();
		Thread.sleep(4000);
		File f = new File("C:\\Users\\Nas\\Downloads\\Result.zip");
		
		if (f.exists())
				{
			System.out.println("The file exists");
			if(f.delete())
			{
				System.out.println("File deleted");
			}
			
				}
		else {
			System.out.println("File was not found");
		}
	}

}
