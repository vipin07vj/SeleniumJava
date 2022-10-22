package seleniumpracticing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumIntri {

	public static void main(String[] args) throws InterruptedException {

		
		System.setProperty("webdriver.chrome.driver", "/Users/vipinjitsingh/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php?controller=my-account");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();

		// verify cart is empty
		WebElement cart = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
		cart.getText();
		System.out.println(cart);
		if(cart.equals("Your shopping cart is empty."))
		{
			System.out.println("No item is in the card");
		}
		
		// verify user is not logged in
		WebElement signin = driver.findElement(By.cssSelector("a[class='login']"));
		signin.getText();
		System.out.println(signin);
//		if(signin.equals("\n"
//				+ "			Sign in\n"
//				+ "		"))
//		{
//			System.out.println("user didnt signed in");
//		}
	
		driver.findElement(By.id("search_query_top")).sendKeys("shirts");
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		String wb= driver.findElement(By.xpath("(//a[@rel='nofollow'])[1]")).getText();
		
		System.out.println("Login sign still required "+ wb);
		
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

		Thread.sleep(3000);
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
			driver.findElement(By.xpath("//a[@id='cart_quantity_up_1_1_0_0']")).click();
			driver.findElement(By.xpath("//a[@id='cart_quantity_up_5_19_0_0']")).click();
		
			//driver.findElement(By.className("a[class='fancybox-item fancybox-close']")).click();

			driver.navigate().refresh();

				
				//proceed to checkout				
			a.moveToElement(driver.findElement(By.xpath("(//a[@title='Proceed to checkout'])[2]"))).click().build().perform();
				
				// click on sign in write its code				
				// enter password
			WebElement username = driver.findElement(By.xpath("//input[@id='email']"));
			username.sendKeys("singh07vj@gmail.com");
			 			
				// enter password
			WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));
			password.sendKeys("Godbless@2022");
			
			// click Login button
			WebElement login = driver.findElement(By.xpath("//button[@id='SubmitLogin']"));
			login.click();
			
			String expectedURL = driver.getCurrentUrl();
			System.out.println(expectedURL);
			
			String AfterLoginURL = "http://automationpractice.com/index.php";
			
			if (AfterLoginURL.equalsIgnoreCase(expectedURL))
			{
				System.out.println("Logged In successfully");
			}
			else
			{
				System.out.println("Didnt Logged In");
			}
				
				//proceed to checkout Address
				driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
				
				//select checkbox 
				driver.findElement(By.xpath("(//input[@type='checkbox'])")).click();				
				
				//proceed to checkout shipping
				driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
				
				// pay by bank wire
				driver.findElement(By.xpath("//a[@class='bankwire']")).click();
				
			
				// confirming my order
				driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
				
				//amount
//				WebElement prize = driver.findElement(By.xpath("//span[@class='price']/strong"));
//				prize.getText();
//				System.out.println(prize);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				WebElement yourElement=
		        driver.findElement(By.xpath("//div/br[5]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", yourElement);
				System.out.println(yourElement);
				
				
//				WebElement inpElement = driver.findElement(By.xpath("//div/br[5]"));
//				inpElement.getAttribute("text");
//				System.out.println(inpElement);
//				
				
				//home>order compare price.
				
				
				//log out
				
				WebElement signout = driver.findElement(By.xpath("//a[@class='logout']"));
				signout.click();
				driver.navigate().refresh();
				WebElement signedin = driver.findElement(By.xpath("//a[@class='login']"));
				signedin.getText();
				System.out.println(signedin);
				if(signout.equals("Sign in"))
				{
					System.out.println("Logged out successfully");
				}
	}

}
