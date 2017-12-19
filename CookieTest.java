/*	CookieTest.java
*		Selenium and Java > 
* 			Javascript, Ajax, and Cookies > 
*				Cookies and Java Tests 
*	Testing cookies validate they are working properly
* 	In the example, he's expanding a web based treeview
*	with multiple nodes and folders.
*	A cookie object is provided to us by selenium Cookie.class

* paused @ 3:09 Cookies and JavaTests
*/

	@Before
	public void setup()
	{
		driver = new FirefoxDriver();
	}
	
	@Test
	public void checkForCookie()
	{
		//login to the page
		new LoginTest().loginSteps(driver);
		
		WebElement navMenuItem = driver.findElement(By.id("ygtvlabelel1"));
		String linkName = navMenuItem.getText();
		Boolean linkstatus = null;
		
		/*
		*	Here we are looping all the cookies to 
		* match the linkName if its already there,
		* 	if it is, its okay, we just want to make sure the status 
		*	flips appropriately
		*	if null, there was no cookie
		*	if true/false than the cookie was there
		*
		*/
		Set<Cookie> allCookies = driver.manage().getCookies();
		for (Cookie loadedCookie : allCookies)
		{
			if (loadedCookies.getName().equals(linkName))
			{
				linkStatus = new Boolean(loadedCookies.getValue().equalsIgnoreCase("true"));
			}//end if loadedCookies.getName
		}//end for all cookies
		
		navMenuItem.click();
		
		allCookies = driver.manage().getCookies();
		for (Cookie loadedCookie : allCookies)
		{
			if (loadedCookie.getName().equals(linkName))
			{		
				System.out.println(loadedCookie.getName() +
				
				boolean status = loadedCookie.getValue().equalsIgnoreCase("true");
				if (linkStatus == null && status == false)
				{
					fail("The cookie was added but false")l
				} else if (linkStatus != null && 
						  linkStatus != ! status)
				{
					fail("The cookie was there, but the status was not swapped");
				} else if (status == false)
				{
					fail("The cookie was created, but the status was not set to true");
				} else
				{	
					//it is OK, the cookie is there and true!
				}//end else if status == false
				
						  
				}//end if
			
								//linkStatus = new Boolean(loadedCookie.getValue().equalsIgnoreCase("true"));
			}//end if loaded cookieGetNames
		}//end for loadedCookie :  allCookies