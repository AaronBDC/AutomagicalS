/* Ajax Elements in Java
*	package ajax;
*	Wait.java:
*/
import static junit.framework.Assert.assertTrue;

public class Wait
{
	@Test
	public void notThereYet()
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/website/pages/wait.html");
		
		WebElement button = driver.findElement(By.id("go"));
		WebElement entry = driver.findElement(By.id("entry"));
		
		String message = "I am Waiting!";
		entry.clear();
		entry.sendKey(message);
		
		button.click();
		/* click and wait wont work here
		* because it will wait for the whole page to refresh
		*
		*/
		
		
		WebElement results = driver.findElement(By.id("results"));
		
		try
		{
			assertTrue("The message sent contains the text sent", results.getText().contains(message());
		} finally {
			//driver.quit();
		}//end try/finally
	}//end Test public void notThereYet

	@Test
	public void waitForIt()
	{
		WebDriver button = driver.findElement(By.id("go"));
		driver.get("");
		
		WebElement button = driver.findElement(By.id("go"));
		WebElement entry = driver.findElement(By.id("entry"));
		String message = "I am waiting";
		entry.clear();
		entry.sendKeys(message);
		button.click();
		
		final WebElement results = driver.findElement(By.id("results"));// is a DIV tag
		WebDriverWait waiter = new WebDriverWait(driver, 4);
		
		
		/*	Here we are using an anonymous inner class ExpectedCondition
		*	to use the apply method to fill in with whatever logic we want
		*
		*
		*/
		waiter.until(new ExpectedCondition<Boolean>()
			{
				public Boolean apply(WebDriver driver)
				{
					/* Here we are looking to see if the text is NOT empty
					*	once empty we continue then
					*  go off and check if the condition is proper
					*	the test doesnt continue to run until this is TRUE
					* Is IT ready yet is it ready yet is it ready yet?
					*/
					return ! results.getText().isEmpty();
				}//end public Boolean apply WebDriver driver
			}//end new ExpectedCondition Boolean
			);//end waiter.until
		
		assertTrue("The message sent contains the text sent", results.getText().contains(message));
			
		driver.quit();
	}//end Test public void waitForIt
	
	@Test
	public void fancyWait()
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http");
		
		WebElement button = driver.findElement(By.id("goFancy"));
		WebElement entry = driver.findElement(By.id("entry"));
		String message = "I am waiting!";
		entry.clear();
		entry.sendKeys(message);
		button.click();
		
		final WebElement results = driver.findElement(By.id("results"));
		WebDriverWait waiter = new WebDriverWait(driver, 4);
		waiter.until(new ExpectedConditon<Boolean>()
			{
				public Boolean apply(WebDriver driver)
				{
					/*	as long as this text is equal to Loading,
					*	i'm not going to continue so once its
					*	no longer equal to the word Loading,
					*	then it will continue onward
					*
					*
					*	using the webdriverwait inside, we can wait for whatever condition we
					*	arrive at. ex: combination, status of change, webelements (found or not)
					*	anyhtin we can see we are already working with or driver
					*	to check its state
					*	we wait for them to respond and continue on 
					*  from there
					*/(
					return ! results.getText().equalsIgnoreCase("Loading");	
				}//end public Boolean apply webdriver
			}//end new ExpectedCondition Boolean
			);//end waiter.until
		
		assertTrue("The message sent contains the text sent", results.getText().contains(message));
		
		driver.quit();
	}//end Test	public void fancyWait() 
	
}//end public class Wait
