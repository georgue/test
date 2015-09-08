package ru.st.selenium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import ru.st.selenium.pages.TestBase;
import ru.stqa.selenium.factory.WebDriverFactory;



public class CreateDiscriptionFilmWithOutYeartest extends CreateDiscriptionFilmtest{
	@Test
	public void testUntitled(){
		
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
	

	WebElement seen_No_Checkbox = driver.findElement(By.xpath("//form[@id=\"updateform\"]/*/*/tr[9]/*[2]/input[@id=\"seen_no\"]"));
	seen_No_Checkbox.click();
	seen_No_Checkbox.submit();
	
	

	WebElement findtext = driver.findElement(By.xpath("//*[@id=\"updateform\"]/table/tbody/tr[4]/td[2]/label"));
	String str = findtext.getText();
	
	
	assertEquals(str, "This field is required");
	WebDriverFactory.dismissAll();

		}
	}




