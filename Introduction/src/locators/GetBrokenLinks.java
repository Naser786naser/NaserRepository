package locators;

import java.io.IOException;

import java.net.HttpURLConnection;

import java.net.MalformedURLException;

import java.net.URL;

import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import org.testng.asserts.SoftAssert;

public class GetBrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {

		String projectPath = System.getProperty("user.dir");

		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		// broken URL

		// Step 1 - IS to get all urls tied up to the links using Selenium

		// Java methods will call URL's and gets you the status code

		// if status code >400 then that url is not working-> link which tied to url is
		// broken

		// a[href*="soapui"]'

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

		SoftAssert a = new SoftAssert();

		for (WebElement link : links)

		{

			String url = link.getAttribute("href");

			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

			conn.setRequestMethod("HEAD");

			conn.connect();

			int respCode = conn.getResponseCode();

			System.out.println(respCode);

			a.assertTrue(respCode < 400, "The link with Text" + link.getText() + " is broken with code" + respCode);

		}

		 a.assertAll();

	}
}



		/*
		 * String homePage = "https://rahulshettyacademy.com/AutomationPractice/";
		 * String url = ""; HttpURLConnection huc = null; int respCode = 200;
		 * 
		 * driver = new ChromeDriver();
		 * 
		 * driver.manage().window().maximize();
		 * 
		 * driver.get(homePage);
		 * 
		 * List<WebElement> links = driver.findElements(By.tagName("a"));
		 * 
		 * Iterator<WebElement> it = links.iterator();
		 * 
		 * while(it.hasNext()){
		 * 
		 * url = it.next().getAttribute("href");
		 * 
		 * System.out.println(url);
		 * 
		 * if(url == null || url.isEmpty()){ System.out.
		 * println("URL is either not configured for anchor tag or it is empty");
		 * continue; }
		 * 
		 * if(!url.startsWith(homePage)){
		 * System.out.println("URL belongs to another domain, skipping it."); continue;
		 * }
		 * 
		 * try { huc = (HttpURLConnection)(new URL(url).openConnection());
		 * 
		 * huc.setRequestMethod("HEAD");
		 * 
		 * huc.connect();
		 * 
		 * respCode = huc.getResponseCode();
		 * 
		 * if(respCode >= 400){ System.out.println(url+" is a broken link"); } else{
		 * System.out.println(url+" is a valid link"); }
		 * 
		 * } catch (MalformedURLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } }
		 * 
		 * driver.quit();
		 * }
		 * }
		 */

	

