package com.disney.auto;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Paths;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.disney.auto.gearbest.HomePage;
import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;

import io.github.bonigarcia.wdm.ChromeDriverManager;

/**
 * @author luis
 */
class VisualTest {
    protected WebDriver driver;

    /**
     * @throws java.lang.Exception
     */
    @BeforeAll
    void setUpBeforeClass() throws Exception {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        Ocular
                .config()
                .resultPath(Paths.get("./target/result"))
                .snapshotPath(Paths.get("./target/snapshot"))
                .globalSimilarity(95)
                .saveSnapshot(true);
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterAll
    void tearDownAfterClass() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void test() {
        HomePage home = new HomePage(driver);
        home.go();
        OcularResult ocularResult = home.compare();
        assertTrue(ocularResult.isEqualsImages());
    }

    @Test
    void testSimilar() {
        HomePage home = new HomePage(driver);
        home.go();
        OcularResult ocularResult = home.compareSimilar();
        System.out.println("Similarity: " + ocularResult.getSimilarity());
    }

    @Test
    void testMenu() {
        HomePage home = new HomePage(driver);
        home.go();
        OcularResult ocularResult = home.compareMenu();
        assertTrue(ocularResult.isEqualsImages());
    }

}
