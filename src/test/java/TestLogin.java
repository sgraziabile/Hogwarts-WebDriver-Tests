import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin {
    private static WebDriver driver;
    private static final String inicio_url = "https://cs.uns.edu.ar/~mll/temp/testing/examen/inicio.html";
    private static final String login_url = "https://cs.uns.edu.ar/~mll/temp/testing/examen/login.html";
    @BeforeClass
    public static void main() {
        System.setProperty("webdriver.opera.driver", Util.WEB_DRIVER_LOCATION);
        TestLogin.driver = new ChromeDriver();
    }

    @Test
    public void successfulLogin() {
        driver.get(Util.BASE_URL);
        Login login = new Login(driver);
        login.setUsername("dumbridge");
        login.setPassword("tomriddle");
        login.clickIngresar();
        String expectedUrl = inicio_url;
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Test
    public void invalidLogin1() {
        driver.get(Util.BASE_URL);
        Login login = new Login(driver);
        login.setUsername("user");
        login.setPassword("tomriddle");
        login.clickIngresar();
        String expectedState = "Atención: El usuario ingresado no existe";
        String expectedUrl = login_url;
        assertEquals(expectedState, login.getStateMessage());
        assertEquals(expectedUrl, driver.getCurrentUrl());
        
    }
    @Test
    public void invalidLogin2() {
        driver.get(Util.BASE_URL);
        Login login = new Login(driver);
        login.setUsername("");
        login.setPassword("tomriddle");
        login.clickIngresar();
        String expectedUrl = login_url;
        String expectedState = "Atención: Debe ingresar un nombre de usuario";
        assertEquals(expectedState, login.getStateMessage());
        assertEquals(expectedUrl, driver.getCurrentUrl());
        
    }
    @Test
    public void invalidLogin3() {
        driver.get(Util.BASE_URL);
        Login login = new Login(driver);
        login.setUsername("dumbridge");
        login.setPassword("pass");
        login.clickIngresar();
        String expectedUrl = login_url;
        String expectedState = "Atención: Contraseña o usuario incorrecto";
        assertEquals(expectedState, login.getStateMessage());
        assertEquals(expectedUrl, driver.getCurrentUrl()); 
    }
    @Test
    public void invalidLogin4() {
        driver.get(Util.BASE_URL);
        Login login = new Login(driver);
        login.setUsername("user");
        login.setPassword("pass");
        login.clickIngresar();
        String expectedUrl = login_url;
        String expectedState = "Atención: El usuario ingresado no existe";
        assertEquals(expectedState, login.getStateMessage());
        assertEquals(expectedUrl, driver.getCurrentUrl());
        
    }
    @Test
    public void invalidLogin5() {
        driver.get(Util.BASE_URL);
        Login login = new Login(driver);
        login.setUsername("");
        login.setPassword("pass");
        login.clickIngresar();
        String expectedUrl = login_url;
        String expectedState = "Atención: Debe ingresar un nombre de usuario";
        assertEquals(expectedState, login.getStateMessage());
        assertEquals(expectedUrl, driver.getCurrentUrl());
        
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
