package SuperPersonality;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.databene.benerator.anno.Source;
import org.databene.feed4junit.Feeder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Feeder.class)
public class PerksLoginTest {

   private FirefoxDriver driver;

    @Before
    public void setupSelenium() {
       driver = new FirefoxDriver();
   }

    @Test
    @Source ("C:\\\\Users\\\\Alex\\\\Desktop\\\\personalityperks.xls")
    public void TestDataLogin(String email, String password){
        LoginBase loginbase = LoginBase.navigateTo(driver);
        PersonalityPerks pp = loginbase.login(email, password);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();

    }
}
