package ru.st.selenium;
import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedCondition.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.thoughtworks.selenium.webdriven.commands.IsTextPresent;

import ru.st.selenium.pages.TestBase;
import ru.stqa.selenium.factory.WebDriverFactory;

import com.thoughtworks.selenium.webdriven.SeleneseCommand;


public class RemoveDisctiptionFilm extends logintest{	
		@Test
		public void testUntitled(){			
			
			driver.get(baseUrl + "/php4dvd/");
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement wait_user = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
			wait_user.sendKeys("admin");
		
		
			WebElement wait_pass = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));			
			wait_pass.sendKeys("admin");
			
			WebElement wait_submit = wait.until(ExpectedConditions.elementToBeClickable(By.name("submit")));		    
		    wait_submit.click();
		    
			
			WebElement add_movie_buttom = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id=\"content\"]/*/*/*[2]/*/*/*/a[@href]")));
			add_movie_buttom.click();
			
				WebDriverWait wait1 = new WebDriverWait(driver, 7, 2000);			
			WebElement title_Input = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id=\"updateform\"]/*/*/tr[2]/td[2]/input[1]")));
			title_Input.sendKeys("Терминатор");
			
			
			WebElement year_Input = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id=\"updateform\"]/*/*/tr[4]/td[2]/input[1]")));
			year_Input.sendKeys("2014");
			
			 
			WebElement seen_No_Checkbox = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id=\"updateform\"]/*/*/tr[9]/*[2]/input[@id=\"seen_no\"]")));
			seen_No_Checkbox.click();
			
			seen_No_Checkbox.submit();
			
				WebDriverWait wait11 = new WebDriverWait(driver, 7, 2000);
			WebElement btn_remove = wait11.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/section/nav/ul/li[4]/div/div/a")));
			btn_remove.click();
			Alert alert = driver.switchTo().alert();
			alert.accept();			
			
			
			WebElement findText = wait11.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"results\"]/div[1]")));
			String str = findText.getText();

			assertEquals(str, "No movies where found.");
			
			
			
			
		}
	}





