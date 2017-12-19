package org.IntelligentSigma.selenium.pageObjects;

import org.IntelligentSigma.selenium.helpers.ApplicationHelper;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;

/**
 * STPConSpeakerBio Page Object
 *
 * @author Mr. Hand
 */
public class STPConSpeakerBioPage extends ApplicationHelper {

  /**
   * CSS Locators for the Elements on the STPConSpeakerBio Page.
   */

  public static final String speakerName = ".single-speaker .heading .container h1";
  private WebDriver driver;

  /**
   * STPConSpeakerBioPage
   * Constructor for the Page Object
   *
   * @param driver is the WebDriver
   */
  public STPConSpeakerBioPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  /**
   * Verify STPConSpeakerBioPageTitle
   * This will verify the Page Title on http://www.stpcon.com/speakers/david-mamanakis-2/
   *
   * @param mainTitle is the expected main title of the page
   */
  public void verifySTPConSpeakerBioPageTitle(String mainTitle) {
    String title = driver.getTitle();
    assertEquals(title, mainTitle, "EXPECTED: " + mainTitle + " ACTUAL: " + title);
  }
}
