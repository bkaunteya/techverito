package com.qa.test;

import org.testng.annotations.Test;

import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;
import com.tech.BaseTest;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

public class LoginTests extends BaseTest {
	
	LoginPage loginPage;
	ProductsPage productsPage;

	  @BeforeMethod
	  public void beforeMethod() {
		  loginPage = new LoginPage();
	  }
	  
	  @Test(priority=0)
	  public void invalidUserName() {
		  try {
		  loginPage.enterUserName("adminvv@example.com");
		  loginPage.enterPassword("password");
		  loginPage.pressLoginBtn();
		  String actaulErrTxt = loginPage.getErrText();
		  String expectedErrTxt = "Invalid Email or password.";
		  Assert.assertEquals(actaulErrTxt, expectedErrTxt);
		  System.out.println("user name is invalid");
		  } catch(Exception exp) {
			  System.out.println("reason is:"+exp.getCause());
			  System.out.println("message is:"+exp.getMessage());
			  exp.printStackTrace();
		  }
	  }
	  
	  @Test(priority=1)
	  public void invalidPassword() {
		  try {
		  loginPage.clearUserName();
		  loginPage.enterUserName("admin@example.com");
		  loginPage.clearPassword();
		  loginPage.enterPassword("password123");
		  loginPage.pressLoginBtn();
		  String actaulErrTxt = loginPage.getErrText();
		  String expectedErrTxt = "Invalid Email or password.";
		  Assert.assertEquals(actaulErrTxt, expectedErrTxt);
		  System.out.println("Password is invalid");
		  } catch(Exception exp) {
			  System.out.println("reason is:"+exp.getCause());
			  System.out.println("message is:"+exp.getMessage());
			  exp.printStackTrace();
		  }
	  }
	  
  @Test(priority=2)
  public void userLogin() {
	  try {
	  loginPage.clearUserName();
	  loginPage.enterUserName("admin@example.com");
	  loginPage.clearPassword();
	  loginPage.enterPassword("password");
	  productsPage = loginPage.pressLoginBtn();
	  
	  String actaulTitle = productsPage.getTitle();
	  String expectedTitle = "Dashboard";
	  Assert.assertEquals(actaulTitle, expectedTitle);
	  System.out.println("login successful");
	  System.out.println("Opened Page title is: "+actaulTitle);
	  
	  } catch(Exception exp) {
		  System.out.println("reason is:"+exp.getCause());
			 System.out.println("message is:"+exp.getMessage());
			 exp.printStackTrace();
	  }
  }
}
