package com.test.testcase;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_Tests {
	public static void main(String[] args) throws InterruptedException {
		Login_Tests.successfulLogin();
		Login_Tests.invalidLogin();
	}

	public static WebDriver Webdriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/said/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void successfulLogin() throws InterruptedException {
		WebDriver driver = Login_Tests.Webdriver();
	    driver.get("https://dev.workmarket.com/login");
	    Thread.sleep(500);
	    driver.findElement(By.id("login-email")).sendKeys("qa+candidatetest2@workmarket.com");
	    Thread.sleep(500);
	    driver.findElement(By.id("login-password")).sendKeys("candidate2789");
	    Thread.sleep(500);
	    driver.findElement(By.id("login_page_button")).click();
	    Thread.sleep(500);	
	    String url = driver.getCurrentUrl();
	    Assert.assertTrue("User logged in successfully? ", url.equals("https://dev.workmarket.com/home"));
	    driver.close();
	}
	
	public static void invalidLogin() throws InterruptedException {
		WebDriver driver = Login_Tests.Webdriver();
	    driver.get("https://dev.workmarket.com/login");
	    Thread.sleep(500);
	    driver.findElement(By.id("login-email")).sendKeys("notareal@email.com");
	    Thread.sleep(500);
	    driver.findElement(By.id("login-password")).sendKeys("notarealpassword");
	    Thread.sleep(500);
	    driver.findElement(By.id("login_page_button")).click();
	    Thread.sleep(500);
	    List<WebElement> elems = driver.findElements(By.cssSelector(".alert.alert-error"));
	    Thread.sleep(500);
	    String error = elems.get(0).getText().trim();
	    Assert.assertEquals("Invalid user name or password.", error);
	    driver.close();
	}
}
