package browserSetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchBrowserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String projectPath = System.getProperty("user.dir");
		/*
		 * System.out.println(projectPath);
		 * System.setProperty("webdriver.chrome.driver", projectPath +
		 * "\\drivers\\chromedriver.exe");
		 * WebDriver driver = new ChromeDriver();
		 */
		/*
		 * System.out.println(projectPath); System.setProperty("webdriver.gecko.driver",
		 * projectPath + "\\drivers\\geckodriver.exe");
		 * 
		 * WebDriver driver = new FirefoxDriver();
		 */
		
		/*
		 * System.out.println(projectPath); System.setProperty("webdriver.ie.driver",
		 * projectPath + "\\drivers\\IEDriverServer.exe");
		 * 
		 * WebDriver driver = new InternetExplorerDriver();
		 */
		
		System.out.println(projectPath);
		System.setProperty("webdriver.edge.driver", projectPath + "\\drivers\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/#/index");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//driver.close();

	}

}
