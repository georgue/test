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

public class searchsucsessfilmresult extends TestBase {
	
		/**
		 * 
		 */
		@Test
		public void testUntitled(){
					
			driver.get(baseUrl + "/php4dvd/");
			
			try{
				WebDriverWait wait = new WebDriverWait(driver, 10, 500);
			WebElement wait_user = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
			wait_user.sendKeys("admin");
			
		    WebElement pass = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
		    pass.sendKeys("admin");
		    
		    WebElement submit = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("submit")));		    
		    submit.click();
			}
			catch(Exception e){}
			
			driver.get("http://localhost//php4dvd/?go=add");
			
			
			try {
				WebDriverWait wait2 = new WebDriverWait(driver, 15, 500);
			WebElement title_Input = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id=\"updateform\"]/*/*/tr[2]/td[2]/input[1]"))); 
			title_Input.sendKeys("Большой куш");
			
			
			WebElement year_Input = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id=\"updateform\"]/*/*/tr[4]/td[2]/input[1]")));
			year_Input.sendKeys("1999"); 
			
			 
			WebElement seen_No_Checkbox = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id=\"updateform\"]/*/*/tr[9]/*[2]/input[@id=\"seen_no\"]")));
			seen_No_Checkbox.click();
			
			seen_No_Checkbox.submit();
			}
			catch(Exception e){}
			
			
			driver.get(baseUrl + "/php4dvd/");
			
			try {
			WebDriverWait wait3 = new WebDriverWait(driver, 15, 3000);
			WebElement findCreateDiscription = wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), \"No movies where found.\")]")));
			WebElement elem_search = driver.findElement(By.id("q")); 
		   
		    elem_search.sendKeys("1999", Keys.ENTER);
		    
			// String str = findCreateDiscription.getAttribute("text");
			// String str = findCreateDiscription.getAttribute("innerHTML");
			
			String str = findCreateDiscription.getText();
			assertEquals(str, "0");
			}
			catch(Exception e){}
			
			try {
				WebDriverWait wait4 = new WebDriverWait(driver, 10, 2000);
				WebElement html = wait4.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html")));
				
				WebDriverWait wait5 = new WebDriverWait(driver, 10, 1000);
			WebElement btn = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), \"Большой куш\")]")));	
			btn.click();
			WebElement remove_btn = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/section/nav/ul/li[4]/div/div/a")));
			remove_btn.click();
			}
			catch(Exception e){}
			Alert arelt = (new WebDriverWait(driver, 20)).until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();	
			
			
			
					
				}

		
			
		}
		
	





