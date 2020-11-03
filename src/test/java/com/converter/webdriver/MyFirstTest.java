package com.converter.webdriver;

import javafx.scene.chart.Chart;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyFirstTest {

    private WebDriver driver;

    @Before
    public void init() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        this.driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("http://localhost:63342/VVS_PROJECT/index/index.html");
        Thread.sleep(2000);
    }

    @Test

    public void startWebDriver() throws InterruptedException {

        Assert.assertTrue("title should start differently",
                this.driver.getTitle().startsWith("Convertor"));

        driver.close();
    }

    @Test

    public void inputVerification() throws InterruptedException {

        WebElement amount = this.driver.findElement(By.id("amount"));
        WebElement currency = this.driver.findElement(By.id("rate"));
        WebElement conv = this.driver.findElement(By.id("conv"));


        amount.sendKeys("10.5");
        Thread.sleep(2000);

        Select sel1 = new Select(this.driver.findElement(By.id("rate")));
        sel1.selectByValue("4.1781");



        Assert.assertEquals("NU-i corect", conv.getText(), "43.87");

        driver.close();
    }

    @Test
    public void fieldsVerification() throws InterruptedException {
        Assert.assertTrue("Nu exista campul label 1",driver.findElements( By.id("label1") ).size() != 0);
        Assert.assertTrue("Nu exista campul pentru suma",driver.findElements( By.id("amount") ).size() != 0);
        Assert.assertTrue("Nu exista option box pentru valuta",driver.findElements( By.id("rate") ).size() != 0);
        Assert.assertTrue("Nu exista campul pentru suma convertita",driver.findElements( By.id("conv") ).size() != 0);

        driver.close();
    }



}
