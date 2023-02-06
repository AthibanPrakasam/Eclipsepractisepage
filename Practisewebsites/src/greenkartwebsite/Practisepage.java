package greenkartwebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Practisepage {
	WebDriver driver;
	@BeforeSuite
	public void getpractisepage() {
		System.setProperty("webdriver.chrome.driver", "/home/ticvictech/Downloads/eclipse-jee-2022-09-R-linux-gtk-x86_64/chromedriver");

	driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/#top");
	}
	
	@Test
	@Parameters("Name")
	public void testelements(String name)
	{
		
		
		WebElement Radio1  =  driver.findElement(By.xpath("(//input[@value='radio2'])[1]"));
		Radio1.click();
		if(Radio1.isSelected()) {
			
			System.out.println("radio button selected");
		}else
		{
			
			System.out.println("radio button not selected");
			
		
		}
		
		WebElement text = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		System.out.println( text.getAttribute("title"));
//		if(value.equals("Name is required")) {
//			System.out.println("Passed");
//		}
		text.sendKeys(name);
	System.out.println("Input box "+text.isEnabled());
	
	WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
	dropdown.isEnabled();
	dropdown.sendKeys("option1");
	System.out.println("dropdown box "+dropdown.isEnabled());
	
	WebElement checkbox = driver.findElement(By.xpath("//input[@id='checkBoxOption2']"));
	checkbox.click();
	if(checkbox.isSelected())
	{
		System.out.println("Option2 is selected");
		
	}
	
	
//	WebElement table =  (WebElement) driver.findElements(By.xpath("//table[@id='product'][2]"));
//	 
//	List<WebElement> rows =driver.findElements(By.xpath("//table[@id='product']//tbody//tr//td[1]"));
//	
//	System.out.println("NUmber of Rows"+rows.size());
//	
//	List<WebElement> Colums =driver.findElements(By.xpath("//table[@id='product']//thead//tr//th"));
//	
//	System.out.println("Numer of colums"+ Colums.size());
	
	}
	
	
	
   @AfterSuite
   public void closepractisepage() {
	   driver.close();
   }
	
	
	
	
	
	
	
	
}
