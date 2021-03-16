import java.io.FileInputStream;			
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;		
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;		

public class Qus2 {				

public static void main(String[] args) throws IOException, InterruptedException {										
	
// Create WebDriver Instance		
	  String cwd = Paths.get("").toAbsolutePath().toString();
  	String filePath = cwd+"/chromedriver_win32/chromedriver.exe";
     System.setProperty("webdriver.chrome.driver",filePath);
     
      WebDriver driver=new ChromeDriver();				
    driver.get("https://accounts.lambdatest.com/register");					
    driver.manage().window().maximize();	
    
// Load the properties File		
    Properties obj = new Properties();					
    FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");									
    obj.load(objfile);
    
        
// Enter Data into Form	
    driver.findElement(By.name(obj.getProperty("FullName"))).sendKeys("Sakshi Negi");
    Thread.sleep(2000);
    driver.findElement(By.name(obj.getProperty("Email"))).sendKeys("sakshi.negi@gmail.com");
    Thread.sleep(2000);
    driver.findElement(By.id(obj.getProperty("Password"))).sendKeys("Test123");	
    Thread.sleep(2000);
    driver.findElement(By.name(obj.getProperty("Phone"))).sendKeys("+ 777 666 7766");
    Thread.sleep(2000); 
    driver.findElement(By.xpath(obj.getProperty("checkbox"))).click();	
    driver.quit();
    
  }		
}		