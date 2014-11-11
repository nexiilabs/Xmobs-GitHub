package testUtils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

import scripts.TestBase;

public class Helper extends TestBase {
	
	public void sleep(int seconds){
		try {
			Thread.sleep(seconds*1000);
	    	} catch (InterruptedException e) {
			e.printStackTrace();
	    	}
	  }
	
	public boolean waitToLoadForElement(int timeout, By by){
		int k=timeout;
		while (timeout>0){
			sleep(1);
		List<WebElement> list = driver.findElements(by);
		  if(list.size()!=0){
			return true;
		  }
		timeout--;
		}
	Reporter.log("Waited for"+k+"minutes but "+by+" not found");	
	  return false;
	}
		
	public void  takeScreenshot(String filename){
		  File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  try {
			FileUtils.copyFile(scrfile, new File(Basedir+"\\src\\screenshots\\"+filename+".jpg"));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	  }
	public void iteratorClick(String locator){
		   List<WebElement> list = driver.findElements(By.id(locator));
		   Iterator<WebElement> iterator = list.iterator();
		   
		   while(iterator.hasNext())
				iterator.next().click();
	   }
		   
	public void signIn(){
		sleep(5);
	    //searching for signin button
	    List<WebElement> signin = driver.findElements(By.id("btn_sign_in"));
	    if(signin.size()!=0)
	    	//clicking on signin if exists
	    driver.findElement(By.id("btn_sign_in")).click();
	    sleep(3);

	}
}


