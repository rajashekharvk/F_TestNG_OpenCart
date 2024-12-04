package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
//Log4j from Apache
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass (alwaysRun = true)
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {

		logger = LogManager.getLogger(this.getClass());

		// Loading properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid Browser name");
			return;
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.get(p.getProperty("Url"));
		driver.get(p.getProperty("url_HDFC"));
		driver.manage().window().maximize();
	}

	@AfterClass(alwaysRun = true)
	public void teardown() {
		driver.quit();

	}

	public String randomString() {
		String randmString = RandomStringUtils.randomAlphabetic(5);
		return randmString;
	}

	public String randomNumber() {
		String randmNumber = RandomStringUtils.randomNumeric(10);
		return randmNumber;
	}

	public String randomAlphaNumeric() {
		String randmString = RandomStringUtils.randomAlphabetic(3);
		String randmNumber = RandomStringUtils.randomNumeric(2);
		return (randmString + randmNumber);
	}
	
	public String captureScreen(String tname) {
		String timeStamp=new SimpleDateFormat("yyyMMddhhmmss").format(new Date());
		TakesScreenshot takeScreenShot=(TakesScreenshot)driver;
		File sourceFile=takeScreenShot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
		
	}

}
