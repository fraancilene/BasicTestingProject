package br.cs.fsilva.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
    //private static WebDriver driver;
    private static  ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>(){
       @Override
        protected synchronized WebDriver initialValue(){
            return initDriver();
        }
    };

    private DriverFactory(){}

    public static WebDriver  getDriver(){
        return  threadDriver.get();
    }

    public static WebDriver initDriver(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fran\\Documents\\drivers-navegadores\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Fran\\Documents\\drivers-navegadores\\geckodriver.exe");
        System.setProperty("webdriver.ie.driver", "C:\\Users\\Fran\\Documents\\drivers-navegadores\\IEDriverServer.exe");

        WebDriver driver = null;
        switch (Propriedades.browser){
            case CHROME: driver = new ChromeDriver(); break;
            case FIREFOX: driver = new FirefoxDriver(); break;
            case IE_EXPLORER: driver = new InternetExplorerDriver(); break;
        }
        driver.manage().window().setSize(new Dimension(1200, 765));
        return driver;
    }

    public static void killDriver(){
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        if (threadDriver != null){
            threadDriver.remove();
        }

    }


}