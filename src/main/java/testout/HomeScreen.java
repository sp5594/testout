package testout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Mac on 7/6/17.
 */

public class HomeScreen{

    public HomeScreen(WebDriver driver){

        this.driver = driver;
    }

    WebDriver driver;

    By settings_icon = By.id("wpDesktop.DesktopIcon15.Grid.gContent.imImage");


    public void clickonesettingsicon(){

        driver.findElement(settings_icon).click();
    }

}
