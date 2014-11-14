package scripts;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidLauncher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyInvitedGames {
	 private SelendroidLauncher selendroidServer = null;
	  private WebDriver driver = null;
	  
	  public void sleep(int seconds){
			try{
				Thread.sleep(seconds*1000);
			}
			catch(Exception e){
			}
		}
		public boolean waitforelement(int timeout,By by){
			while(timeout>0){
				sleep(1);
				List<WebElement> list = driver.findElements(by);
				if(list.size()!=0){
					return true;
				}
				timeout--;
			}
			System.out.println("waiting timeout.... Element not found " +by.toString());
			return false;
		}

	  
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
	    
	  //Signin Button 
	    if(!driver.findElements(By.id("btn_sign_in")).isEmpty()) {
		  	System.out.println("\n"+"Validating Signin Button");
	    	driver.findElement(By.id("btn_sign_in")).click();
		   }
	    
	    
	    
	    
	    //Validating my invited games from home page
	    System.out.println("Validating my invited games button in the home page");
	    sleep(3);
	    waitforelement(20, By.id("btn_join_game"));
	    System.out.println("\nClicking on " +driver.findElement(By.id("btn_join_game")).getText());
	    driver.findElement(By.id("btn_join_game")).click();
	    
	    //Validating Invited Games page
	    sleep(3);
	    waitforelement(20, By.id("action_bar_title"));
	    System.out.println("The current page is : " +driver.findElement(By.id("action_bar_title")).getText());
	    
	    // validating current games when having multiple games waiting
	/*    
	    driver.findElement(By.linkText("Current Games")).click();
	    sleep(2);
	    List<WebElement> CuG = driver.findElements(By.id("tv_item_joined_game_name"));
	    
	    if(CuG.size()>0){
	    	
	    	System.out.println("The number of games in the Current GAMES list are : " +CuG.size());
	    
	    for (int i=0;i<CuG.size();i++){
	    	
	    	System.out.println(CuG.get(i).findElement(By.id("tv_item_joined_game_name")).getText());
	    	sleep(2);
	    
	    }
	    Random cu = new Random();
	    int a = cu.nextInt(CuG.size());
	    System.out.println("Random Game selected is for test is : " +a+"\nThe Game name is : " +CuG.get(a).findElement(By.id("tv_item_joined_game_name")).getText());
	    sleep(2);
	    CuG.get(a).findElement(By.id("tv_item_joined_game_name")).click();
	    
	    }
	    
	    /*   driver.findElement(By.linkText("Waiting Games")).click();
	    sleep(2);
	    driver.findElement(By.linkText("Completed Games")).click();
	    sleep(2);
	   */
	    
	 /*   List<WebElement> CrG = driver.findElement(By.id("content")).findElements(By.id("lv_view_scheduled_games"));
	
	    System.out.println("The number of games in the CURRENT GAMES list are : " +CrG.size());
	    for (int i=0;i<CrG.size();i++){
	    	
	    	System.out.println(CrG.get(i).getText()); 	
	    }
	   -----------------------------------------
	   // driver.findElement(By.linkText("Waiting Games")).click();
	    
	    List<WebElement> WaitingGames = driver.findElement(By.xpath("//FrameLayout[@id='content']")).findElements(By.id("lv_view_scheduled_games"));
	    
	    
	    System.out.println("Number of Games invited : " + WaitingGames.size());
	    for(int f=0;f<WaitingGames.size();f++){
	     System.out.println("Name of the Notes :" + WaitingGames.get(f).getText());
	       }
	    
	    
	    sleep(2);
	    
	    List<WebElement> list2 = new ArrayList<WebElement>();
	    list2 = WaitingGames.get(0).findElements(By.id("tv_item_joined_game_name"));   
	    System.out.println(list2.size());
	    
	    for(int g=0;g<list2.size();g++){
	    	sleep(2);
	     System.out.println("Name of the Notes :" + WaitingGames.get(g).getText());
	       }
	    WaitingGames.get(0).click();
	    
	    /*   
	    // game test for single game 
	   System.out.println("The name of the game is : " +driver.findElement(By.id("tv_item_joined_game_name")).getText());
	   System.out.println("The scheduled date and time of the game is : " +driver.findElement(By.id("tv_item_joined_game_schedule_time")).getText());
	   driver.findElement(By.id("tv_item_joined_game_name")).click();
	   
	   // getting the game information from xmobs page
	   
	   System.out.println("The game name from Xmobs pae is : " +driver.findElement(By.id("tv_current_note_name")).getText());
	   System.out.println("The Note Description is : " +driver.findElement(By.id("tv_current_note_desc")).getText());
	   */
	    sleep(20);
	    
	  }
}
