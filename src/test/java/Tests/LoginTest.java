package Tests;

import Pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Tests.SpreeListener.class)
public class LoginTest extends Driver
{
    LoginPage loginPage;

    @Test
    public void VerifyLogin() throws InterruptedException
    {
        loginPage=new LoginPage(driver);
        loginPage.login("ext-chitra.badagi@thoughtworks.com","Welcome@2021");
        Assert.assertEquals(loginPage.GetTextSuccessMsg(),"Logged in successfully");
        Thread.sleep(500);
    }
    @Test
    public void VerifyLogout()
    {
        loginPage.Logout();
        Assert.assertEquals(loginPage.GetTextLogoutMsg(),"Signed out successfully.");
    }
}
