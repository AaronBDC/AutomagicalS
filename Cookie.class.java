/*	Cookie.class
*		Selenium and Java > 
* 			Javascript, Ajax, and Cookies > 
*				Cookies and Java Tests 
*	Testing cookies validate they are working properly
* 	In the example, he's expanding a web based treeview
*	with multiple nodes and folders.
*	A cookie object is provided to us by selenium Cookie.class
*/

package org.openqa.selenium;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cookie {
	private final String name;
	private final String value;
	private final String path;
	private final String domain;
	private final Date expiry;
	private final boolean isSecure;
	private final boolean isHttpOnly;
	
	/*
	*	Creates an insecure non-httpOnly cookie with no domain specified.
	*
	*	@param name the name of the cookie; may not be null or an empty string.
	*	@param value the cookie value; may not be null.
	*	@param path the path the cookie is visible to. If left blank 
	*	or set to null, will be set to "/".
	*	
	*	@param expiry The cookie's expiration date; may be null.
	*	@see #Cookies (String, String, String, String, Date)
	*
	*
	*/
	
	public Cookie(String, name, String value, String path, Date expiry) {
		this(name.