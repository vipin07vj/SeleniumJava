package seleniumpracticing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class New {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/vipinjitsingh/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().refresh();
		
		driver.manage().deleteAllCookies();
		
		
		driver.get("http://automationpractice.com/index.php?controller=order-confirmation&id_cart=5131639&id_module=3&id_order=483535&key=f0154501b3471982b1d235805bc1c45e");
		driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By.xpath("//input[@id='email']"));
		username.sendKeys("singh07vj@gmail.com");
		 			
//			// enter password
		WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));
		password.sendKeys("Godbless@2022");
		
//			// click Login button
		WebElement login = driver.findElement(By.xpath("//button[@id='SubmitLogin']"));
		login.click();
		
		driver.findElement(By.xpath("//a[@title='My orders']")).click();
		
		WebElement orderID = driver.findElement(By.xpath("(//a[@class='color-myaccount'])[1]"));
		System.out.println(orderID.getText());
		
		
		
		
	}

}
