package com.selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");

		driver.findElement(By.xpath("//a[text()=\"Multiple Windows\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Click Here\"]")).click();

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();

		driver.switchTo().window(child);

		System.out.println(driver.findElement(By.xpath("//h3[text()=\"New Window\"]")).getText());

		driver.switchTo().window(parent);

		System.out.println(driver.findElement(By.xpath("//h3[text()=\"Opening a new window\"]")).getText());

	}

}
