package config;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.pages.AdminLogin;
import com.pages.AdminLogoutpage;

public class AppUtil {
public static Properties conpro;
public static WebDriver driver;
@BeforeTest
public static void setUp()throws Throwable
{
	conpro = new Properties();
	conpro.load(new FileInputStream("./PropertyFiles/Environment.properties"));
	driver = new ChromeDriver();;
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get(conpro.getProperty("Url"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	AdminLogin login =PageFactory.initElements(driver, AdminLogin.class);
	login.eRP_login("admin", "master");
}
@AfterTest
public static void appLogout()
{
	AdminLogoutpage logout = PageFactory.initElements(driver, AdminLogoutpage.class);
	logout.adminLogout();
	driver.quit();
}
}
