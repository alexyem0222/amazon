package Various;

import org.databene.benerator.anno.Database;
import org.databene.benerator.anno.Source;
import org.databene.feed4junit.Feeder;
import org.databene.platform.db.DBSystem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;


@RunWith(Feeder.class)
@Database(id = "db", url = "jdbc:mysql://localhost:3306/sakila",
        driver = "com.mysql.jdbc.Driver", user = "root", password = "odessa")
public class DBConnectionTry {
    private SignUpPageRequiredFields page;
    private FirefoxDriver driver;
    static DBSystem db;

    @Before
    public void setupSelenium() {
        page = PageFactory.initElements(new FirefoxDriver(), SignUpPageRequiredFields.class);
        page.open("http://www.personalityperks.com");
    }

    @Test
    @Source(id= "db", selector = "select staff.first_name, staff.last_name, address.address from staff inner join address on staff.address_id = address.address_id where staff.staff_id = '3'")
    public void testInnerjoin(String firstname, String lastname, String address)   {
        page.enterFirstName(firstname);
        page.enterLastName(lastname);
        page.enterAddress(address);
    }

    @After
    public void tearDown() throws Exception {
        page.close();
}
}


