package ru.st.selenium;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class RemoveDisctiptionFilm extends logintest {
	
		@Test
		public void testUntitled(){			
			
			driver.get(baseUrl + "/php4dvd/");
			// login
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement wait_user = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
			wait_user.sendKeys("admin");
		
		
			WebElement wait_pass = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));			
			wait_pass.sendKeys("admin");
			
			WebElement wait_submit = wait.until(ExpectedConditions.elementToBeClickable(By.name("submit")));		    
		    wait_submit.click();
		    
			// create film 1
			WebElement add_movie_buttom = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id=\"content\"]/*/*/*[2]/*/*/*/a[@href]")));
			add_movie_buttom.click();
			
							
			WebElement title_Input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id=\"updateform\"]/*/*/tr[2]/td[2]/input[1]")));
			title_Input.sendKeys("Терминатор");
			
			
			WebElement year_Input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id=\"updateform\"]/*/*/tr[4]/td[2]/input[1]")));
			year_Input.sendKeys("2014");
			
			 
			WebElement seen_No_Checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id=\"updateform\"]/*/*/tr[9]/*[2]/input[@id=\"seen_no\"]")));
			seen_No_Checkbox.click();
			
			seen_No_Checkbox.submit();
			
			driver.get("http://localhost/php4dvd/"); 
			// create film 2

			WebElement add_movie_buttom2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id=\"content\"]/*/*/*[2]/*/*/*/a[@href]")));
			add_movie_buttom2.click();
			
			//wait load page
			WebElement load_main_page = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/section/div")));
						
						
			WebElement title_Input2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id=\"updateform\"]/*/*/tr[2]/td[2]/input[1]")));
			title_Input2.sendKeys("Терминатор2");
						
						
			WebElement year_Input2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id=\"updateform\"]/*/*/tr[4]/td[2]/input[1]")));
			year_Input2.sendKeys("2013");			
						 
			WebElement seen_No_Checkbox2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"submit\"]")));						
			seen_No_Checkbox2.submit();
			
			
			
			
			driver.get("http://localhost/php4dvd/");
			
			// findText
			WebElement find_film = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), \"Терминатор\")]")));
			//String str = findText.getText();
			
			// remove film
				
			WebElement film_page = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), \"Терминатор2\")]")));
			film_page.click();
			
			WebElement btn_remove = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/section/nav/ul/li[4]/div/div/a")));
			btn_remove.click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
			
			
			
			WebElement find_film_after_remove = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), \"Терминатор\")]")));
			//String str_after = findText_after.getText();
			
			driver.get("http://localhost/php4dvd/?logout");	

			assertNotEquals(find_film, find_film_after_remove );
			
				
			
		}
		@AfterMethod
		public void clear(){
			
			driver.get("http://localhost/php4dvd/");
			WebDriverWait wait11 = new WebDriverWait(driver, 20 , 2000);
			
			WebElement wait_user = wait11.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
			wait_user.sendKeys("admin");
		
		
			WebElement wait_pass = wait11.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));			
			wait_pass.sendKeys("admin");
			
			WebElement wait_submit = wait11.until(ExpectedConditions.elementToBeClickable(By.name("submit")));		    
		    wait_submit.click();
			
			WebElement film_page = wait11.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), \"Терминатор\")]")));
			film_page.click();
			
			WebElement btn_remove = wait11.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/section/nav/ul/li[4]/div/div/a")));
			btn_remove.click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
			driver.get("http://localhost/php4dvd/?logout");
			
			
		}

				

		
	}





