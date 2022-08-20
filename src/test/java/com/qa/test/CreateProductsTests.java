package com.qa.test;

import org.testng.annotations.Test;

import com.qa.pages.CreateProducts;
import com.qa.pages.ProductsPage;
import com.tech.BaseTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.Assert;

public class CreateProductsTests extends BaseTest {
	ProductsPage productsPage;
	CreateProducts create;
	
	 @BeforeMethod
	  public void beforeMethod() {
		  create = new CreateProducts();
		  productsPage = new ProductsPage();
	  }
	
	 //navigate to the Product page
	 @Test(priority=0)
	  public void checkProductLink() {
		  create.checkProducts();
	  }
	 
	 //To verify whether products are already exist or not
	 @Test(priority=1)
	 public void checkCreateLink() {
		 if(create.createOneLink().size()>0) {
		   System.out.println("There are no Products. Please Create Products.");
		}
		 else {
			 System.out.println("Products are available.");
		}
	 }
	 
	 //To create new products on the basis of details are available in the DataProvider
	 @Test(dataProvider = "dp", priority=2)
	 public void createNewProduct(String string1, String string2, String string3) {
		 create.newProduct();
		 create.clearPTtile();
		 create.createProductTitle(string1);
		 create.clearPSku();
		 create.createProductSku(string2);
		 create.clearPDesrc();
		 create.createProductDescription(string3);
         create.createProductBtn();
         if(create.checkMessage().size()>0) {
             System.out.println("New product created Successfully...");
             create.checkProducts();
         }
         else {
        	 create.cancelProduct();
        	 System.out.println("Product Already exist.");
      }      
} 
 
	 //this will update the 1 available product with given details
	 @Test(dataProvider = "dp1", priority=3)
	 public void updateProduct(String str1, String Str2, String str3) {
		 create.updateLinks();
		 create.editProductDetails();
		 create.clearPTtile();
		 create.createProductTitle(str1);
		 create.clearPSku();
		 create.createProductSku(Str2);
		 create.clearPDesrc();
		 create.createProductDescription(str3);
         create.createProductBtn();
         if(create.updatedMessage().size()>0) {
        	 System.out.println("Product was successfully updated.");
             create.checkProducts(); 
         }
         else {
        	 create.cancelProduct();
        	 System.out.println("Product can not be updated it's already exist.");
         }
	 }

  @DataProvider // details to create products
  public Object[][] dp() {
    return new Object[][] { {"mobile1", "Mob120201", "Best camera, slim, sleak & stylish in design"}, { "mobile2", "Mob120202", "Affordable prices" }
    };
  }
  
  //details to update products
    @DataProvider
    public Object[][] dp1() {
      return new Object[][] { {"mobile3", "Mob120223", "Best camera, slim, sleak & stylish in design"}
      };
  }
    
    //below test case will delete all available products
    @Test(priority=4)
    public void deleteProducts() {
    	if(create.createOneLink().size()>0) {
 		   System.out.println("There are no Products. Please Create Products.");
 		}
 		 else {
 			 String str = create.counOfProducts();
 			 String numberOnly = str.replaceAll("[^0-9]", "");
 			 System.out.println("Total number of product(s) are: "+numberOnly);
 			 
 			 create.tryCheckbox();
 			 create.batchButton();
 			 create.deleteMenuButton();
 			 create.acceptAlert();
 			 String actaulMsg = create.deleteMessage();
 	         String expectedMsg = "Successfully destroyed "+numberOnly+" products";
 	         Assert.assertEquals(actaulMsg, expectedMsg, "Selected product has been updated.");
             System.out.println("Successfully destroyed "+numberOnly+" products");
 		}
    }
}
