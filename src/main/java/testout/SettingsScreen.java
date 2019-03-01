package testout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Mac on 2/27/19.
 */
public class SettingsScreen {

    WebDriver driver;

    By wifi_option = By.id("siWiFi");
    By mailcontactscalendars_option = By.id("siMailContactsCalendars");



    public SettingsScreen(WebDriver driver){

        this.driver = driver;
    }

    public void clickonewifioption(){

        driver.findElement(wifi_option).click();
    }

    public void clickomailcontactscalendaroption(){

        driver.findElement(mailcontactscalendars_option).click();
    }


}
