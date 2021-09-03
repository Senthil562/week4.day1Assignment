package Week4.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());

		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Not a Friendly Topic", Keys.ENTER);

		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();

		driver.switchTo().defaultContent();

		driver.switchTo().frame("frame2");
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='animals']"));
		Select drop = new Select(dropdown);
		drop.selectByVisibleText("Cat");

	}

}
