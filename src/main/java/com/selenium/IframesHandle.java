package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IframesHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");

		driver.findElement(By.linkText("Nested Frames")).click();
		System.out.println(driver.findElements(By.tagName("frame")).size());

		WebElement frame1 = driver.findElement(By.name("frame-top"));

		driver.switchTo().frame(frame1);
		WebElement midframe = driver.findElement(By.xpath("//frame[@name=\"frame-middle\"]"));
		driver.switchTo().frame(midframe);

		System.out.println(driver.findElement(By.id("content")).getText());

		driver.close();
	}

}
