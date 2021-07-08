package infra;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {

	public static WebDriver driver;

	/**
	 * This function implements a design pattern called Singleton - A single
	 * class performance
	 */

	public static WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
			
			switch (new LoadProperties().getDriver()) {
			case "chromedriver":
				driver = new ChromeDriver();
				break;
			case "internetexplorer":
				driver = new InternetExplorerDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				throw new AutomationException("No browser found as defined in the file, check spelling errors");
			}
		}
		return driver;
	}

	public static void goToSite(String addres) {
		driver.manage().window().maximize();
		driver.get(addres);
	}

}
