package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomeTest extends Driver
{


    //Data driven
    @DataProvider(name = "test1")
    public Object[][] SearchData() {return new Object[][]{{"Ruby"},{"Apache"}}; }

    @Test(dataProvider = "test1")
    public void VerifyTheSearchResult(String test1) throws InterruptedException
   {
      HomePage homePage = new HomePage(driver);
       homePage.searchTheItems(test1);
        Assert.assertTrue(homePage.areSearchResultsValid(test1));
   }

    @Test
    public void VerifyTheAddItemAndClearCart() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("ext-chitra.badagi@thoughtworks.com","Welcome@2021");
        homePage.addProductToCart( "Ruby on Rails Mug","3");
        homePage.removeProductFromCart("Ruby on Rails Mug");
        homePage.isCartEmpty("Your cart is empty");


    }


}
