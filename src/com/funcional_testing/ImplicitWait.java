package com.funcional_testing;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String[] comprar = { "Cucumber", "Brocolli", "Tomato", "Carrot" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		
		addItems(driver, comprar);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		

		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}

	public static void addItems(WebDriver driver, String[] comprar) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();

			List<String> listaCompra = Arrays.asList(comprar);

			if (listaCompra.contains(formattedName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			}
		}
	}

}
