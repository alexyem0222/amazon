package amazon;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonalityMobileTry {

    private WebDriver driver;

    @Before
    public void setupSelenium() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.android();
        caps.setCapability("platform", "Linux");
        caps.setCapability("version", "4.4");
        caps.setCapability("device-orientation", "portrait");
        driver = new RemoteWebDriver(
                new URL("http://alex_yem22:e8760d07-6354-4530-b74f-c91e9556f7f6@ondemand.saucelabs.com:80/wd/hub"),
                caps);

    }

    @Test
    public void personalityTry() throws InterruptedException {
        driver.navigate().to("http://mobile.personalityhotels.com");
        WebElement getPerksButton = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[1]/div/div[2]/div[1]/a/div/div"));
        getPerksButton.click();
    }


    @After

    public void printSessionId() {
        String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s",
                (((RemoteWebDriver) driver).getSessionId()).toString(), "PersonalityMobileTest");
        System.out.println(message);
        driver.close();
        driver.quit();
    }
}

