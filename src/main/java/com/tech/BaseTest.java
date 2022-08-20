package com.tech;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.qa.utils.TestUtiles;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	  static AppiumDriver<MobileElement> driver;
      static String PAGE_URL="https://birendra-kumar.herokuapp.com/admin";
      static Properties props;
      InputStream inputsream;
      boolean acceptNextAlert = true;
      
      public BaseTest() {
    	  PageFactory.initElements(new AppiumFieldDecorator(driver), this);
      }
      
    @Parameters ({"platormName", "platormVersion", "browserName"})
	@BeforeTest
	 public void setUp(String platormName, String platormVersion, String browserName ) {
		try {
			props = new Properties();
			String propFileName = "config.properties";
			inputsream = getClass().getClassLoader().getResourceAsStream(propFileName);
			props.load(inputsream);
			
		    DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("platformName", platormName);
		    caps.setCapability("platformVersion", platormVersion);
		    caps.setCapability("browserName", browserName);
		    caps.setCapability("unicodeKeyboard", true);
		    caps.setCapability("resetKeyboard", true);
		    caps.setCapability("chromedriverExecutable", System.getProperty("user.dir")+"/drivers/chromedriver_win32_v87.0.4280.20.exe");

		    URL url = new URL(props.getProperty("appiumURL"));
		    driver = new AppiumDriver<MobileElement>(url, caps);
		    driver.get(props.getProperty("baseURL"));
		
	 } catch(Exception exp) {
		 System.out.println("reason is:"+exp.getCause());
		 System.out.println("message is:"+exp.getMessage());
		 exp.printStackTrace();
	  }
	}
    
    public void waitForVisibility(WebElement e) {
    	WebDriverWait wait = new WebDriverWait(driver, TestUtiles.WAIT);
    	wait.until(ExpectedConditions.visibilityOf(e));
    	
    }
    
    public void click(MobileElement e)  {
    	waitForVisibility(e);
    	e.click();
    }
    
    public void sendKeys(MobileElement e, String txt) {
    	waitForVisibility(e);
    	e.sendKeys(txt);
    }
    
   public void clearTxt(MobileElement e) {
	   waitForVisibility(e);
	   e.clear();
   }
   
    public String getAttribute(MobileElement e, String attribute) {
    	waitForVisibility(e);
    	return e.getText();
    }
    
  public void afterTest() {
	  driver.quit();
  }
}
