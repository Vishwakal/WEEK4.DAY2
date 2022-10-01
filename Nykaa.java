package Fourweek.Secondday;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get(" https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//searching L'oreal paris
		WebElement findElement = driver.findElement(By.xpath("//input[@name='search-suggestions-nykaa']"));
        findElement.sendKeys("L'Oreal Paris",Keys.ENTER);
        Thread.sleep(2000);
        String text = driver.getTitle();
        System.out.println("Title of L'Oreal Paris" +text);
        //clicking sort by
        WebElement findElement2 = driver.findElement(By.xpath("//button[@class=' css-n0ptfk']"));
        findElement2.click();
        //click customer top rating
        driver.findElement(By.xpath("//span[text()='customer top rated']//following::div")).click();
        //click category
        driver.findElement(By.xpath("//div[@id='first-filter']/div")).click();
        //click hair
         driver.findElement(By.xpath("(//div[@class=' css-b5p5ep'])[2]")).click();
         //click haircare
         driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
         //clickShampoo
         driver.findElement(By.xpath("//span[text()='Shampoo']/following::div[@class='control-indicator checkbox ']")).click();
         //click concern
         driver.findElement(By.xpath("//span[text()='Concern']")).click();
         //click color protection1
         WebElement findElement3 = driver.findElement(By.xpath("//span[text()='Color Protection']//following::div[@class='control-indicator checkbox ']"));
         String text3 = findElement3.getText();
         findElement3.click();
         //checking filter applied or not
         String text2 = driver.findElement(By.xpath("//div[@class='css-1rd7vky']/div")).getText();
         if(text2.contains(text3)) {
        	 System.out.println("filter Applied");
         }
         else
         {
        	 System.out.println("Filter not Applied");
         }
         //click on L'Oreal Paris Colour Protect Shampoo
         driver.findElement(By.xpath("//div[@class='css-1rd7vky']/div")).click();
         //Go To new Window
        String parentWindow =driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String>Window =new ArrayList<String>(windowHandles);
        driver.switchTo().window(Window.get(1));
        //select size as 175ml
        WebElement findElement4 = driver.findElement(By.xpath("//div[@class='css-11wjdq4']/select[@title='SIZE']"));
        Select dropdown =new Select(findElement4);
        dropdown.getFirstSelectedOption();
        String text4 = driver.findElement(By.xpath("//div[@class='css-1d0jf8e']/span[@class='css-1jczs19']")).getText();
        System.out.println("MRP :"+text4);
        driver.findElement(By.xpath("//div[@class='css-vp18r8']/button")).click();
        //go to shopping bag
        WebElement findElement5 = driver.findElement(By.xpath("//button[@class='css-g4vs13']"));
        findElement5.click();
        driver.switchTo().frame(0);
        //Gran Total
        String text5 = driver.findElement(By.xpath("//div[@class='payment-tbl-data']//div[@class='value medium-strong']")).getText();
        System.out.println("GrandTotal :"+text5);
        //click proceed
        driver.findElement(By.xpath("//span[text()='Proceed']")).click();
        //click continue check
        driver.findElement(By.xpath("//div[@class='pt15 pb20']//following::button")).click();
        String text6 = driver.findElement(By.xpath("//span[text()='259']")).getText();
        System.out.println(text6);
        if(text6.equals(text5))
        {
        	System.out.println("grandtotal are same");
        }
        else
        {
        	System.out.println("grandtotal are not same");
        }
        driver.quit();

	}

}
