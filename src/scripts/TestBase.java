package scripts;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidLauncher;

import java.io.FileInputStream;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidKeys;
import io.selendroid.SelendroidLauncher;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.annotations.Test;
//import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
public class TestBase {
  
	public static SelendroidDriver driver = null;
	public static Properties config = null;
	public static Properties OR = null;
	public static Random random = new Random();
	public String Basedir = System.getProperty("user.dir");
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public SelendroidLauncher selendroidServer = null;
	
  @BeforeSuite
  public void BeforeSuite() throws Exception{
  config = new Properties();
  OR = new Properties();
  FileInputStream fp = new FileInputStream(Basedir + "\\src\\ConfigFiles\\config.properties");
  config.load(fp);
  FileInputStream fp1 = new FileInputStream(Basedir + "\\src\\ConfigFiles\\OR.properties");
  OR.load(fp1);
    if (selendroidServer != null) {
    selendroidServer.stopSelendroid();
    }
    SelendroidConfiguration config = new SelendroidConfiguration();
    config.addSupportedApp("D:\\Selendroid\\LapsiTreasureHunt.apk");
	config.addSupportedApp("D:\\Selendroid\\com.whatsapp.apk");
    selendroidServer = new SelendroidLauncher(config);
    selendroidServer.launchSelendroid();
    SelendroidCapabilities capa = new SelendroidCapabilities("com.nexii.treasurehunt:1.0");
    capa.setLaunchActivity("com.nexii.treasurehunt.SplashScreen");
    capa.setBrowserName("selendroid");
    capa.setPlatform(Platform.ANDROID);
//    capa.setSerial("0123456789ABCDEF");
    capa.setEmulator(false);
    driver = new SelendroidDriver(capa);
 
  } 
}