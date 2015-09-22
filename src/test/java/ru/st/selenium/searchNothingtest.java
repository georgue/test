package ru.st.selenium;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ru.st.selenium.pages.TestBase;

public class searchNothingtest extends logintest  {
	
	@Test
	public void testUntitled() {
		driver.get(baseUrl + "/php4dvd/");
		
		WebDriverWait wait = new WebDriverWait(driver, 10, 5000);
		
			
			WebElement wait_user = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
			wait_user.sendKeys("admin");
		
		
			WebElement wait_pass = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));			
			wait_pass.sendKeys("admin");
			
			WebElement wait_submit = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("submit")));		    
		    wait_submit.click();
			
			WebElement wait_saerch = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("q")));
			wait_saerch.sendKeys("Мама", Keys.ENTER);
			
			WebDriverWait wait2 = new WebDriverWait(driver, 20, 10000);
			WebElement wait_nothing = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), \"No movies where found.\")]")));
						
			String str = wait_nothing.getText();
			
			assertEquals(str, "No movies where found.");
	
	}

}
