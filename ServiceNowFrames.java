package Week4.Day1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowFrames {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://dev113545.service-now.com/");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("gsft_main");

		driver.findElement(By.xpath("//div[@class='login']//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//div[@class='login']//input[@id='user_password']")).sendKeys("w6hnF2FRhwLC");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();

		driver.findElement(By.xpath("(//div[text()='Create New'])[1]")).click();
		driver.switchTo().frame("gsft_main");
		String incidentNo = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Incident Number : " + incidentNo);

		WebElement caller = driver.findElement(By.xpath("//input[@id='sys_display.incident.caller_id']"));
		caller.sendKeys("guest", Keys.ENTER);

		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("TestCase");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNo, Keys.ENTER);
		Thread.sleep(2000);
		String incidentNo1 = driver.findElement(By.xpath("(//td[@class='vt'])[1]/a")).getText();
		System.out.println("Incident Number : " + incidentNo1);

		if (incidentNo.equals(incidentNo1))
			System.out.println("Incident is created successfully");
		else
			System.out.println("Incident is not Created");

		File screen = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/Incident.png");
		FileUtils.copyFile(screen, dest);

	}

}