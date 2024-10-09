import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class Login extends PageObject{
    @FindBy(id = "username")
    protected WebElement username;

    @FindBy(id = "password")
    protected WebElement password;

    @FindBy(id = "estado")
    protected WebElement state;

    @FindBy(css="button")
    protected WebElement ingresar;
    
    public Login(WebDriver driver) {
        super(driver);
    }
    public void clickIngresar() {
        ingresar.click();
    }
    public void setUsername(String user) {
        username.sendKeys(user);
    }
    public void setPassword(String pass) {
        password.sendKeys(pass);
    }
    public String getStateMessage() {
        return state.getText();
    }

}
