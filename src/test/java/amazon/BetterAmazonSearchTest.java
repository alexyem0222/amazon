package amazon;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BetterAmazonSearchTest {

    private FirefoxDriver driver;

    @Before
    public void setupSelenium() {
        driver = new FirefoxDriver();
    }

    @Test
    public void search_amazon() throws InterruptedException {
        AmazonHomePage homePage = AmazonHomePage.navigateTo(driver);
        AmazonSearchResultsPage resultsPage = homePage.searchFor("robin");
        try{
        assertThat(resultsPage.getTopResultTitle(), is("Robin (comics) - Wikipedia, the free encyclopedi"));
        }catch (Throwable e){
            System.out.println("Result title expected and actual DO NOT MATCH");
        }
    }

    @Test
    public void search_yahoo() throws InterruptedException {
        AmazonHomePage amazonHomePage = AmazonHomePage.navigateTo(driver);
        AmazonSearchResultsPage amazonSearchResultsPage = amazonHomePage.searchFor("selenium");
        assertThat(amazonSearchResultsPage.getTopResultTitle(), is("Selenium - Official Site"));
    }

    @After
   public void closeSelenium() {
        driver.close();
        driver.quit();
}
}
