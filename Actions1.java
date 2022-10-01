package Fourweek.Secondday;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get(" https://www.leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement findElement = driver.findElement(By.id("form:conpnl_header"));
		WebElement findElement2 = driver.findElement(By.id("form:restrictPanel"));
		Actions builder= new Actions(driver);
		Thread.sleep(2000);
		builder.dragAndDrop(findElement, findElement2).perform();
		//Droppable
		WebElement findElementdrag = driver.findElement(By.xpath("//p[text()='Drag to target']"));
		WebElement findElement2drop = driver.findElement(By.xpath("//p[text()='Drop here']"));
		Thread.sleep(3000);
		builder.dragAndDrop(findElementdrag, findElement2drop).perform();
		String text= driver.findElement(By.xpath("//div[@id='form:drop_content']/p[text()='Dropped!']")).getText();
		System.out.println("Draged successfull :" +text);
		//draggable columns
		Thread.sleep(2000);
		WebElement TableColumdrag = driver.findElement(By.xpath("//div[@class='ui-datatable-tablewrapper']//table//tr//th[3]"));
		String Colum2name=TableColumdrag.getText();
		WebElement Tablecolumdrop= driver.findElement(By.xpath("//div[@class='ui-datatable-tablewrapper']//table//tr//th[2]"));
		String Colum1name=Tablecolumdrop.getText();
		builder.dragAndDrop(TableColumdrag, Tablecolumdrop).perform();
		//draggable rows
		Thread.sleep(8000);
		WebElement TableRowdrag = driver.findElement(By.xpath("((//div[@class='ui-datatable-tablewrapper'])[2]//table//tr[1]/td)[1]"));
		WebElement TableRowdrop= driver.findElement(By.xpath("((//div[@class='ui-datatable-tablewrapper'])[2]//table//tr[2]/td)[1]"));
//		builder.clickAndHold(TableRowdrop).perform();
		builder.clickAndHold().perform();
		builder.dragAndDrop(TableRowdrag, TableRowdrop).perform();
//		String text2 = driver.findElement(By.xpath("//span[text()='Row moved']")).getText();
//		System.out.println("Dragged row :"+text2);
		driver.findElement(By.xpath("//span[text()='Start']")).click();
		String text3 = driver.findElement(By.xpath("//span[text()='Progress Completed']")).getText();
		System.out.println(text3);
		Thread.sleep(5000);
		driver.close();





	}

}
