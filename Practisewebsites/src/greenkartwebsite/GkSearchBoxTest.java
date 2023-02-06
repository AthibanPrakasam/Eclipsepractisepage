package greenkartwebsite;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.google.common.io.Files;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@Listeners(greenkartwebsite.Listenerclass.class)
public class GkSearchBoxTest {
	@FindBy(xpath = "//input[@placeholder='Search for Vegetables and Fruits']")WebElement searchbox;  
	WebDriver driver ;
 
	
	@BeforeSuite
  public void openwebsiteTest() {
	  System.setProperty("webdriver.chrome.driver", "/home/ticvictech/Downloads/eclipse-jee-2022-09-R-linux-gtk-x86_64/chromedriver");
   driver = new ChromeDriver();
    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    driver.manage().window().maximize();
    
    
  }
  
  @Test(priority = 0)
  public void SearchboxUIcheck() {
	  
	 GkSearchBoxTest box = PageFactory.initElements(driver, GkSearchBoxTest.class);
	 // page object model 

	 System.out.println("Its displayed"+ " : " +box.searchbox.isDisplayed());
	 System.out.println("Its Enabled" + ":"+ box.searchbox.isEnabled());
	 System.out.println("Size of SearchBox"+":"+ box.searchbox.getSize());
	
	 
	 
  }
  
  @Test(priority = 1)
  public void Searchboxinputcheck() throws IOException, BiffException, InterruptedException {
	  
	  FileInputStream excel = new FileInputStream("/home/ticvictech/Documents/GKSearchBoxValidDetails.xls");
	  Workbook wb = Workbook.getWorkbook(excel);
	  Sheet s = wb.getSheet("Sheet1");
	  System.out.println(s.getRows());
	  
	  for (int i =0; i< s.getRows();i++) {
		
			 
		String data=  s.getCell(0, i).getContents();
	
		 WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search for Vegetables and Fruits']"));
		 search.sendKeys(data);
		 driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		 
		
		 Thread.sleep(2000);
		
	//	 WebDriverWait wait=new WebDriverWait(driver, 50);
		//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[normalize-space()='ADD TO CART'])[1]")));
		 
		
	 
		driver.findElement(By.xpath("(//button[normalize-space()='ADD TO CART'])[1]")).click();
		
		
		
	
		
	 driver.findElement(By.xpath("//input[@placeholder='Search for Vegetables and Fruits']")).clear();
	 
	 
		
		
	  }
	  
	 System.out.println( driver.getTitle());
  }
		@Test(priority=2)
		public void CheckChart() {
			driver.findElement(By.xpath("(//img[@alt='Cart'])[1]")).click();
		WebElement cart =driver.findElement(By.xpath("(//ul[@class='cart-items'])[1]"));
		System.out.println(cart.getText());
		
			
		}
  
  @Test(priority=3)
		public void TakeScreenshot() throws IOException {
		

		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 
		  Files.copy(f,new File("/home/ticvictech/Desktop/Screenshots/"+driver.getTitle()+".png")) ;
  }
		
  @Test(priority=4)
	public void Totalpriceanditems() {
			 
			  System.out.println("total items"+" "+driver.findElement((By.xpath("(//td)[3]"))).getText()); 
			  
			System.out.println("Order Total price "+" " +driver.findElement(By.xpath("(//td)[6]")).getText());
			  
			  
		  
		
	  
  }

  @AfterSuite
  public void closewebsiteTest() throws Throwable {
	 
	 //driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
    driver.close();
  }
}
