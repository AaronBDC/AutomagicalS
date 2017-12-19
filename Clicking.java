/* 	Clicking.java
*	Clicking Links in Java 
*	
*	
*	
*	
*/

public class Clicking
{
	@Test
	public void findingAndNavigating()
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/website/content/imagemap.html");
		
		System.out.println(".........All the a tags.........");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement link : links)
		{
			System.out.println(link.getText() + " " + link);
		}
		
		pause(15);
		
		System.out.println(".........Match the visible text exactly.........");
		WebElement link = driver.findElement(By.linkText("calendar"));
		link.click();
		
		pause(3);
		
		System.out.println(".........match the visible text partially.......");
		WebElement partial = driver.findElement(By.partialText("contact"));
		partial.click();
		
		pause(3);
		
		System.out.println("..........image maps..........");
		driver.get("http://localhost:8080/website/content/imagemap.html");
		WebElement imageMapElement;
		String [] colors = {"red", "purple", "green", "yellow"};
		
		for (int i=0; i < 20 ; i++)
		{
			imageMapElement = driver.findElement(By.id(colors.[i % 4]));
			imageMapElement.click();
			pause(1);
		}
		
		driver.quit();
	}//end findingAndNavigating
	private void pause (int seconds)
	{
		
	}
}//end clicking