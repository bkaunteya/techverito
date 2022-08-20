package com.qa.pages;

import org.openqa.selenium.support.FindBy;

import com.tech.BaseTest;

import io.appium.java_client.MobileElement;

public class LoginPage extends BaseTest {
	 
      @FindBy(xpath="//input[@id='admin_user_email']") private MobileElement emailAddress;
      @FindBy(xpath="//input[@id=\"admin_user_password\"]") private MobileElement password;
      @FindBy(xpath="//input[@value='Login']") private MobileElement loginBtn;
      @FindBy(xpath ="//div[contains(text(),'Invalid Email or password.')]") private MobileElement errTxt;

    public LoginPage enterUserName(String username) {
    	sendKeys(emailAddress,username);
	return this;
   }
    
    public LoginPage enterPassword(String pwd) {
    	sendKeys(password, pwd);
    	return this;
       }
    
   public LoginPage clearUserName() {
    	clearTxt(emailAddress);
    	return this;
       }
    
    public LoginPage clearPassword() {
    	clearTxt(password);
    	return this;
       }
    
    public ProductsPage pressLoginBtn() {
    	click(loginBtn);
    	return new ProductsPage();
       }
    
    public String getErrText() {
    	return getAttribute(errTxt, "text");
       }
}
