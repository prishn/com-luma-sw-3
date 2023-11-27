package testsuite;
/**
 * userShouldAddProductSuccessFullyToShoppingCart()
 * * Mouse Hover on Men Menu
 * * Mouse Hover on Bottoms
 * * Click on Pants
 * * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on size 32.
 * * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on colour Black.
 * * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on
 * ‘Add To Cart’ Button.
 * * Verify the text
 * ‘You added Cronus Yoga Pant to your shopping cart.’
 * * Click on ‘shopping cart’ Link into message
 * * Verify the text ‘Shopping Cart.’
 * * Verify the product name ‘Cronus Yoga Pant’
 * * Verify the product size ‘32’
 * * Verify the product colour ‘Black’
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        // * * Mouse Hover on Men Menu
        mouseHoverToElement(By.id("ui-id-5"));

        // * * Mouse Hover on Bottoms
        mouseHoverToElement(By.xpath("//a[@id='ui-id-18']"));

        // * * Click on Pants
        clickOnElement(By.xpath("//a[@id='ui-id-23']"));

        // * * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverToElement(By.xpath("//strong[@class='product name product-item-name']"));
        clickOnElement(By.id("option-label-size-143-item-175"));

        // * * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        mouseHoverToElement(By.xpath("//strong[@class='product name product-item-name']"));
        clickOnElement(By.id("option-label-color-93-item-49"));

        // * * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHoverToElement(By.xpath("//strong[@class='product name product-item-name']"));
        clickOnElement(By.xpath("//button[@title = 'Add to Cart']"));
        Thread.sleep(2000);

        // * * Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        assertEqualsMethod("Incorrect Message", "You added Cronus Yoga Pant to your shopping cart.",
                By.xpath("//div[@class ='message-success success message']"));
        Thread.sleep(2000);

        // * * Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[text() = 'shopping cart']"));

        // * * Verify the text ‘Shopping Cart.’
        assertEqualsMethod("Wrong message displayed", "Shopping Cart", By.xpath("//span[@data-ui-id ='page-title-wrapper']"));

        // * * Verify the product name ‘Cronus Yoga Pant’
        assertEqualsMethod("Incorrect product name", "Cronus Yoga Pant",
                By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));

        // * * Verify the product size ‘32’
        assertEqualsMethod("Incorrect product size", "32", By.xpath("//dd[contains(text(),'32')]"));

        // * * Verify the product colour ‘Black’
        assertEqualsMethod("Incorrect product colour", "Black", By.xpath("//dd[contains(text(),'Black')]"));

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
