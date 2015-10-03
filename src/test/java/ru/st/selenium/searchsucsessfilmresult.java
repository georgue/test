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
				WebDriverWait wait = new WebDriverWait(driver, 50, 7000);
			WebElement wait_user = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
			wait_user.sendKeys("admin");
			
		    WebElement pass = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
		    pass.sendKeys("admin");
		    
		    WebElement submit = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("submit")));		    
		    submit.click();
		    
		    
		    
		  //search the film
		    
		    WebElement wait_elem_search = wait.until(ExpectedConditions.elementToBeClickable(By.id("q")));	    		    
		    wait_elem_search.sendKeys("1999", Keys.ENTER);
		    
		    WebElement findCreateDiscription = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), \"No movies where found.\")]")));						
			String Str_no_movie = findCreateDiscription.getText();
			
			wait_elem_search.clear();
			
			
			//create film 
			
			driver.get("http://localhost/php4dvd/?go=add");
			//WebElement add_movie_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/section/nav/ul/li[1]/div/div")));
			//add_movie_btn.click();
			
			WebElement title_Input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"updateform\"]/table/tbody/tr[2]/td[2]/input"))); 
			title_Input.sendKeys("Большой куш");
			
			
			WebElement year_Input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"updateform\"]/table/tbody/tr[4]/td[2]/input")));
			year_Input.sendKeys("1999");
			
			WebElement submit_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
			submit_btn.click();
			
			//search the film again
			driver.get("http://localhost/php4dvd/");
			
			WebElement wait_elem_search_again = wait.until(ExpectedConditions.elementToBeClickable(By.id("q")));
			wait_elem_search_again.sendKeys("1999", Keys.ENTER);
		    
		    WebElement find_film = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), \"Большой куш\")]")));						
			String Str_movie = find_film.getText();
			
			assertEquals(Str_movie, Str_no_movie, "Поиск сломался");
			
			 //
			// String str = findCreateDiscription.getAttribute("text");
			// String str = findCreateDiscription.getAttribute("innerHTML");
			
			//String str = findCreateDiscription.getText();
			//assertEquals(str, "0");
			//
			
			driver.get("http://localhost/php4dvd/?logout");
					
				}

		
			
		}
		
	





