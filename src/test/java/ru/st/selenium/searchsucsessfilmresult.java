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
import static org.testng.Assert.assertNotEquals;
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
		    
		   try{
			   WebDriverWait wait2 = new WebDriverWait(driver, 10, 5000);
		    WebElement listfilm = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"title\"]")));
		    System.out.println(listfilm);
		   }
		   catch(Exception e){
		   		
		    
			//create film 1
			
			driver.get("http://localhost/php4dvd/?go=add");
			//WebElement add_movie_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/section/nav/ul/li[1]/div/div")));
			//add_movie_btn.click();
			
			WebElement title_Input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"updateform\"]/table/tbody/tr[2]/td[2]/input"))); 
			title_Input.sendKeys("Большой куш");
			
			
			WebElement year_Input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"updateform\"]/table/tbody/tr[4]/td[2]/input")));
			year_Input.sendKeys("1999");
			
			WebElement submit_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
			submit_btn.click();
			
		   }
		   
			
			// get a list film
			driver.get("http://localhost/php4dvd/");
			
				// wait load film list
			WebElement Load_films_after_search = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id=\"container\"]/footer")));
				// save a list film
			WebElement listfilm = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"title\"]")));
			
			//String Str_listfilm = listfilm.getText();			
			
			
			
			//search the film
			driver.get("http://localhost/php4dvd/");
			
				// wait load film list
			WebElement Load_films_after_search2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id=\"container\"]/footer")));
			
				//search film
			WebElement wait_elem_search_again = wait.until(ExpectedConditions.elementToBeClickable(By.id("q")));
			wait_elem_search_again.sendKeys("1999", Keys.ENTER);
			
			//load_page	
			WebElement wait_load = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"title\"]")));
			
			
			//get a new film list
			// подумать как получить список фильмов если есть другие фильмы < //div[@class="title"] >
			
			WebElement new_listfilm = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"title\"]")));
			//String Str_new_listfilm = new_listfilm.getText();
			System.out.println(new_listfilm);
			assertNotEquals(listfilm, new_listfilm, "поиск сломался");
			driver.get("http://localhost/php4dvd/?logout");
			
			//assertNotEquals(Str_movie, Str_no_movie, "Поиск сломался");
			
			 //
			// String str = findCreateDiscription.getAttribute("text");
			// String str = findCreateDiscription.getAttribute("innerHTML");
			
			//String str = findCreateDiscription.getText();
			//assertEquals(str, "0");
			//
			
			
					
				}

		
			
		}
		
	





