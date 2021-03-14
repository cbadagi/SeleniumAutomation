package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver)
    {
        super(driver);
    }
    //search locators

    @FindBy(xpath = "//input[@type='submit']")
    WebElement serachButton;
    @FindBys(@FindBy(css ="div[class='panel panel-default']"))
    List<WebElement> searchResultItem;
    @FindBy(css ="#keywords")
    WebElement search;
    @FindBy(css ="#quantity")
    WebElement quantity;
    @FindBy(css ="#add-to-cart-button")
    WebElement addToCartButton;

    //filter locators

    @FindBy(css ="ul[class=list-group]")
    WebElement PriceRangeSelection;
    @FindBy(css =".btn-primary")
    WebElement searchFilter;
    @FindBy(id = "products")
    List<WebElement> products;
    //order locators
    @FindBy(css ="#summary-order-total")
    WebElement summaryOrderTotal;
    @FindBy(id="checkout-link")
    WebElement checkOut;
    @FindBy(css =".glyphicon.glyphicon-minus-sign") WebElement deleteProductFromCart;
    @FindBy(css=".alert.alert-info")WebElement cartIsEmptyMsg;
    @FindBy(css="a[class='cart-info full']") WebElement cartLink;
    @FindBy(name="commit")WebElement emptyCartBtn;


    public void searchTheItems(String searchItem) {
        search.clear();
        search.sendKeys(searchItem);
        serachButton.click();
    }

    public boolean areSearchResultsValid(String searchPhrase) {
        for (WebElement result : searchResultItem) {
            String productInfo = result.getText();
            if (!productInfo.contains(searchPhrase))
                return false;
        }
        return true;
    }

    public void selectCategory(String categorySearchText) {
        WebElement categoryName = driver.findElement(By.linkText(categorySearchText));
        categoryName.click();
        By activeCategory = By.cssSelector(".list-group-item.active");
        waitForPageToLoad(activeCategory);
    }

    public void filterUsingPriceRange(String priceRange) {
        //
        String priceRangeCriteria = "Price_Range_" + priceRange.replace(" ", "_");
        System.out.println(priceRangeCriteria);
        PriceRangeSelection.findElement(By.id(priceRangeCriteria)).click();
        searchFilter.click();
    }

    public boolean areProductDisplayedInRange(double min, double max) {
        for (WebElement ListOfProduct : products) {
            WebElement productPriceElement = ListOfProduct.findElement(By.className("price"));
            String productPrice = productPriceElement.getText().trim().replace("$", " ");
            System.out.println(productPrice);
            double price = Double.parseDouble(productPrice);
            if (!(price >= min && price <= max))
                return false;
        }
        return true;

    }

    public void addProductToCart(String NameOfTheProduct, String quanityOfTheProduct) {
        waitForPageToLoad(By.cssSelector("#keywords"));
        search.sendKeys(NameOfTheProduct);
        serachButton.click();
        driver.findElement(By.cssSelector("img[alt='" + NameOfTheProduct + "']")).click();
        quantity.clear();
        quantity.sendKeys(quanityOfTheProduct);
        addToCartButton.click();

    }

    public boolean isOrderSummaryTotalCorrect(String expectedOrderTotal)
    {
        checkOut.click();
        String actualSummaryTotal = summaryOrderTotal.getText();
        if (!(actualSummaryTotal.equals(expectedOrderTotal)))
           {
            return false;
           }
        return true;

    }

    public void removeProductFromCart(String productName)
    {
        waitForPageToLoad(By.cssSelector("span[class='glyphicon glyphicon-shopping-cart']"));
        deleteProductFromCart.click();


    }
    public boolean isCartEmpty(String expectedCartEmptyMessage){
        //waitForPageToLoad(By.cssSelector("#alert"));
        String actualCartEmptyMessage=cartIsEmptyMsg.getText();
        if(!(actualCartEmptyMessage.equals(expectedCartEmptyMessage))){
            return false;
        }
        return true;
    }

    public void emptyCart()
    {
        waitForPageToLoad(By.cssSelector("a[class='cart-info full']"));
            cartLink.click();
            emptyCartBtn.click();
        }

    }

