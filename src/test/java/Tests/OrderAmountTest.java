package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Tests.SpreeListener.class)
public class OrderAmountTest extends Driver{

    @Test
    public void VerifyTheOrderAmount() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("ext-chitra.badagi@thoughtworks.com","Welcome@2021");
       // homePage.emptyCart();
        homePage.addProductToCart( "Ruby on Rails Mug","1");
        homePage.isOrderSummaryTotalCorrect("13.99");
        loginPage.Logout();

    }
}
