package com.links;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handle_Title {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement driverFooter = driver.findElement(By.id("gf-BIG"));
		
		System.out.println(driverFooter.findElements(By.tagName("a")).size());
		
		WebElement driverFooterColum = driver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]"));
		
		System.out.println(driverFooterColum.findElements(By.tagName("a")).size());
		
		for(int i = 1; i < driverFooterColum.findElements(By.tagName("a")).size(); i++) 
		{
			String clicks = Keys.chord(Keys.CONTROL, Keys.ENTER);
			
			driverFooterColum.findElements(By.tagName("a")).get(i).sendKeys(clicks);
			Thread.sleep(2000);
		}
		
		Set<String> ventanas = driver.getWindowHandles();
		Iterator<String> cambioVentanas =ventanas.iterator();
		
		while(cambioVentanas.hasNext())
		{
			driver.switchTo().window(cambioVentanas.next());
			System.out.println(driver.getTitle());
		}
	}
	
}
