package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * userShouldAddProductSuccessFullyToShoppinCart()
 * * Mouse Hover on Gear Menu
 * * Click on Bags
 * * Click on Product Name ‘Overnight Duffle’
 * * Verify the text ‘Overnight Duffle’
 * * Change Qty 3
 * * Click on ‘Add to Cart’ Button.
 * * Verify the text ‘You added Overnight Duffle to your shopping cart.’
 * * Click on ‘shopping cart’ Link into message
 * * Verify the product name ‘Cronus Yoga Pant’
 * * Verify the Qty is ‘3’
 * * Verify the product price ‘$135.00’
 * * Change Qty to ‘5’
 * * Click on ‘Update Shopping Cart’ button
 * * Verify the product price ‘$225.00’
 */
public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        // * * Mouse Hover on Gear Menu
        mouseHoverToElement(By.id("ui-id-6"));

        // * * Click on Bags
        clickOnElement(By.id("ui-id-25"));

        // * * Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));

        // * * Verify the text ‘Overnight Duffle’
        assertEqualsMethod("Incorrect text", "Overnight Duffle", By.xpath("//span[@class='base']"));

        // * * Change Qty 3
        clearTextField(By.id("qty"));
        sendTextToElement(By.id("qty"), "3");
        Thread.sleep(2000);

        // * * Click on ‘Add to Cart’ Button.
        clickOnElement(By.id("product-addtocart-button"));

        // * * Verify the text ‘You added Overnight Duffle to your shopping cart.’
        assertEqualsMethod("Incorrect Message displayed", "You added Overnight Duffle to your shopping cart.",
                By.xpath("//div[@data-bind = 'html: $parent.prepareMessageForHtml(message.text)']"));
        Thread.sleep(2000);

        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[text() = 'shopping cart']"));

        // * * Verify the product name ‘Overnight Duffle’
        assertEqualsMethod("Incorrect product name", "Overnight Duffle",
                By.xpath("//td[@class ='col item']/descendant::a[2]"));
        Thread.sleep(2000);


        // * * Verify the Qty is ‘3’
        assertEqualsMethod("Wrong quantity", "3", By.xpath("//span[@class='counter-number']"));
        Thread.sleep(2000);


        // * * Verify the product price ‘$135.00’
        assertEqualsMethod("Incorrect product price", "$135.00",
                By.xpath("//td[@class='col subtotal']//descendant::span[contains(text(),'$135.00')]"));
        Thread.sleep(2000);

        // * * Change Qty to ‘5’
        clearTextField(By.xpath("//td[@class ='col qty']/child::div[1]/descendant::input"));
        sendTextToElement(By.xpath("//td[@class ='col qty']/child::div[1]/descendant::input"), "5");
        Thread.sleep(2000);

        // * * Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//button[@title ='Update Shopping Cart']"));
        Thread.sleep(2000);

        // * * Verify the product price ‘$225.00’
        assertEqualsMethod("Incorrect product price", "$225.00",
                By.xpath("//span[contains(text(), '$225.00')]"));
        Thread.sleep(2000);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
