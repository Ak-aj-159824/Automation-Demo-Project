package com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DougalsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter your email id: ");
//		String Login = sc.nextLine();
//		System.out.println("Enter your Password: ");
//		String Password = sc.nextLine();

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://test.dealer.fisherplows.com/");
		driver.findElement(By.id("ShopLoginForm_Login")).sendKeys("testajay1524@gmail.com");
		driver.findElement(By.id("ShopLoginForm_Password")).sendKeys("test@123");
		driver.findElement(By.xpath("//button[@value=\"Login\"]")).click();

		driver.findElement(By.linkText("Resources")).click();
		driver.findElement(By.linkText("eMATCH")).click();

		// eMatch 1st page
		driver.findElement(By.xpath("//option[@value=\"Truck\"]")).click();
		driver.findElement(By.cssSelector("option[value=\"2024\"]")).click();
		driver.findElement(By.cssSelector("option[value=\"CHEVY/GMC\"]")).click();
		driver.findElement(By.cssSelector("option[value=\"K1500 SILV/SIERRA\"]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Next']"))).click();

		// eMatch 2nd page
		driver.findElement(By.cssSelector("option[value=\"Crew Cab\"]")).click();
		driver.findElement(By.cssSelector("option[value=\"5.8 Box\"]")).click();
		driver.findElement(By.cssSelector("option[value=\"2.7L Turbo\"]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("ematch-page-next"))).click();

		// eMatch 3rd page
		WebElement dropdown3rd = driver.findElement(By.id("vehiclemountbladeoption"));
		Select s = new Select(dropdown3rd);
		s.selectByIndex(0);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("ematch-page-next"))).click();

		// eMatch 4th page
		WebElement dropdown4th = driver.findElement(By.className("vehiclecontroltypeoption"));
		Select s1 = new Select(dropdown4th);
		s1.selectByIndex(2);

		/// wait.until(ExpectedConditions.elementToBeClickable(dropdown4th));

		WebElement dropdown4 = driver.findElement(By.className("vehicle-plowheadlamp-type-option"));

		Select s2 = new Select(dropdown4);
		// System.out.println(dropdown4.isEnabled());

		if (dropdown4.isEnabled()) {
			s2.selectByValue("LED");

		} else {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("option[value=\"Halogen\"]"))).click();

		}
		wait.until(ExpectedConditions.elementToBeClickable(By.className("ematch-page-next"))).click();

		// eMatch 5th page
		System.out.println(driver.getTitle());

	}

}
