/* Screenshot.java
*	
*	unknown class name
*	
*
*/
Class
{
	@Test
	public void positioning() throws IOException
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/website/pages/drag.html");
		
		WebElement dragger = driver.findElement(By.id("drag1"));
		
		Actions worker = new Actions(driver);
		worker.clickAndHold(dragger);
		worker.moveByOffset(10,-150);
		worker.release();
		worker.perform();

		TakesScreenshot camera = (TakesScreenshot) driver;
		byte[] imageByte = camera.getScreenshotAs(outputType.BYTES);

		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("align.png"));
		out.write(imageBytes);
		out.close();

		driver.quit();

	}//end positioning
	
	@Test
	public void doubleCheck() throws IOException
	{
		WebDriver driver = new FirefoxDriver();
		TakesScreenshot camera = (TakesScreenshot) driver;
		
		driver.get("http://localhost:8080/website/signon.vpd");
		WebElement submit = driver.findElement(By.name("submit"));
		submit.click();

		takeScreenshot("noEntry.png", camera);
               	
		WebElement username = driver.findElement(By.id("usernameInput"));
		username.sendKeys("admin");	
		
		WebElement password = driver.findElement(By.id("passwordInput"));
		password.sendKeys("junk");
		
		submit = driver.findElement(By.name("submit"));
		submit.click();
		
		takeScreenshot("invalid.png", camera);
	}//ends test Doublecheck	

	private void takeScreenshot(String name, TakesScreenshot camera) throws IOException
	{
		byte[] imageBytes = camera.getScreenshotAs(OutputType.BYTES);
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(name));
		out.write(imageBytes);
		out.close();
	}//end takeScreenshot
}//end class
