/*	CheckingStyle.java
*	Display Items and Appearance in Java
*	
*
*/

	driver.get("http://localhost:8080/website/pages/visible.html");
	
	WebElement hideMe = driver.findElement(By.id("hiddenToStart"));
	hideMe.clear();
	String testMessage = "Test Visibility";
	hideMe.sendKeys(testMessage);
	
	WebElement button = driver.findElement(By.id("makeInvisible"));
	button.click();
	
	// I can get info no matter what!
	assertEquals("This is the value I typed", testMessage, hideMe.getAttribute("value"));
	
	// show the box went away
	assertEquals("It is no longer displayed", "none", hideMe.getCssValue("display"));
	assertEquals("It is no longer displayed", "hidden", hideMe.getCssValue("visibility"));
	
	WebDriverWait waiter = new WebDriverWait(driver, 3);
	waiter.until(new ExpectedCondition<Boolean>()
		{
			public Boolean apply(WebDriver driver)
			{
				return ! driver.findElement(By.id("hiddenToStart")).getCssValue("display").equalsIgnoreCase("none");
			}
		});
		
		assertEquals("This is the value after it re-appears", "I'm back!", hideMe.getAttribute("value"));
		
	}
	
	
////
/
///

	@Test
	public void beautify()
	{
		driver.get("http://localhost:8080/website/signon.vpd");
		
		WebElement username = driver.findElement(By.id("usernameInput"));
		username.sendKeys("admin");
		
		WebElement password = driver.findElement(By.id("passwordInput"));
		password.sendkeys("junk");
		
		WebElement button = driver.findElement(By.name("submit"));
		button.click();
		
		WebElement errorBlock = driver.findElement(By.className("errors"));
		String [] cssValues = {"background-color", "color", "font-weight", "border", "border-top-color", "border-bottom"}
		for (String value : cssValues)
		
		
		
		{
			System.out.println(value + " = " + errorBlock.getCssValue(value));
		}
		driver.quit();
	}