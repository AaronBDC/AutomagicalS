package org.IntelligentSigma.selenium.pageObjects;

import org.IntelligentSigma.selenium.helpers.ApplicationHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.assertEquals;
import org.apache.commons.lang.StringUtils;

/**
 * STPConPage Page Object
 *
 * @author Mr. Hand
 */
public class STPConPage extends ApplicationHelper {

  /**
   * CSS Locators for the Elements on the STPConPage Page.
   */

  private static final String speakerMenuButton =
      ".navbar #tyler-navigation #menu-primary #menu-item-1353 " +
          "a[href=\"http://www.stpcon.com/speakers/\"]";
  private WebDriver driver;

  /**
   * STPConPage
   * Constructor for the Page Object
   *
   * @param driver is the WebDriver
   */
  public STPConPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  /**
   * clickSpeakerMenuItem
   * This method clicks on the "Speaker" menu and then the "Our Speakers" sub-menu item on the main STPCon page
   *
   * @return is the New Page Object, "STPConSpeakerPage"
   */
  public STPConSpeakerPage clickSpeakerMenuItem() {
    clickAndWaitForElementPresent(speakerMenuButton, STPConSpeakerPage.speakerListHeader);
    String header = "";
    int counter = 0;
    while (StringUtils.isEmpty(header)) {
      header = getText(STPConSpeakerPage.speakerListHeader);
      if (StringUtils.isEmpty(header)) {
        animationWait(1000);
        counter++;
      }
      if (counter > 5) {
        break;
      }
    }
    return PageFactory.initElements(driver, STPConSpeakerPage.class);
  }

  /**
   * Alternative
   */
  public void clickSpeakerMenuItem(STPConSpeakerPage stpConSpeakerPage) {
    clickAndWaitForElementPresent(speakerMenuButton, STPConSpeakerPage.speakerListHeader);
    String header = "";
    int counter = 0;
    while (StringUtils.isEmpty(header)) {
      header = getText(STPConSpeakerPage.speakerListHeader);
      if (StringUtils.isEmpty(header)) {
        animationWait(1000);
        counter++;
      }
      if (counter > 5) {
        break;
      }
    }
    updatePageObject(stpConSpeakerPage);
  }

  /**
   * verifySTPConPageTitle
   * This will verify the Page Title of http://www.stpcon.com/
   *
   * @param mainTitle is the expected main title of the page
   */
  public void verifySTPConPageTitle(String mainTitle) {
    String title = driver.getTitle();
    assertEquals(title, mainTitle, "EXPECTED: " + mainTitle + " ACTUAL: " + title);
  }
}