package com.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testNGdemo {

	WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();

	}

	@Test

	public void Mytest() {

		System.out.println(driver.getTitle());

		driver.findElement(By.id("inputUsername")).sendKeys("rahulshettyacademy");

		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");

		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		System.out.println(driver.getCurrentUrl());

	}

	@AfterSuite
	public void afterSuite() {

		driver.close();
	}

}
