package ru.st.selenium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ru.st.selenium.pages.TestBase;
import ru.stqa.selenium.factory.WebDriverFactory;



public class CreateDiscriptionFilmWithOutYeartest extends TestBase{
	@Test
	public void testUntitled(){
		driver.get(baseUrl + "/php4dvd/");
		try{
		WebDriverWait wait = new WebDriverWait(driver, 30, 500);
		WebElement wait_user = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
		wait_user.sendKeys("admin");
	
	
		WebElement wait_pass = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));			
		wait_pass.sendKeys("admin");
		
		WebElement wait_submit = wait.until(ExpectedConditions.elementToBeClickable(By.name("submit")));		    
	    wait_submit.click();
		}
		catch(Exception e){}
		
		try{    
		WebDriverWait wait = new WebDriverWait(driver, 30, 500);
	WebElement add_movie_buttom = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id=\"content\"]/*/*/*[2]/*/*/*/a[@href]")));
	add_movie_buttom.click();
	
	
	WebElement title_Input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class=\"required error\"]")));
	
	title_Input.sendKeys("ïïïï");
	

	WebElement seen_No_Checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt=\"Save\"]")));
	seen_No_Checkbox.click();
	seen_No_Checkbox.submit();
	
		}
		catch(Exception e){}
		try{    
			WebDriverWait wait = new WebDriverWait(driver, 30, 2000);
			
			
	WebElement findtext = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for=\"year\"]")));
	String str = findtext.getText();
	
	System.out.println(str);
	assertEquals(str, "This field is required");

		}
		catch(TimeoutException e){}


		}
	}




