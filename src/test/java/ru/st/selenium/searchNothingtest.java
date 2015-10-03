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
	 static String str;
	
	@Test
	public void testUntitled() {
		driver.get(baseUrl + "/php4dvd/");
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
			
			WebElement wait_user = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
			wait_user.sendKeys("admin");
			//WebElement wait_page2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"loginform\"]/table/tbody/tr[2]/td[2]/input")));
			
			WebElement wait_pass = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));			
			wait_pass.sendKeys("admin");
			
			WebElement wait_submit = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("submit")));		    
		    wait_submit.click();
			
			WebElement wait_saerch = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("q")));
			wait_saerch.sendKeys("����", Keys.ENTER);
			
			WebElement wait_load_page = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id=\"container\"]/div[@id=\"wrapper\"]/div[@id=\"content\"]/section/div[@id=\"results\"]/div[@class=\"content\"]")));
			
			WebElement wait_nothing = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), \"No movies where found.\")]")));
			String str = wait_nothing.getText();	
					
			wait_saerch.clear();	
			driver.get("http://localhost/php4dvd/?logout");
			
			assertEquals(str, "No movies where found.");
			
			
				
			}

	
	}
			
			
			
			
	


