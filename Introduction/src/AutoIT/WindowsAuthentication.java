package AutoIT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsAuthentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// This is the structure to follow   http:// Username: Password@SiteURL  
		driver.get("https://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[@href=\"/basic_auth\"]")).click();

	}

}
