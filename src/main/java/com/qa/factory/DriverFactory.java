package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    //This method is used to initialize the threadlocaldriver basis on given browser
    public WebDriver init_driver(String browser){
        System.out.println("browser value is:"+browser);
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());

        }
        else if (browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        }
        else {
            System.out.println("pleasepass the correct browser value");
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }
    //this is used to get the driver with threadlocal
    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }


}
