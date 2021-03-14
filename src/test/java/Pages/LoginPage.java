package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage
{
     public WebDriver driver;

    @FindBy(id="link-to-login") WebElement LoginBtn;
    @FindBy(id="spree_user_email") WebElement Email;
    @FindBy(id="spree_user_password") WebElement Pswd;
    @FindBy(name="commit") WebElement Submit;
    @FindBy(className = "alert") WebElement Loginmsgclass;
    @FindBy(linkText = "Logout")WebElement Logout;
    @FindBy(className = "alert") WebElement LogoutMSG;
    @FindBy(xpath = "//*[text()='Ruby on Rails Mug']") WebElement RubyOnRailitem;


    //locators for adding items in the cart
    @FindBy(css="[id*='product']") WebElement Seachlist;

    public  LoginPage (WebDriver driver)
    {
        super(driver);
    }
    public String  GetTextSuccessMsg()
    {
       String Loginmsg =Loginmsgclass.getText();
       return Loginmsg;
    }
    public String GetTextLogoutMsg()
    {
        String Logoutmsg=LogoutMSG.getText();
        return Logoutmsg;
    }

    public void login(String Username,String pwd)
    {
        LoginBtn.click();
        Email.sendKeys(Username);
        Pswd.sendKeys(pwd);
        Submit.click();

    }
    public void Logout()
    {
        Logout.click();

    }

    }



