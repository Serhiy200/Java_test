package ua.shoptool;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class MyTest extends WebdriverSettings {

    @Test
    public void SaleForThreeProducts() throws InterruptedException {
        driver.get("https://shoptool.com.ua/");
        driver.findElement(By.cssSelector("[href=\"https://shoptool.com.ua/index.php?dispatch=products.on_sale\"]")).click();

        for (int i = 0; i < 3; i++) {

            List<WebElement> mylist = driver.findElements(By.cssSelector(".ty-column3"));

            for (int k = 0; k < 3; k++) {

                int n = count(mylist.size());

                TimeUnit.MILLISECONDS.sleep(5000);

                try {

                    WebElement list = mylist.get(n);

                    new WebDriverWait(driver, 10000).until(ExpectedConditions.elementToBeClickable(list));
                    list.click();

                } catch (org.openqa.selenium.StaleElementReferenceException ex) {

                    List<WebElement> list = driver.findElements(By.cssSelector(".ty-column3"));
                    list.get(n).click();

                }

                driver.findElement(By.cssSelector("[class=\"prices-container price-wrap\"] div[class=\"ty-product-prices\"] span span span[class=\"ty-strike\"]")).isDisplayed();
                driver.findElement(By.cssSelector(".ut2-pb__price-actual")).isDisplayed();

                driver.navigate().back();

            }

            TimeUnit.MILLISECONDS.sleep(5000);

            driver.findElement(By.cssSelector(".ty-pagination__item.ty-pagination__btn.ty-pagination__next.cm-history.cm-ajax.ty-pagination__right-arrow")).click();

            mylist.clear();

        }
    }

    @Test
    public void Drile() throws InterruptedException {

        driver.get("https://shoptool.com.ua/");
        driver.findElement(By.cssSelector(".ty-menu__item.cm-menu-item-responsive.first-lvl.ty-menu-item__sport ")).click();

        new WebDriverWait(driver, 5000).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\"Дрели\"]")));
        driver.findElement(By.xpath("//a[text()=\"Дрели\"]")).click();

        for (int i = 0; i < 3; i++) {

            List<WebElement> mylist = driver.findElements(By.cssSelector(".ty-column3"));

            int n = count(mylist.size());

            TimeUnit.MILLISECONDS.sleep(5000);
            try {

                WebElement list = mylist.get(n);
                list.click();

            } catch (org.openqa.selenium.StaleElementReferenceException ex) {

                List<WebElement> list = driver.findElements(By.cssSelector(".ty-column3"));
                list.get(n).click();

            }

            driver.findElement(By.cssSelector("[class=\"ut2-pb__button ty-product-block__button\"] button")).click();

            new WebDriverWait(driver, 7000).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ty-btn.ty-btn__secondary.cm-notification-close")));

            driver.navigate().back();

            driver.findElement(By.cssSelector(".ty-pagination__item.ty-pagination__btn.ty-pagination__next.cm-history.cm-ajax.ty-pagination__right-arrow")).click();
            mylist.clear();
        }

        driver.findElement(By.id("sw_dropdown_3312")).click();
        driver.findElement(By.xpath("//a[text()=\"Редактировать заказ\"]")).click();

        WebElement price = driver.findElement(By.id("sec_cart_total"));

        double totalPrice = Double.parseDouble(price.getText().replace(",", ""));
        System.out.println(totalPrice);

        List<WebElement> priceList = driver.findElements(By.cssSelector(".ty-delete-big__icon.ty-icon-cancel-circle"));
        priceList.get(count(priceList.size())).click();

        TimeUnit.MILLISECONDS.sleep(5000);
        price = driver.findElement(By.id("sec_cart_total"));

        double totalPrice2 = Double.parseDouble(price.getText().replace(",", ""));
        System.out.println(totalPrice2);

        assertTrue(totalPrice != totalPrice2);
    }

    @Test
    public void Perforatory() throws InterruptedException {
        driver.get("https://shoptool.com.ua/");
        driver.findElement(By.cssSelector(".ty-menu__item.cm-menu-item-responsive.first-lvl.ty-menu-item__sport ")).click();

        new WebDriverWait(driver, 5000).until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div[4]/div/div[2]/a")));
        driver.findElement(By.xpath("//div/div[4]/div/div[2]/a")).click();

        List<WebElement> mylist = driver.findElements(By.cssSelector("[title=\"PROCRAFT\"]"));

        for (int k = 0; k < mylist.size(); k++) {
            try {

                WebElement list = mylist.get(k);
                new WebDriverWait(driver, 5000).until(ExpectedConditions.elementToBeClickable(list));
                list.click();

            } catch (org.openqa.selenium.StaleElementReferenceException ex) {

                List<WebElement> list = driver.findElements(By.cssSelector("[title=\"PROCRAFT\"]"));
                list.get(k).click();

            }

            TimeUnit.MILLISECONDS.sleep(5000);

            String nameProduct = driver.findElement(By.cssSelector("[class=\"ut2-pb__title\"] bdi")).getText();
            System.out.println(nameProduct);

            assertTrue(nameProduct.contains("PROCRAFT"));
            driver.findElement(By.cssSelector(".ut2-pb__price-actual")).isDisplayed();

            driver.navigate().back();
        }

        mylist.clear();

        TimeUnit.MILLISECONDS.sleep(5000);
        driver.findElement(By.cssSelector(".ty-pagination__item.ty-pagination__btn.ty-pagination__next.cm-history.cm-ajax.ty-pagination__right-arrow")).click();
    }


    @Test
    public void Sale() throws InterruptedException {
        driver.get("https://shoptool.com.ua/");
        driver.findElement(By.cssSelector("[href=\"https://shoptool.com.ua/index.php?dispatch=products.on_sale\"]")).click();

        for (int i = 0; i < 5; i++) {

            List<WebElement> mylist = driver.findElements(By.cssSelector(".ty-column3"));

            int n = count(mylist.size());

            TimeUnit.MILLISECONDS.sleep(5000);
            try {

                WebElement list = mylist.get(n);
                list.click();

            } catch (StaleElementReferenceException ex) {

                List<WebElement> list = driver.findElements(By.cssSelector(".ty-column3"));
                list.get(n).click();

            }

            WebElement sale = driver.findElement(By.cssSelector(" div[class=\"ab-vg-product_labels\"] div div[class=\"ty-product-labels__item   ty-product-labels__item--discount\"] [class=\"ty-product-labels__content\"] em"));
            WebElement price = driver.findElement(By.xpath("//div/div/div/div/span/span/span/bdi/span"));
            WebElement fds = driver.findElement(By.xpath("//div/div/div/div/div/span/span/bdi/span[1]"));

            double doublePrice = Double.parseDouble(price.getText().replace(",", ""));
            double doubleSale = Integer.parseInt(sale.getText().replace("%", ""));
            double salePrice = doublePrice - doublePrice * (doubleSale / 100);
            double expect = Double.parseDouble(fds.getText().replace(",", ""));

            System.out.println(doublePrice);
            System.out.println(doubleSale);
            System.out.println(salePrice);

            Assert.assertNotEquals(driver.findElement(By.cssSelector("[class=\"ut2-pb__title\"] bdi")).getText(), salePrice, expect);
            driver.navigate().back();
        }
    }
}
