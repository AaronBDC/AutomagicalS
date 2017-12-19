package org.IntelligentSigma.selenium.tests;

import org.IntelligentSigma.selenium.helpers.ApplicationHelper;
import org.IntelligentSigma.selenium.helpers.BrowserHelper;
import org.IntelligentSigma.selenium.helpers.DriverHelper;
import org.IntelligentSigma.selenium.pageObjects.*;
import org.openqa.selenium.WebDriver;

/**
 * stpConTest
 * This class holds the actual tests.
 *
 * @author Mr. Hand
 */
public class stpConTest extends ApplicationHelper {

  /**
   * stpConTest
   * Constructor for the class.
   *
   * @param driver is the driver used for the test
   * @param browserSession is the actual browser used for the test
   */
  public stpConTest(WebDriver driver, BrowserHelper browserSession) {
    super(driver, browserSession);
  }

  /**
   * gotoAndVerifySTPConPage
   * This test runs against the STPCon website to find a specific person in the Speaker List and goes to their Bio Page
   *
   * @throws Exception will catch the Unhandles and other exceptions you may run into
   */
  public STPConPage gotoAndVerifySTPConPage() throws Exception {
    DriverHelper driverHelper = new DriverHelper();

    String mainTitle = "STPCon Fall 2015";

    STPConPage stpConPage = new STPConPage(driver);
    String url = driverHelper.getWorkingUrl();

    // Goto the starting point
    gotoSTPCon(stpConPage, url);

    // Verify that the right page is achieved
    stpConPage.verifySTPConPageTitle(mainTitle);

    return stpConPage;
  }

  /**
   * clickPageMenuSubMenuVerifySpeakerPage
   * This test will click on the STPCon Menu and SubMenu to get to the Speaker Page
   *
   * @param stpConPage is the page object of the STPCon web site
   * @return the STPConSpeakerPage page object
   */
  public STPConSpeakerPage clickPageMenuSubMenuVerifySpeakerPage(STPConPage stpConPage) {
    String speakerTitle = "Speakers « " + "STPCon Fall 2015";

    // If it is the right page, we continue to execute actions against the page
    STPConSpeakerPage stpConSpeakerPage = stpConPage.clickSpeakerMenuItem();

    // Verify that the right page is achieved
    stpConSpeakerPage.verifySTPConSpeakerPageTitle(speakerTitle);

    return stpConSpeakerPage;
  }

  /**
   * clickPersonOnSpeakerPageAndVerifySpeakerBioPage
   * This test will click on a Speaker from the Speaker Page and go to the Speakers Bio Page
   *
   * @param stpConSpeakerPage is the page object of the STPCon Speaker Page
   * @return the STPConSpeakerBioPage page object
   */
  public STPConSpeakerBioPage clickPersonOnSpeakerPageAndVerifySpeakerBioPage(STPConSpeakerPage stpConSpeakerPage) {
    String speakerBioTitle = "David Mamanakis « " + "STPCon Fall 2015";

    // If it is the right page, we continue to execute actions against the page
    STPConSpeakerBioPage stpConSpeakerBioPage = stpConSpeakerPage.clickSpeakerForBioPage();

    // Verify that the right page is achieved
    stpConSpeakerBioPage.verifySTPConSpeakerBioPageTitle(speakerBioTitle);

    return stpConSpeakerBioPage;
  }

  /**
   * Alternative
   */
  public void gotoStpConPage(STPConPage stpConPage) throws Exception{
    DriverHelper driverHelper = new DriverHelper();

    String url = driverHelper.getWorkingUrl();

    // Goto the starting point
    gotoSTPCon(stpConPage, url);
  }

  /**
   * Alternative
   */
  public STPConPage gotoStpConPage() throws Exception{
    DriverHelper driverHelper = new DriverHelper();

    String url = driverHelper.getWorkingUrl();

    // Goto the starting point
    return gotoSTPCon(url);
  }

  /**
   * Alternative
   */
  public void clickPageMenuSubMenuVerifySpeakerPage(STPConPage stpConPage, STPConSpeakerPage stpConSpeakerPage) {
    String speakerTitle = "Speakers « " + "STPCon Fall 2015";

    // If it is the right page, we continue to execute actions against the page
    stpConPage.clickSpeakerMenuItem(stpConSpeakerPage);

    // Verify that the right page is achieved
    stpConSpeakerPage.verifySTPConSpeakerPageTitle(speakerTitle);
  }

  /**
   * Alternative
   */
  public void clickPersonOnSpeakerPageAndVerifySpeakerBioPage(STPConSpeakerPage stpConSpeakerPage, STPConSpeakerBioPage stpConSpeakerBioPage) {
    String speakerBioTitle = "David Mamanakis « " + "STPCon Fall 2015";

    // If it is the right page, we continue to execute actions against the page
    stpConSpeakerPage.clickSpeakerForBioPage(stpConSpeakerBioPage);

    // Verify that the right page is achieved
    stpConSpeakerBioPage.verifySTPConSpeakerBioPageTitle(speakerBioTitle);
  }
}

