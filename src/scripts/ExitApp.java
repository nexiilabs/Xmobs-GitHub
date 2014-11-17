package scripts;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidLauncher;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExitApp {
  
	public SelendroidLauncher SelendriodServer = null;
	public WebDriver driver = null;
	
		
	@BeforeMethod
	 public void beforeMethod() throws Exception {
	
		SelendroidConfiguration config = new SelendroidConfiguration();
	    config.setForceReinstall(true);
	    SelendriodServer = new SelendroidLauncher(config);
	    SelendriodServer.launchSelendroid();
	    
	    SelendroidCapabilities caps = new SelendroidCapabilities("com.nexii.treasurehunt:1.0");
	    caps.setPlatform(Platform.ANDROID);
	    caps.setEmulator(false);
	    
	    Thread.sleep(5000);
	    driver = new SelendroidDriver(caps);
	
	
	
	}
	
	
		
@Test
  public void f() throws Exception {
	
	if (!driver.findElements(By.id("btn_sign_in")).isEmpty()) {
		driver.findElement(By.id("btn_sign_in")).click();
		Thread.sleep(5000);
	}
	
	System.out.println("Validating Exit Button");
	System.out.println("The Current Page is : "+driver.findElement(By.id("action_bar_title")).getText());
	System.out.println("Clicking on Exit Button");
	Thread.sleep(3000);
	driver.findElement(By.linkText("Exit")).click();
	Thread.sleep(5000);
	
	if(driver.findElements(By.linkText("Exit")).isEmpty()){
	System.out.println("The Game Has Succesfully Closed");
	}else{
	System.out.println("The Application Was Not Closed");
	}
	}

}
