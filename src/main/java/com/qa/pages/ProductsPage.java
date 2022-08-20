package com.qa.pages;

import org.openqa.selenium.support.FindBy;

import com.tech.BaseTest;

import io.appium.java_client.MobileElement;

public class ProductsPage extends BaseTest {

      @FindBy(xpath="/html/body/div/div[2]/div[1]/h2") private MobileElement pageTitleTxt;

  public String getTitle() {
	  return getAttribute(pageTitleTxt, "text"); 
  }

}

