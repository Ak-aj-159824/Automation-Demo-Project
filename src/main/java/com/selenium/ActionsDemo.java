package com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		driver.get("https://demoqa.com/interaction");
		driver.findElement(By.xpath("//*[text()=\"Elements\"]")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");

		driver.findElement(By.xpath("//*[text()=\"Buttons\"]")).click();

		Actions a = new Actions(driver);

		WebElement doubleclick = driver.findElement(By.id("doubleClickBtn"));

		js.executeScript("window.scrollBy(0, 500)");
		a.doubleClick(doubleclick).build().perform();

		js.executeScript("window.scrollBy(0, 500)");
		String clickedtwice = driver.findElement(By.xpath("//p[@id=\"doubleClickMessage\"]")).getText();
		System.out.println(clickedtwice);
		js.executeScript("window.scrollBy(0, 500)");
		a.contextClick(driver.findElement(By.xpath("//button[@id=\"rightClickBtn\"]"))).build().perform();
		System.out.println(driver.findElement(By.xpath("//p[@id=\"rightClickMessage\"]")).getText());
		js.executeScript("window.scrollBy(0, 500)");

		driver.findElement(By.id("id=\"pFNrq\"")).click();

		js.executeScript("window.scrollBy(0, 500)");

		System.out.println(driver.findElement(By.xpath("//p[@id=\"dynamicClickMessage\"]")).getText());

		driver.close();

	}

}
