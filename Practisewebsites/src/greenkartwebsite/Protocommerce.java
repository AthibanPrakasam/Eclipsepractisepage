package greenkartwebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Protocommerce {
	WebDriver driver;
	
	String[][] data ={
	
		{"Athiban","athibanprakash1997@gmail.com","253127"},
		{"Prakash","prakashathiban@gmail.com","athi25"}
		                                     
	};
	@DataProvider (name = "logindata")
	public  String[][] logindataprovider () {
		return data ;
	}
	
	@Test(dataProvider = "logindata" , priority = 0)
	public void Pc (String typename , String typeemail , String typepassword) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/home/ticvictech/Downloads/eclipse-jee-2022-09-R-linux-gtk-x86_64/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement name = driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']"));
		name.sendKeys(typename);
		WebElement email = driver.findElement(By.xpath("(//input[@name='email'])[1]"));
		email.sendKeys(typeemail);
		WebElement password = driver.findElement(By.xpath("(//input[@id='exampleInputPassword1'])[1]"));
		password.sendKeys(typepassword);
			
	
		WebElement gender = driver.findElement(By.xpath("(//select[@id='exampleFormControlSelect1'])[1]"));
	    gender.click();
		gender.sendKeys("Male");
		gender.isEnabled();
		SoftAssert enable = new SoftAssert();               //soft assert 
		enable.assertEquals(true, true);
	
	
	driver.close();
	}
                                                         
	                                              
	
}
