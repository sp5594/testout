package testout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Mac on 2/27/19.
 */
public class MailContactsCalendar {


        WebDriver driver;

        By maggie_brown_contact = By.id("lbAccounts.Grid.Border.ScrollViewer.Grid.Viewport.ScrollContentPresenter.OuterElement.InnerElement.ItemsPresenter.StackPanel.SettingsItemSubMenu");
        By email = By.xpath("//*[contains(text(), 'Account')]");
        By advanced_button = By.id("siAdvanced");
        By ssl_switch = By.id("siUseSSL.Grid.tbOnOff.Grid.SwitchRoot.Canvas.SwitchTrack.StackPanel.Border1");
        By port_number = By.id("tbServerPort");
        By account_button = By.id("btnAccount.grid.contentPresenter.TextBlock");
        By done_button = By.id("btnDone.grid.contentPresenter.TextBlock");

    public MailContactsCalendar(WebDriver driver){

        this.driver = driver;
    }

    public void clickonmaggiebrown(){

        driver.findElement(maggie_brown_contact).click();
    }

    public void clickonemail(){

        driver.findElement(email).click();
    }

    public void clickonadvancedbutton(){

        driver.findElement(advanced_button).click();
    }

    public void turnonssl(){

        driver.findElement(ssl_switch).click();

    }


    public void clickonaccountbutton(){

        driver.findElement(account_button).click();
    }

    public void clickondonebutton(){

        driver.findElement(done_button).click();
    }

}





