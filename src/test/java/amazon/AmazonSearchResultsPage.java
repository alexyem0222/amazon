package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonSearchResultsPage {

    private WebDriver driver;

    //@FindBy(css="#result_0.fstRow h3.newaps a")
    @FindBy(xpath="/html/body/div[2]/div[3]/div/div/div[2]/div[4]/div[2]/div[3]/h3/a")
    private WebElement topResultTitle;

    public AmazonSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTopResultTitle() throws InterruptedException {
        Thread.sleep(2000);
        return topResultTitle.getText();
    }

}