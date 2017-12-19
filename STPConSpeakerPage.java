package org.IntelligentSigma.selenium.pageObjects;

import org.IntelligentSigma.selenium.helpers.ApplicationHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.apache.commons.lang.StringUtils;

/**
 * STPConSpeakerPage Page Object
 *
 * @author Mr. Hand
 */
public class STPConSpeakerPage extends ApplicationHelper {

  /**
   * CSS Locators for the Elements on the STPConSpeakerPage Page.
   */

  public static final String speakerListHeader = ".heading .container";
  private static final String speakerPicture = ".container .speakers .speaker .photo img[title=\"David Mamanakis\"]";
  private WebDriver driver;

  /**
   * STPConSpeakerPage
   * Constructor for the Page Object
   *
   * @param driver is the WebDriver
   */
  public STPConSpeakerPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  /**
   * clickSpeakerForBioPage
   * This method clicks on the desired speaker to go to the Bio Page
   *
   * @return is the New Page Object, "STPConSpeakerBioPage"
   */
  public STPConSpeakerBioPage clickSpeakerForBioPage() {
    List<WebElement> webElementList = findElements(speakerPicture);
    clickItemInElementList(webElementList, 0);
    String name = "";
    int counter = 0;
    while (StringUtils.isEmpty(name)) {
      name = getText(STPConSpeakerBioPage.speakerName);
      if (StringUtils.isEmpty(name)) {
        animationWait(1000);
        counter++;
      }
      if (counter > 5) {
        break;
      }
    }
    return PageFactory.initElements(driver, STPConSpeakerBioPage.class);
  }

  /**
   * Alternative
   */
  public void clickSpeakerForBioPage(STPConSpeakerBioPage stpConSPeakerBioPage) {
    List<WebElement> webElementList = findElements(speakerPicture);
    clickItemInElementList(webElementList, 0);
    String name = "";
    int counter = 0;
    while (StringUtils.isEmpty(name)) {
      name = getText(STPConSpeakerBioPage.speakerName);
      if (StringUtils.isEmpty(name)) {
        animationWait(1000);
        counter++;
      }
      if (counter > 5) {
        break;
      }
    }
    updatePageObject(stpConSPeakerBioPage);
  }

  /**
   * verifySTPConSpeakerPageTitle
   * This will verify the Page Title of http://www.stpcon.com/speakers/
   *
   * @param mainTitle is the expected main title of the page
   */
  public void verifySTPConSpeakerPageTitle(String mainTitle) {
    String title = driver.getTitle();
    assertEquals(title, mainTitle, "EXPECTED: " + mainTitle + " ACTUAL: " + title);
  }
}
