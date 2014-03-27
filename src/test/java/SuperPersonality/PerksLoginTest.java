package SuperPersonality;

import Various.SignUpPageAllFields;
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

   /* @Test
    @Source ("C:\\\\Users\\\\Alex\\\\Desktop\\\\personalityperks.xls")
    public void TestDataLogin(String email, String password){
        LoginBase loginbase = LoginBase.navigateTo(driver);
        PersonalityPerks pp = loginbase.login(email, password);
    }  */

    @Test
    @Source ("C:\\\\Users\\\\Alex\\\\Desktop\\\\perksfull.xls")
    public void TestSignUp(String firstname, String lastname, String mailingaddress, String bedtype){
        SignUpPageAllFields signup = SignUpPageAllFields.navigateTo(driver);
        signup.enterFirstName(firstname);
        signup.enterLastName(lastname);
        signup.selectMailingOption(mailingaddress);
        signup.specialAccessNone();
        signup.selectBedType(bedtype);

    }
    @After
    public void tearDown() throws Exception {
        driver.quit();

    }
}
