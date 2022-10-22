package seleniumpracticing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumAuto {
	//public static void main(String[] args) throws InterruptedException {

		@Test
		public void login()
		{
			System.setProperty("webdriver.chrome.driver", "/Users/vipinjitsingh/Downloads/chromedriver");
			WebDriver driver = new ChromeDriver();
			
			
			driver.get("http://automationpractice.com/index.php?controller=my-account");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();
			
			
			driver.findElement(By.id("search_query_top")).sendKeys("shirts");
			
			driver.findElement(By.cssSelector("button[type='submit']")).click();
			
			String wb= driver.findElement(By.xpath("(//a[@rel='nofollow'])[1]")).getText();
			
			System.out.println("customer required to: "+ wb);
			
			//home page
			driver.findElement(By.xpath("//img[@class='logo img-responsive']")).click();
			
			driver.findElement(By.id("search_query_top")).sendKeys("shirts");
			
			driver.findElement(By.cssSelector("button[type='submit']")).click();
			
			// move to item
			Actions a = new Actions(driver);
			a.moveToElement(driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"))).build().perform();
			
			a.moveToElement(driver.findElement(By.xpath("//a[@class='button ajax_add_to_cart_button btn btn-default']"))).click().build().perform();
			
			// close the popup
		    //driver.findElement(By.xpath("//span[@class='cross']")).click();

			//clear the bar
			driver.findElement(By.id("search_query_top")).clear();		

			driver.findElement(By.id("search_query_top")).sendKeys("SUMMER DRESSES");

			driver.findElement(By.cssSelector("button[type='submit']")).click();
			
			a.moveToElement(driver.findElement(By.xpath("(//img[@alt='Printed Summer Dress'])[1]"))).build().perform();
			a.moveToElement(driver.findElement(By.xpath("(//span[text()='Add to cart'])[1]"))).click().build().perform();

		    //Thread.sleep(3000);
			// close the popup
			driver.findElement(By.xpath("//span[@class='cross']")).click();

			//home page
			driver.findElement(By.xpath("//img[@class='logo img-responsive']")).click();
			//verify products from home page
			a.moveToElement(driver.findElement(By.xpath("//a[@title='View my shopping cart']"))).build().perform();
			a.moveToElement(driver.findElement(By.xpath("//a[@title='View my shopping cart']"))).click().build().perform();

			// increment first element
			driver.findElement(By.xpath("//a[@id='cart_quantity_up_1_1_0_0']")).click();
			// increment second element
			driver.findElement(By.xpath("//a[@id='cart_quantity_up_5_19_0_0']")).click();
			driver.findElement(By.xpath("//a[@id='cart_quantity_up_5_19_0_0']")).click();
		    //Thread.sleep(2000);
			// decrease first item
			driver.findElement(By.xpath("//a[@id='cart_quantity_down_1_1_0_0']")).click();

			// remove second item
			driver.findElement(By.xpath("//a[@id='cart_quantity_down_5_19_0_0']")).click();

			
		
			driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
			//proceed to checkout				
			driver.findElement(By.xpath("(//a[@title='Proceed to checkout'])[2]")).click();
				driver.navigate().refresh();
					
				// enter password
				WebElement username = driver.findElement(By.xpath("//input[@id='email']"));
				username.sendKeys("singh07vj@gmail.com");
				 			
					// enter password
				WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));
				password.sendKeys("Godbless@2022");
				// click Login button
				WebElement login = driver.findElement(By.xpath("//button[@id='SubmitLogin']"));
				login.click();
				
				String URL = "http://automationpractice.com/index.php?controller=authentication&back=history";
				String expectedURL = driver.getCurrentUrl();
			    //Assert.assertEquals(URL, expectedURL);
				Assert.assertNotEquals(URL, expectedURL);
				System.out.println("logged in successfully");
				
					//proceed to checkout Address
					driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
					
					//select checkbox 
					driver.findElement(By.xpath("(//input[@type='checkbox'])")).click();				
					
					//proceed to checkout shipping
					driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
					
					//pay by bank wire
					driver.findElement(By.xpath("//a[@class='bankwire']")).click();
					
				
					//confirming my order
					driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
					
					//WebElement text = driver.findElement(By.xpath("//div/br[5]"));
					//System.out.println(text.getText());
					WebElement yourElement=
					        driver.findElement(By.xpath("//div/br[5]"));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", yourElement);
							System.out.println(yourElement);
							
					driver.findElement(By.xpath("//a[@title='My orders']")).click();
					
					//get order id
					WebElement orderID = driver.findElement(By.xpath("//tr[@class='first_item ']/td[1]"));
					System.out.println(orderID.getText());
					
//					Assert.assertEquals(text, orderID);
//					System.out.println(orderID +" : "+ " OrderID is verified");
					
					
					String SignedinUrl = driver.getCurrentUrl();
					WebElement signout = driver.findElement(By.xpath("//a[@class='logout']"));
					signout.click();
					
					String SignedoutUrl = driver.getCurrentUrl();
					Assert.assertNotEquals(SignedinUrl, SignedoutUrl);
					System.out.println("Customer signed out successfully");
					

		}

	}