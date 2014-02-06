package Various;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPageRequiredFields {
    public WebDriver driver;

    @FindBy(name="firstName")
    @CacheLookup
    private WebElement firstNameField;

    @FindBy(name="lastName")
    @CacheLookup
    private WebElement lastNameField;

    //Added city for DBConnection inner join try
    @FindBy(xpath="//*[@id=\"city\"]")
    @CacheLookup
    private WebElement enterCity;

    @FindBy(xpath="//*[@id=\"address\"]")
    private WebElement enterAddress ;

    @FindBy(id="enrollEmail")
    @CacheLookup
    private WebElement enrollEmail;

    @FindBy(id="setpassword")
    @CacheLookup
    private WebElement setPassword;

    @FindBy(id="match-setpassword")
    @CacheLookup
    private WebElement confirmPassword;

    @FindBy(xpath="/html/body/div/div[2]/div/form[2]/fieldset[3]/div/button")
    @CacheLookup
    private WebElement joinButton;

    public SignUpPageRequiredFields(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void close() {
        driver.quit();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName) ;
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName) ;
    }

    public void enterEmail(String email) {
        enrollEmail.sendKeys(email) ;
    }
    //Added city for DBConnection inner join try
    public void enterCity(String city){
       enterCity.sendKeys(city);
    }

    public void enterAddress(String address)  {
        enterAddress.sendKeys(address);
    }

    public void createPassword(String setPassword) {
        this.setPassword.sendKeys(setPassword) ;
    }

    public void confirmCreatedPassword(String validatePassword) {
        confirmPassword.sendKeys(validatePassword) ;
    }

    public void clickJoinNow(){
        joinButton.click() ;
    }
}

