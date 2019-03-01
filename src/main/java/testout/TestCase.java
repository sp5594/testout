package testout;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;



/**
 * Created by shail on 1/19/2017.
 */
public class TestCase extends TestVariables {

    WebDriver driver = null;
    WebDriverWait wait;


    @BeforeTest(alwaysRun = true)
    public void setup(){

        try {


            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));


            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get("http://testoutlivecontent.blob.core.windows.net/netpro2018v5-en-us/en-us/sims/typescriptv1/netpro2018v5/simstartup_webpack.html?package=netpro2018v5windowspackage&sim=ipademail_np5&dev=true&automation=true");


            wait = new WebDriverWait(driver, 10); //waits for 10 secs

            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        try {

            wait.until(ExpectedConditions.elementToBeClickable(By.id("HorizontalTrackLargeChangeDecreaseRepeatButton")));

            driver.findElement(By.id("HorizontalTrackLargeChangeDecreaseRepeatButton")).click();

//            driver.findElement(By.xpath("//*[@id=\"tbText\"]/div/b[2]")).click();

            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    /**
     * <----------------------------------------------------------------------->
     * <--------------------------TEST CASE METHODS---------------------------->
     * <----------------------------------------------------------------------->
     */

    @Test(priority = 1, groups = {"SmokeTest"})
    public void setemail(){

        HomeScreen home = new HomeScreen(driver);

        wait.until(ExpectedConditions.elementToBeClickable(home.settings_icon));
        home.clickonesettingsicon();

        SettingsScreen settings = new SettingsScreen(driver);
        wait.until(ExpectedConditions.elementToBeClickable(settings.mailcontactscalendars_option));
        settings.clickomailcontactscalendaroption();

        MailContactsCalendar user = new MailContactsCalendar(driver);
        wait.until(ExpectedConditions.elementToBeClickable(user.maggie_brown_contact));
        user.clickonmaggiebrown();

        wait.until(ExpectedConditions.elementToBeClickable(user.email));
        user.clickonemail();

        wait.until(ExpectedConditions.elementToBeClickable(user.advanced_button));
        user.clickonadvancedbutton();

        wait.until(ExpectedConditions.elementToBeClickable(user.ssl_switch));
        user.turnonssl();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.id("hcHeaderedContentControl.Grid.svScrollViewer.Grid.Viewport.ScrollContentPresenter"));
        js.executeScript("arguments[0].setAttribute('style', 'transform: translate(0px, -200px);')",element);

        wait.until(ExpectedConditions.elementToBeClickable(user.port_number));
        String port = driver.findElement(By.id("tbServerPort")).getAttribute("value");
        System.out.println("thenumberis: " + port);
        Assert.assertEquals("993", port);

        wait.until(ExpectedConditions.elementToBeClickable(user.account_button));
        user.clickonaccountbutton();

        wait.until(ExpectedConditions.elementToBeClickable(user.done_button));
        user.clickondonebutton();





    }

    @Test(priority = 2, groups = {"SmokeTest"})
    public void connectowifi() {

        SettingsScreen settings = new SettingsScreen(driver);
        wait.until(ExpectedConditions.elementToBeClickable(settings.wifi_option));
        settings.clickonewifioption();

        Wifi wifi = new Wifi(driver);
        wait.until(ExpectedConditions.elementToBeClickable(wifi.corpnet_wifi));
        wifi.clickoncorpnetwifi();

        wait.until(ExpectedConditions.elementToBeClickable(wifi.password_field));
        wifi.enterpassword(password);

        wait.until(ExpectedConditions.elementToBeClickable(wifi.join_button));
        wifi.clickonjoinbutton();

        wait.until(ExpectedConditions.elementToBeClickable(wifi.corpnet_wifi));

        WebElement checkbtn = driver.findElement(wifi.checkbutton);
        Assert.assertEquals(true, checkbtn.isDisplayed());

    }

    @AfterTest
    public void close(){

        driver.close();

    }



}
