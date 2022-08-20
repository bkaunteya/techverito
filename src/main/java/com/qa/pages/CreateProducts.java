package com.qa.pages;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import com.tech.BaseTest;

import io.appium.java_client.MobileElement;

public class CreateProducts extends BaseTest {
	 @FindBy(linkText ="Products") private MobileElement productLink;
	 @FindBy(xpath="//*[@id=\"titlebar_right\"]/div/span/a") private MobileElement newProdctBtn;
	 @FindBy(xpath ="//*[@id=\"collection_selection\"]/div[2]/span/a") private List<MobileElement> createOne;
	 @FindBy(xpath="//input[@id='product_title']") private MobileElement productTitle;
     @FindBy(xpath="//input[@id='product_sku']") private MobileElement productSku;
     @FindBy(xpath="//input[@id='product_description']") private MobileElement productDescr;
     @FindBy(xpath="//*[@id=\"product_submit_action\"]/input") private MobileElement creatProductBtn;
     @FindBy(xpath ="//div[contains(text(),'Product was successfully created.')]") private List<MobileElement> message;
     @FindBy(xpath="//tbody/tr[1]/td[2]/a") private MobileElement productId;
     @FindBy(xpath="//*[@id=\"titlebar_right\"]/div/span[1]/a") private MobileElement editProduct;
     @FindBy(xpath="//div[contains(text(),'Product was successfully updated.')]") private List<MobileElement> updatedmsg;
     @FindBy(xpath="//input[@id='collection_selection_toggle_all']") private MobileElement checkBx;
     @FindBy(xpath="//*[@id=\"collection_selection\"]/div[1]/div/a") private MobileElement batchDropDown;
     @FindBy(xpath="//a[contains(text(),'Delete Selected')]") private MobileElement deleteSelectedMenu;
     @FindBy(xpath="//*[@id=\"wrapper\"]/div[3]/div") private MobileElement delMessage;
     @FindBy(xpath="/html/body/div[2]/div[2]/div/button[1]") private MobileElement okBtn;
     @FindBy(xpath="//a[contains(text(),'Cancel')]") private MobileElement cancelBtn;
     @FindBy(xpath="//*[@id=\"index_footer\"]/div[1]") private MobileElement numberOfProduct;
     
     public CreateProducts newProduct() {
    	 click(newProdctBtn);
    	 return this;
     }
     
     public CreateProducts createProductBtn() {
    	 click(creatProductBtn);
    	 return this;
     }
     
     public String getProductTitle() {
    	 return getAttribute(productTitle, "text");
     }
     
     public String getProductSku() {
    	 return getAttribute(productSku, "text");
     }
     
     public CreateProducts createProductTitle(String title) {
   	  sendKeys(productTitle, title);
   	return this;
     }
     
     public CreateProducts createProductSku(String sku) {
   	  sendKeys(productSku, sku);
   	return this;
     }
     
   public void createProductDescription(String description) {
   	  sendKeys(productDescr, description);
     }

   public CreateProducts cancelProduct() {
	   click(cancelBtn);
	   return this;
   }
   
    public CreateProducts checkProducts() {
 	     click(productLink);
 	     return this;
      }
    
    public List<MobileElement> createOneLink() {
	  return createOne;
     }
    
    public List<MobileElement> checkMessage() {
    	return message;
    }
    
	public CreateProducts clearPTtile() {
    	clearTxt(productTitle);
    	return this;
    }
    
    public CreateProducts clearPSku() {
    	clearTxt(productSku);
    	return this;
    }
    public CreateProducts clearPDesrc() {
    	clearTxt(productDescr);
    	return this;
    }
   public CreateProducts updateLinks() {
	   click(productId);
	   return this;
   }
   public CreateProducts editProductDetails() { 
	   click(editProduct);
	   return this;
   }
   public List<MobileElement> updatedMessage() {
   	return updatedmsg;
   }
   
   public CreateProducts tryCheckbox() {
	   click(checkBx);
	   return this;
   }
   
   public CreateProducts batchButton() {
	   click(batchDropDown);
	   return this;  
   }
   public CreateProducts deleteMenuButton() {
	   click(deleteSelectedMenu);
	   return this;  
   }
   
   public String deleteMessage() {
	   	return getAttribute(delMessage, "text");
	   }
 

   public CreateProducts acceptAlert() {
	   click(okBtn);
	   return this;
   }
   
   public String counOfProducts() {
	   return getAttribute(numberOfProduct, "text");
   }
}


