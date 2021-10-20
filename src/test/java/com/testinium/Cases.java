package com.testinium;

import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Cases extends Driver {
    String firstPrice;
    String secPrice;

    private By loginbuttonHover = By.cssSelector("div [class='link account-user']");
    // private By loginbuttonActual = By.cssSelector("div [class='login-button']");
    private By inputEmail = By.id("login-email");
    private By inputPw = By.id("login-password-input");
    private By loginButton = By.cssSelector("button[class='q-primary q-fluid q-button-medium q-button submit']");
    private By verifyLoginProcess = By.cssSelector("div[class='link account-user']");

    private By Male = By.cssSelector("a[href='/butik/liste/2/erkek']");
    private By searchBar = By.cssSelector("input[class='search-box']");
    private By searcButton = By.cssSelector("i[class='search-icon']");
    private By listEleman = By.cssSelector(".p-cart-wrppr");
    private By addFav = By.cssSelector("button[class='fv']");
    private By productAddCart = By.cssSelector("button[class='add-to-basket']");
    private By goToCart = By.cssSelector("i[class='i-bagg initial-icon']");
    private By productPrice =By.cssSelector("div span[class='prc-slg']:nth-of-type(2)");
    private By cartPrice = By.cssSelector("div[class='pb-basket-item-price']");
    private By deleteProduct = By.cssSelector("i[class='i-trash']");
    private By getDeleteProduct2 = By.cssSelector("button[class='ty-font-w-semi-bold ty-button ty-bordered ty-transition ty-input-medium ty-primary']");

    Methods methods = new Methods(driver);
    @Test
    public void test1() throws InterruptedException {
        driver.navigate().to("https://www.trendyol.com/giris?cb=https%3A%2F%2Fwww.trendyol.com%2F");
        // methods.click(loginbuttonHover);
        methods.sendKeys(inputEmail,"unal_ozkul61@msn.com");
        methods.sendKeys(inputPw,"unal05398963235");
        methods.click(loginButton);
        TimeUnit.SECONDS.sleep(3);
    }
    @Test
    public void test2(){
        Assert.assertEquals(methods.getText(verifyLoginProcess),"Hesabım");
    }
    @Test
    public void test3(){
        methods.click(Male);
    }
    @Test
    public void test4(){
        methods.sendKeys(searchBar,"kazak"+ Keys.ENTER);

    }
    @Test
    public void test5(){
        List<WebElement> item = driver.findElements(By.cssSelector(".p-cart-wrppr"));
        item.get(3).click();
    }
    @Test
    public void test6(){
        firstPrice = methods.getText(productPrice);
        methods.click(addFav);
        methods.click(productAddCart);
        methods.click(goToCart);
        secPrice=methods.getText(cartPrice);
        Assert.assertEquals(firstPrice,secPrice);
    }
    @Test
    public void test7() throws InterruptedException {
        methods.click(deleteProduct);
        TimeUnit.SECONDS.sleep(3);
        methods.click(getDeleteProduct2);
    }







}
