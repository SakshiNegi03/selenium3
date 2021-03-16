import java.nio.file.Paths;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Qus1 {

	public static void main(String[] args) throws InterruptedException {
	        
	        String cwd = Paths.get("").toAbsolutePath().toString();
	    	String filePath = cwd+"/chromedriver_win32/chromedriver.exe";
	       System.setProperty("webdriver.chrome.driver",filePath);
	       
	        WebDriver obj=new ChromeDriver();
	        obj.get("https://www.ultimateqa.com/simple-html-elements-for-automation/");
	       
	        
	        JavascriptExecutor js = (JavascriptExecutor) obj;
	        js.executeScript("window.scrollBy(0,1000)");
	        Thread.sleep(5000);
	           
	        //No.of rows 
	        List <WebElement> rows = obj.findElements(By.xpath("//*[@id=\"post-909\"]/div/div[1]/div/div[3]/div/div[2]/div[5]/div/table/tbody/tr")); 
	               
	    	//To calculate no of rows In table.
	    	int total_rows = rows.size();
	    	
	    	//Loop will execute till the last row of table.
	    	for (int row = 0; row < total_rows; row++) {
	    	    //To locate columns(cells) of that specific row.
	    	    List < WebElement > cloumns_of_row = rows.get(row).findElements(By.tagName("td"));    	    
	    	    int columns_count = cloumns_of_row.size();
	    	    
	    	    //Loop will execute till the last cell of that specific row.
	    	    for (int column = 0; column < columns_count; column++) {
	    	        // To retrieve text from that specific cell.
	    	        String celltext = cloumns_of_row.get(column).getText();
	    	        if(celltext.equalsIgnoreCase("Quality Assurance Engineer")) {
	    	        	celltext = cloumns_of_row.get(2).getText();
	    	        	  System.out.println(celltext);
	    	        	
	    	        }
	    	     
	    	    }
	    	}
	    	
	        obj.close();
	    }

	    }     	        

	


