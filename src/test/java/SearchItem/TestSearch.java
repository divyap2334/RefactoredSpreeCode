package SearchItem;

import TestLogin.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Body;

public class TestSearch extends BaseSetup {


    @Test
    public void testSearch() {

        Body body = new Body(driver);
        body.searchForItem("Shirt");
        String selectedItem = body.selectDesiredItem();
        body.addItemToCart();
        String itemInCart = body.checkCart();
        Assert.assertEquals(itemInCart, selectedItem);
    }

}
