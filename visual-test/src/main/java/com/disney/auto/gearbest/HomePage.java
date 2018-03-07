package com.disney.auto.gearbest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;
import com.testautomationguru.ocular.snapshot.Snap;

@Snap("HomePage-#{OPT}.png")
public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage go() {
        driver.get("https://www.gearbest.com/");
        driver.findElement(By.id("close")).click();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public WebElement getSearch() {
        return driver.findElement(By.cssSelector("form[name='searchFrom']"));
    }

    public OcularResult compare() {
        return Ocular
                .snapshot()
                .from(this)
                .replaceAttribute("OPT", "compare")
                .sample()
                .using(driver)
                .compare();
    }

    public OcularResult compareSimilar() {
        return Ocular
                .snapshot()
                .from(this)
                .replaceAttribute("OPT", "similarity")
                .sample()
                .using(driver)
                .similarity(85)
                .compare();
    }

    public OcularResult compareMenu() {
        return Ocular
                .snapshot()
                .from(this)
                .replaceAttribute("OPT", "menu")
                .sample()
                .using(driver)
                .element(getSearch())
                .compare();
    }

}
