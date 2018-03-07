package com.disney.auto.gearbest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;
import com.testautomationguru.ocular.snapshot.Snap;

@Snap("HomePage.png")
public class HomePage {
    WebDriver driver;

    WebElement menu = driver.findElement(By.className("nav_list"));

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage go() {
        driver.get("https://www.gearbest.com/");
        return this;
    }

    public WebElement getMenu() {
        return menu;
    }

    public OcularResult compare() {
        return Ocular
                .snapshot()
                .from(this)
                .sample()
                .using(driver)
                .compare();
    }

    public OcularResult compareSimilar() {
        return Ocular
                .snapshot()
                .from(this)
                .sample()
                .using(driver)
                .similarity(85)
                .compare();
    }

    public OcularResult compareMenu() {
        return Ocular
                .snapshot()
                .from(this)
                .sample()
                .using(driver)
                .element(menu)
                .compare();
    }

}
