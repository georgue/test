package ru.st.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import ru.st.selenium.pages.TestBase;

public class searchsucsessfilmresult extends logintest {
	
		/**
		 * 
		 */
		@Test
		public void testUntitled(){
					
			driver.get(baseUrl + "/php4dvd/");
			
			 // login
				WebDriverWait wait = new WebDriverWait(driver, 30, 2000);
			WebElement wait_user = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
			wait_user.sendKeys("admin");
			
		    WebElement pass = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
		    pass.sendKeys("admin");
		    
		    WebElement submit = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("submit")));		    
		    submit.click();
									
			
		    WebElement find_no_movie = driver.findElement(By.xpath("//div[contains(text(), \"No movies where found.\")]"));
			Boolean wait_no_movie = wait.until(ExpectedConditions.stalenessOf(find_no_movie));
			
			//create film 
				WebDriverWait wait2 = new WebDriverWait(driver, 25, 2000);
			WebElement title_Input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id=\"updateform\"]/*/*/tr[2]/td[2]/input[1]"))); 
			title_Input.sendKeys("Большой куш");
			
			
			WebElement year_Input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id=\"updateform\"]/*/*/tr[4]/td[2]/input[1]")));
			year_Input.sendKeys("1999"); 
			
			 
			WebElement seen_No_Checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id=\"updateform\"]/*/*/tr[9]/*[2]/input[@id=\"seen_no\"]")));
			seen_No_Checkbox.click();
			
			seen_No_Checkbox.submit();
			
			
			
			driver.get(baseUrl + "/php4dvd/");
			
			
			//WebDriverWait wait3 = new WebDriverWait(driver, 15, 2000);
			WebElement findCreateDiscription = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), \"No movies where found.\")]"))); // waiting element "No movie where found"
			WebElement elem_search = driver.findElement(By.id("q")); 
		   
		    elem_search.sendKeys("1999", Keys.ENTER);
		    
			// String str = findCreateDiscription.getAttribute("text");
			// String str = findCreateDiscription.getAttribute("innerHTML");
			
			//String str = findCreateDiscription.getText();
			//assertEquals(str, "0");
			
			
			
			
				//WebDriverWait wait4 = new WebDriverWait(driver, 10, 2000);
				WebElement html = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html")));
				
				WebDriverWait wait5 = new WebDriverWait(driver, 10, 1000);
			WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), \"Большой куш\")]")));	
			btn.click();
			WebElement remove_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/section/nav/ul/li[4]/div/div/a")));
			remove_btn.click();
			
			Alert arelt = (new WebDriverWait(driver, 20)).until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();	
			
			
			
					
				}

		
			
		}
		
	





