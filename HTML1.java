package Fourweek.Secondday;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTML1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver =new EdgeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='container']//table//tbody//tr"));
		int size = rows.size();
		System.out.println("Number of Rows :"+size);
		List<WebElement> column = driver.findElements(By.xpath("//div[@id='container']//table//th"));
		int csize = column.size();
		System.out.println("Number of column :"+csize);
//		driver.close();
		
		}

}
