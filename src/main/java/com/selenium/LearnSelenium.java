package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();

		System.out.println(driver.getTitle());

		driver.findElement(By.id("inputUsername")).sendKeys("rahulshettyacademy");

		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");

		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		System.out.println(driver.getCurrentUrl());

		driver.close();

	}

}
