package com.test.testcase;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;

public class myTest {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/said/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://dev.workmarket.com/login");
	    Thread.sleep(500);
	    driver.findElement(By.id("login-email")).sendKeys("qa+candidatetest2@workmarket.com");
	    Thread.sleep(500);
	    driver.findElement(By.id("login-password")).sendKeys("candidate2789");
	    Thread.sleep(500);
	    driver.findElement(By.id("login_page_button")).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//img[@src='https://dh6m49nd9nt7t.cloudfront.net/d34a5e2/images/find.talent.svg']")).click();
        Thread.sleep(500);
        driver.findElement(By.id("input-text")).sendKeys("test");
	    Thread.sleep(500);
        driver.findElement(By.id("input-text")).sendKeys(Keys.ENTER);
        Thread.sleep(1500);
        List<WebElement> profileCards = driver.findElements(By.xpath("//div[@class='search-results-area']//div[@id='search_results']/div/div[@class='profile-card--details']"));
        int count = profileCards.size();
        Thread.sleep(500);
        for (int i = 0; i < count; i++) {
            Thread.sleep(500);
        	List<WebElement> workerNameElems = profileCards.get(i).findElements(By.xpath("h2[@class='profile-card--header']/a"));
            Thread.sleep(500);
            String workerName = "";
        	if (workerNameElems.size() > 0) {
	            workerName = workerNameElems.get(0).getText();
        	}
            Thread.sleep(500);
        	List<WebElement> jobTitleElems = profileCards.get(i).findElements(By.xpath("ul[@class='profile-card--address']/li[@class='profile-limited-field']"));
            Thread.sleep(500);
            String jobTitle = "";
            if (jobTitleElems.size() > 0) {
        	    jobTitle = jobTitleElems.get(0).getText();
            }
            Thread.sleep(500);
            List<WebElement> companyTypeElems;
            if (jobTitleElems.size() > 0) {
	        	companyTypeElems = profileCards.get(i).findElements(By.xpath("ul[@class='profile-card--address']/li[2]"));
            } else {
	        	companyTypeElems = profileCards.get(i).findElements(By.xpath("ul[@class='profile-card--address']/li[1]"));
            }
 	        Thread.sleep(500);
 	        String companyType = "";
            if (companyTypeElems.size() > 0) {
        	    companyType = companyTypeElems.get(0).getText();
            }
            Thread.sleep(500);
        	List<WebElement> skillsElems = profileCards.get(i).findElements(By.xpath("ul[@class='profile-card--tests']/div[contains(@class, 'profile-limited-field')]"));
            Thread.sleep(500);
            String skills = "";
            if (skillsElems.size() > 0) {
        	    skills = skillsElems.get(0).getText();
            }
            assertTrue("Result must contain the word test in worker name, job title, company type, or skills.",
            	workerName.toLowerCase().contains("test") ||
            	jobTitle.toLowerCase().contains("test") ||
            	companyType.toLowerCase().contains("test") ||
            	skills.toLowerCase().contains("test"));
        }
        driver.close();
	}
}
