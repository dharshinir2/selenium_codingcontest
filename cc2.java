import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class cc2 {

	  WebDriver driver;
	  @BeforeTest
	  public void beforeTest(){
	 driver=new FirefoxDriver();
	  }
	 
	 
	 @Test
	 public void Test1() throws InterruptedException {
	 String url="https://www.saucedemo.com/";
	 driver.get(url);
	 driver.manage().window().maximize();
	 Thread.sleep(5000);
	 
	driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	Thread.sleep(5000);


	driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
	Thread.sleep(2000);


	WebElement txt=driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
	String txt1=txt.getText();
	System.out.println(txt1);
	WebElement price=driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div"));
	String pr1=price.getText();
	System.out.println(pr1);


	driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
	Thread.sleep(2000);


	String p1=driver.getCurrentUrl();
	String ap1="https://www.saucedemo.com/checkout-step-one.html";
	Assert.assertEquals(p1, ap1);

	driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("ab");
	driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("efgh");
	driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("12345");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
	System.out.println("details");
	Thread.sleep(2000);
	String p2=driver.getCurrentUrl();
	String ap2="https://www.saucedemo.com/checkout-step-two.html";
	Assert.assertEquals(p2, ap2);
	Thread.sleep(2000);
	String title=driver.getTitle();
	String atitle="Swag Labs";
	Assert.assertEquals(title,atitle);
	driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
	  }
	 
	 
	  @AfterTest
	  public void afterTest() throws InterruptedException {
	 Thread.sleep(2000);
	 driver.quit();
	  }
  }

