HandlingInput.java:

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/* 
* Inputs in Java
*/
public class HandlingInput
{
     private WebDriver driver;

     @Test
     public void textbox()
     {
          WebElement text = driver.findElement(By.name("textbox"));
          text.clear();
          text.sendKeys("Sending Text");
          pause(3);
          text.sendKeys(" More Text");
	}//end of textbox
	
	@Test
	public void checkbox()
	{
		WebElement checkbox = driver.findElement(By.name("checkbox"));
		int numberOfTime
		sToClick = new Random().nextInt(3) + 3;
		for (int i = 0; i < numberofTimesToClick; i++)
		{
			checkbox.click();
			pause(1);
		}//end for
		pause(2);
		
		//make sure it is clicked now
		if(! checkbox.isSelected())
		{
			checkbox.click();
		}
		pause(2);
		
	}//end checkbox
	
	@Test 
	public void radio()
	{
		List<WebElement> radioButtons = driver.findElements(By.name("radios"));
		for (WebElement radio : radioButtons)
		{
			radio.click();
			pause(2);
		}
		WebElement specificRadio = driver.findElement(By.xpath("//input[@value='2']"));
		specificRadio.click();
		pause(2);
	}
	
	@Test
	public void select()
	{
		List<WebElement> allOptions = driver.findElements(By.tagName("option"));
		for (WebElement option : allOptions)
		{
			System.out.println(String.format("Value is %s", option.getAttribute("value")));
			option.click();
		}
		
		List<WebElement> allSelects = driver.findElements(By.tagName("select"));
		for (WebElement we : allSelects)
		{
			Select select = new Select(we);
			if(select.isMultiple())
			{
				select.deselectAll();
			}
			select.selectByIndex(1);
			select.selectByVisibleText("Arizona");
		}
		List<WebElement> allValueOptions = driver.findElements(By.cssSelector("#statesWithValues > option"));
		for (WebElement option : allValueOptions)
		{
			option.click();
		}
	}//end select
	
	@Test
	public void submit()
	{
		fill();
		WebElement reset = driver.findElement(By.name("reset"));
		pause(1);
		reset.click;
		
		pause(2);
		fill();
		WebElement submit = driver.findElement(By.name("submit"));
		pause(1);
		submit.click();
		
		pause(2);
		fill();
		WebElement anyInput = driver.findElement(By.name("checkbox"));
		pause(1);
		anyInput.submit();
	}//end submit
}//end HandlingInput
/* you can find the submit button or take action 
*	any input then call the submit class
*
*
*/
	
	
		
