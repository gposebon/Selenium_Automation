package com.handle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> id = windows.iterator();
		String parentId = id.next();
		String childrenId = id.next();
		
		driver.switchTo().window(childrenId);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
	}

}
