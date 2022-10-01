package Fourweek.Secondday;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chittorgarh {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver =new EdgeDriver();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(By.xpath("//a[@id='navbtn_stockmarket']")).click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		List<WebElement>Securityname= driver.findElements(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[3]"));
		
	    List<String> ListOfSecurityname=new ArrayList<String>();
		for (WebElement webElement : Securityname) {
			String str =webElement.getText();
			ListOfSecurityname.add(str);
			
		}
		ListOfSecurityname.size();
		System.out.println(ListOfSecurityname);
		Set<String> stringList =new HashSet<String>(ListOfSecurityname);
		
		if(stringList.size()==ListOfSecurityname.size()){
			System.out.println("No duplicates");
		}
		else
		{
			System.out.println("duplicates occurs");
		}

	}

}
