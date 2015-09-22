package ru.st.selenium;
import ru.st.selenium.pages.TestBase;

import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//import ru.stqa.selenium.factory.WebDriverFactory;

public class CreateDiscriptionFilmWithOutTitletest extends logintest{
	@Test
	public void testUntitled() {		
		
		driver.get(baseUrl + "/php4dvd/");
		
		
			WebDriverWait wait = new WebDriverWait(driver, 10, 2000);
			WebElement wait_user = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
			wait_user.sendKeys("admin");
		
		
			WebElement wait_pass = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));			
			wait_pass.sendKeys("admin");
			
			WebElement wait_submit = wait.until(ExpectedConditions.elementToBeClickable(By.name("submit")));		    
		    wait_submit.click();
		
		
		
		WebDriverWait wait1 = new WebDriverWait(driver, 30, 2000);
	WebElement add_movie_buttom = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id=\"content\"]/*/*/*[2]/*/*/*/a[@href]")));
	add_movie_buttom.click();
	
	
	WebElement title_Input = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id=\"updateform\"]/*/*/tr[2]/td[2]/input[1]")));
	title_Input.sendKeys("");
	
	
	WebElement year_Input = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id=\"updateform\"]/*/*/tr[4]/td[2]/input[1]")));
	year_Input.sendKeys("2014");
	
	 
	WebElement seen_No_Checkbox = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id=\"updateform\"]/*/*/tr[9]/*[2]/input[@id=\"seen_no\"]")));
	seen_No_Checkbox.click();
	
	seen_No_Checkbox.submit();
	
	WebElement findtext = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"updateform\"]/table/tbody/tr[2]/td[2]/label")));
	String str = findtext.getText();
	
	
	assertEquals(str, "This field is required");
	
		}
	}


