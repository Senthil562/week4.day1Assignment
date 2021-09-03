package Week4.Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		 String title = driver.getTitle();
		 System.out.println(title);
		 
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		 
		 driver.findElement(By.id("password")).sendKeys("crmsfa");
		 driver.findElement(By.className("decorativeSubmit")).click();
		 
		 driver.findElement(By.linkText("CRM/SFA")).click();
		 
		 driver.findElement(By.linkText("Contacts")).click();
		 driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		 //driver.findElement(By.xpath("//input[@id='ComboBox_partyIdFrom']")).click();
		 driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		 
		 Set<String> windowHandles = driver.getWindowHandles();
			
			List<String> windowList = new ArrayList<String> (windowHandles);
			driver.switchTo().window(windowList.get(1));
			
			System.out.println(driver.getTitle());
			
			String firstResult = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
			Thread.sleep(2000);
			System.out.println("First Resulting Contact : " + firstResult);
			
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
			driver.switchTo().window(windowList.get(0));
			//driver.get("http://leaftaps.com/crmsfa/control/mergeContactsForm");
			driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
            Set<String> windowHandles1 = driver.getWindowHandles();
			
			List<String> windowList1 = new ArrayList<String> (windowHandles1);
			driver.switchTo().window(windowList1.get(1));

		
			String secondResult = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).getText();
			Thread.sleep(2000);
			System.out.println("Second Resulting Contact : " + secondResult);
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
			driver.switchTo().window(windowList1.get(0));
			//driver.get("http://leaftaps.com/crmsfa/control/mergeContactsForm");
			driver.findElement(By.xpath("//a[text()='Merge']")).click();
			Alert alert = driver.switchTo().alert();
			Thread.sleep(2000);
			alert.accept();
			String title2 = driver.getTitle();
			System.out.println("Title of page : " + title2);
			if(title2.equals("View Contact | opentaps CRM"))
				System.out.println("Title of page is verified");
			else
				System.out.println("Title of page is not verified");
			
	}

}