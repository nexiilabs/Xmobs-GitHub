package scripts;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidLauncher;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import testUtils.Helper;

public class AppIconNavigation extends Helper{
  @Test
   public void startSelendroidServer() throws Exception {
			
			if (selendroidServer != null) {
		  		selendroidServer.stopSelendroid();
		
			}
		    
			  	SelendroidConfiguration config = new SelendroidConfiguration();
			  	config.setForceReinstall(true);
			  	selendroidServer = new SelendroidLauncher(config);
			  	selendroidServer.launchSelendroid();
			  	SelendroidCapabilities caps = new SelendroidCapabilities("com.nexii.treasurehunt:1.0");
			  	caps.setEmulator(false);
		    
		    	driver = new SelendroidDriver(caps);
		    
//Validating my invited games from home page
		    
		    	System.out.println("Validating my invited games button in the home page");
		    	sleep(3);
		    	waitToLoadForElement(20, By.id("btn_join_game"));
		    	System.out.println("Clicking on " +driver.findElement(By.id("btn_join_game")).getText());
		    	driver.findElement(By.id("btn_join_game")).click();
		   
		    	
		    	
		    
	//Validating Invited Games page
		    
		    	sleep(3);
		    	waitToLoadForElement(20, By.id("action_bar_title"));
		    	System.out.println("The current page is : " +driver.findElement(By.id("action_bar_title")).getText());
	  
	  
	  String game_page = driver.findElement(By.id("action_bar_title")).getText();
	   System.out.println("The current page is : " +driver.findElement(By.id("action_bar_title")).getText());
	   driver.findElement(By.id("action_bar_title")).click();
	   sleep(5);
	   waitToLoadForElement(20, By.id("action_bar_title"));
	   System.out.println("After clicking now the page is : " +driver.findElement(By.id("action_bar_title")).getText());
	   String home_page = driver.findElement(By.id("action_bar_title")).getText();
	   
	   if(game_page.equals(home_page)){
		   System.out.println("Home page is not navigated");
	   }
	   else{
		   
	   System.out.println("Home page navigated successfully");
	   }
	  
  } 
}
