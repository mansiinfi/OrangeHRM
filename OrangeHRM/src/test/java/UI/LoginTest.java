package UI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;

	@BeforeMethod
	public void SetUp() {

		System.setProperty("webdriver.chrome.driver", "/home/mansi/Downloads/Driver/chromedriver_linux64/chromedriver");
		 driver = new ChromeDriver();
		//WebDriverManager.chromedriver().setup();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com");

	}

	@Test

	public void Logintest() throws Exception {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.className("button")).click();
		System.out.println(driver.findElement(By.tagName("img")).getSize());
		String s = driver.getTitle();
		String c = "OrangeHRM";
		if (s.equalsIgnoreCase(c)) {
			System.out.println("Test Successful");
		} else
			System.out.println("Test Failed");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
