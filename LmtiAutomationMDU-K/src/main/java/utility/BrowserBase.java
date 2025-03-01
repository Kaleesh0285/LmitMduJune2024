package utility;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BrowserBase {

   public WebDriver driver ;

    public WebDriver getDriver() throws IOException {

       Properties properties = new Properties();
       File file = new File("src/main/resources/configuration/frameworkConfiguration.properties");
       FileInputStream fileInputStream = new FileInputStream(file);
       properties.load(fileInputStream);


       if(properties.getProperty("browser").equalsIgnoreCase("chrome")) {
          driver = new ChromeDriver();
       }
       else if(properties.getProperty("browser").equalsIgnoreCase("edge")){
           driver = new EdgeDriver();
       }
       else if(properties.getProperty("browser").equalsIgnoreCase("safari")){
           driver = new SafariDriver();
       }
       else{
         throw new InvalidArgumentException("enter the valid browser name");
       }

        driver.get( properties.getProperty("testenvironment"));
        return driver;
    }
}
