package testout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Mac on 2/27/19.
 */
public class Wifi {

    WebDriver driver;

    By corpnet_wifi = By.id("SettingsItemNetwork");
    By password_field = By.id("psbx");
    By join_button = By.id("btnJoin");
    By checkbutton = By.id("lbConnected.Grid.Border.ScrollViewer.Grid.Viewport.ScrollContentPresenter.OuterElement.InnerElement.ItemsPresenter.StackPanel.SettingsItemNetwork.Grid.imCheck");


    public Wifi(WebDriver driver){

        this.driver = driver;
    }

    public void clickoncorpnetwifi(){

        driver.findElement(corpnet_wifi).click();
    }

    public void enterpassword(String pw){

        driver.findElement(password_field).sendKeys(pw);

    }

    public void clickonjoinbutton() {

        driver.findElement(join_button).click();

    }
}



