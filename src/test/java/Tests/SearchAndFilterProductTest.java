package Tests;

import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Tests.SpreeListener.class)
public class SearchAndFilterProductTest extends Driver
{
    //Data driven
    @DataProvider(name = "test2")
    public Object[][] SearchData() {return new Object[][]{
            {"Bags","$10.00 - $15.00"},{"Mugs","$18.00 - $20.00"}}; }
    @Test (dataProvider = "test2")
    public void FilterProducts(String category,String price){
        HomePage homePage=new HomePage(driver);
        homePage.selectCategory(category);
        homePage.filterUsingPriceRange(price);
        Assert.assertTrue(homePage.areProductDisplayedInRange(10.00,20.00));
        System.out.println("end");
    }
}

