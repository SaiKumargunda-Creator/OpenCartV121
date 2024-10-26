package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclass {
	
	public WebDriver driver;
	public Properties prop;
	
	
	@BeforeClass (groups={"sanity","regression","master"})
	
	@Parameters ("browser")
      public void setup(String br) throws IOException {
		prop = new Properties ();
		FileInputStream file =  new FileInputStream( "C:\\Users\\gunda\\eclipse-workspace\\OpencartV121\\src\\test\\resource\\config.properties");
		prop.load(file);
		
		if (prop.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
		    capabilities.setPlatform(Platform.WIN11);
		    switch(br.toLowerCase())
		    { 
		    case "chrome": capabilities.setBrowserName("chrome");break;
		    case "edge": capabilities.setBrowserName("edge"); break;
		    case "firefox": capabilities.setBrowserName("firefox"); break;
		    default: System.out.println ("invalid browser");
		    return;
		    }
		    driver = new RemoteWebDriver (new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		if (prop.getProperty("execution_env").equalsIgnoreCase("local")) {
		
		switch(br) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "Firefox":
			driver = new FirefoxDriver();
			break;
			default:
				System.out.print("invalid browser");
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
	}
	}
		
	@AfterClass (groups ={"sanity","regression","master"})
	public void teardown() {
		driver.quit();
		
	}
}

