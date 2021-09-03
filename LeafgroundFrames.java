package Week4.Day1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundFrames {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@src='default.html']"));
		driver.switchTo().frame(frame1);
		
		WebElement clickMe = driver.findElement(By.xpath("//button[@id='Click']"));
		File source = clickMe.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/Click.png");
		FileUtils.copyFile(source, dest);
		
		driver.switchTo().defaultContent();
		
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@src='page.html']"));
		driver.switchTo().frame(frame2);
		
		WebElement frame3 = driver.findElement(By.xpath("//iframe[@src='nested.html']"));
		driver.switchTo().frame(frame3);
		
		driver.findElement(By.xpath("//button[@id='Click1']")).click();
		
		driver.switchTo().defaultContent();
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of Frames : " + frames.size());
	}

}