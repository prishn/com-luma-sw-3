package testsuite;
/**
 * Write down the following test into WomenTestclass
 * 1. verifyTheSortByProductNameFilter
 * * Mouse Hover on Women Menu
 * * Mouse Hover on Tops
 * * Click on Jackets
 * * Select Sort By filter “Product Name”
 * * Verify the products name display in alphabetical order
 * 2. verifyTheSortByPriceFilter
 * * Mouse Hover on Women Menu
 * * Mouse Hover on Tops
 * * Click on Jackets
 * * Select Sort By filter “Price”
 * * Verify the products price display in
 * Low to High
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

import static java.lang.Thread.*;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        // * * Mouse Hover on Women Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));
        sleep(2000);

        // * * Mouse Hover on Tops
        mouseHoverToElement(By.id("ui-id-9"));
        sleep(2000);

        // * * Click on Jackets
        clickOnElement(By.id("ui-id-11"));
        sleep(2000);

        // * * Select Sort By filter “Product Name”
        selectByVisibleFromDropDown(By.id("sorter"), "Product Name ");
        sleep(2000);

        // * * Verify the products name display in alphabetical order
        List<WebElement> element1 = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        for (WebElement result : element1) {
            System.out.println(result.getText());
        }
    }

    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        // * * Mouse Hover on Women Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));
        Thread.sleep(2000);

        // * * Mouse Hover on Tops
        mouseHoverToElement(By.id("ui-id-9"));
        sleep(2000);

        // * * Click on Jackets
        clickOnElement(By.id("ui-id-11"));
        sleep(2000);

        // * * Select Sort By filter “Price”
        selectByVisibleFromDropDown(By.id("sorter"), "Price");
        sleep(2000);

        // * * Verify the products price display in Low to High
        List<WebElement> element1 = driver.findElements(By.xpath("//span[@class ='price-wrapper ']"));
        for (WebElement result : element1) {
            System.out.println(result.getText());
        }
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

