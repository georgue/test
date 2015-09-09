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


public class RemoveDisctiptionFilm extends CreateDiscriptionFilmtest{	
		@Test
		public void testUntitled(){
			WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(baseUrl + "/php4dvd/");
			
			
		    WebElement user = driver.findElement(By.id("username"));
		    user.sendKeys("admin");
		    WebElement pass = driver.findElement(By.name("password"));
		    pass.sendKeys("admin");
		    WebElement submit = driver.findElement(By.name("submit"));
		    submit.click();
		    
			
			WebElement add_movie_buttom = driver.findElement(By.xpath("//div[@id=\"content\"]/*/*/*[2]/*/*/*/a[@href]"));
			add_movie_buttom.click();
			
			
			WebElement title_Input = driver.findElement(By.xpath("//form[@id=\"updateform\"]/*/*/tr[2]/td[2]/input[1]"));
			title_Input.sendKeys("Терминатор");
			
			
			WebElement year_Input = driver.findElement(By.xpath("//form[@id=\"updateform\"]/*/*/tr[4]/td[2]/input[1]"));
			year_Input.sendKeys("2014");
			
			 
			WebElement seen_No_Checkbox = driver.findElement(By.xpath("//form[@id=\"updateform\"]/*/*/tr[9]/*[2]/input[@id=\"seen_no\"]"));
			seen_No_Checkbox.click();
			
			seen_No_Checkbox.submit();
			
			WebElement btn_remove = driver.findElement(By.xpath("/html/body/div/div/div/section/nav/ul/li[4]/div/div/a"));
			btn_remove.click();
			Alert alert = driver.switchTo().alert();
			alert.accept();			
			
			
			WebElement findText = driver.findElement(By.xpath("//*[@id=\"results\"]/div[1]"));
			String str = findText.getText();

			assertEquals(str, "No movies where found.");
			
			
			
			
			
			
		}
	}





