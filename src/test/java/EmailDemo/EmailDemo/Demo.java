package EmailDemo.EmailDemo;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static WebDriver driver;
	
	@AfterClass
	public void m1()
	{
		System.out.println("This methos is m1");
	}
	
	@Test
	public void login()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("Akashreddy123@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "My Account";
		
		if(actualTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
		
		
	}
	
	@AfterTest
	public void m2()
	{
		driver.close();
	}
}
