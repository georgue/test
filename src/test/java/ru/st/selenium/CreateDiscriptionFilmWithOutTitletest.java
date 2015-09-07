package ru.st.selenium;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateDiscriptionFilmWithOutTitletest extends logintest {
	@Test
	public void testUntitled(){
	driver.get(baseUrl + "/php4dvd/");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("submit")).click();
    
	
	WebElement add_movie_buttom = driver.findElement(By.xpath("//div[@id=\"content\"]/*/*/*[2]/*/*/*/a[@href]"));
	add_movie_buttom.click();
	
	
	WebElement title_Input = driver.findElement(By.xpath("//form[@id=\"updateform\"]/*/*/tr[2]/td[2]/input[1]"));
	title_Input.sendKeys("");
	
	
	WebElement year_Input = driver.findElement(By.xpath("//form[@id=\"updateform\"]/*/*/tr[4]/td[2]/input[1]"));
	year_Input.sendKeys("2014");
	
	 
	WebElement seen_No_Checkbox = driver.findElement(By.xpath("//form[@id=\"updateform\"]/*/*/tr[9]/*[2]/input[@id=\"seen_no\"]"));
	seen_No_Checkbox.click();
	
	seen_No_Checkbox.submit();
	
	WebElement findtext = driver.findElement(By.xpath("//*[@id=\"updateform\"]/table/tbody/tr[2]/td[2]/label"));
	String str = findtext.getText();
	
	
	assertEquals(str, "This field is required");
	}

}
