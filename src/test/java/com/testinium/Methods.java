package com.testinium;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Methods {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor jse;

    public  Methods(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        jse = (JavascriptExecutor) driver;
    }
    public String getTitle(){
        return driver.getTitle();
    }
    public WebElement findElement(By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }
    public void sendKeys(By by,String string){
        findElement(by).clear();;
        WebElement element = findElement(by);
        element.sendKeys(string);
    }
    public List<WebElement> findElements(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElements(by);
    }
    public void click(By by){
        WebElement webElement = findElement(by);
        webElement.click();;
    }
    public void moveToElementHover(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).perform();
    }
    public String getText(By by) { return  findElement(by).getText();}
}



