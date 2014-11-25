package scripts;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidLauncher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import testUtils.Helper;

public class MyInvitedGames extends Helper {
	 private SelendroidLauncher selendroidServer = null;
	 private WebDriver driver = null;
  
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
	    Random r = new Random();
	    
//Signin Button Validation
	    if(!driver.findElements(By.id("btn_sign_in")).isEmpty()) {
		  	System.out.println("\n"+"Validating Signin Button");
	    	driver.findElement(By.id("btn_sign_in")).click();
		   }
	     
//Validating my invited games from home page
	    System.out.println("Validating my invited games button in the home page");
	    sleep(3);
	    waitToLoadForElement(20, By.id("btn_join_game"));
	    System.out.println("\nClicking on " +driver.findElement(By.id("btn_join_game")).getText());
	    driver.findElement(By.id("btn_join_game")).click();
	    
//Validating Invited Games page
	    sleep(5);
	    waitToLoadForElement(20, By.id("action_bar_title"));
	    System.out.println("The current page is : " +driver.findElement(By.id("action_bar_title")).getText());  
//=================================================================================================================================================

//Validating Current Games
	    
//Getting the Current Games list and printing Thier Names.
	    List<WebElement> CurrentGamesList_0 = driver.findElement(By.xpath("//FrameLayout[@id='content']")).findElements(By.id("lv_view_scheduled_games"));
	    	sleep(5);
	    List<WebElement> CurrentGamesList_1 = new ArrayList<WebElement>();
	    CurrentGamesList_1 = CurrentGamesList_0.get(0).findElements(By.id("tv_item_joined_game_name"));   
	    if (CurrentGamesList_1.size() == 0) {
	    	System.out.println("There are currently no Games in the Current Games tab");
		}
	    else {
	    	System.out.println("Number of games in Current Games List are : " +  CurrentGamesList_1.size());
	    	System.out.println("Name of the Games in CURRENT GAMES :");
	    for(int g=0;g<CurrentGamesList_1.size();g++){
	    	System.out.println(CurrentGamesList_1.get(g).getText());
	    }
	    int CurrentGame = r.nextInt(CurrentGamesList_1.size());
	    	System.out.println("\n"+"Random Game Number selected is: " +CurrentGame +1 +",\nRandomly selected game name is: "+ CurrentGamesList_1.get(CurrentGame).getText());
	    	sleep(6);
	    	CurrentGamesList_1.get(CurrentGame).click();
	    	sleep(6);
	    	System.out.println("\n"+"The Current Page is "+driver.findElement(By.id("action_bar_title")).getText()+ " Page");

//Handling Notes
	    	System.out.println("\n"+"First Note Name : " + driver.findElement(By.id("tv_current_note_name")).getText());
	    	System.out.println("First Note Desc : " +driver.findElement(By.id("tv_current_note_desc")).getText());
	    	sleep(6);
	    	System.out.println("\n"+"Clicking on My Location Button");
	    	driver.findElement(By.xpath("//View[@name='My Location']")).click();
	    	sleep(6);
	    	System.out.println("Clicking on View Change Button");
	    	driver.findElement(By.id("iv_change_view")).click();
	    	sleep(6);
	    	System.out.println("Clicking on Zoom In Button");
	    	driver.findElement(By.xpath("//View[@name='Zoom in']")).click();
	    	sleep(6);
	    	System.out.println("Clicking on Zoom Out Button");
	    	driver.findElement(By.xpath("//View[@name='Zoom out']")).click();
	    	sleep(5);
		    driver.navigate().back();
		    sleep(10);
	    }
	    
// Validating Waiting Games
	    	System.out.println("\n"+"Validating Waiting Games"+"\n");
	    	driver.findElement(By.xpath("//TextView[@value='Waiting Games']")).click();;
	    	sleep(5);
	    
//Waiting Games
	    List<WebElement> WaitingGamesList_0 = driver.findElement(By.xpath("//FrameLayout[@id='content']")).findElements(By.id("lv_view_scheduled_games"));
	    	sleep(10);
	    List<WebElement> WaitingGames_1 = new ArrayList<WebElement>();
	    	WaitingGames_1 = WaitingGamesList_0.get(1).findElements(By.id("tv_item_joined_game_name")); 
	    if(WaitingGames_1.size() == 0){
	    	System.out.println("There are currently no games in the Waiting Games list");
	    }
	    else{
	    	System.out.println("Number of games in waiting games List : " +  WaitingGames_1.size());
	    	System.out.println("Name of the Games in Waiting Games :");
	    for(int g=0;g<WaitingGames_1.size();g++){
	    	System.out.println(WaitingGames_1.get(g).getText());
	    }	    
	    	sleep(6);
	    	int WaitedGame = r.nextInt(WaitingGames_1.size());
	    	System.out.println("Randomly Selected Game Number : " +WaitedGame +" ,\nRandomly Selected Game Name : "+ WaitingGames_1.get(WaitedGame).getText());
	    	String Name = WaitingGames_1.get(WaitedGame).getText();
	    	sleep(6);
	    	WaitingGames_1.get(WaitedGame).click();
	    	sleep(6);
	    	System.out.println("\n"+"The Current Page is "+driver.findElement(By.id("action_bar_title")).getText()+ " Page");
	    
	    WebElement Button_Accept = driver.findElement(By.id("bt_join_game"));
	    WebElement Button_Reject = driver.findElement(By.id("bt_reject_game"));
	    
	    while(Button_Reject.isEnabled()){						
	    	System.out.println("Clicking on Not Ready Button ");
		    driver.findElement(By.id("bt_reject_game")).click(); //This will navigate to the homepage
		    sleep(10);
		    System.out.println("\nTitle of Navigated Page: " + driver.findElement(By.id("action_bar_title")).getText()); //This page will be the home page
		    sleep(3);
		    driver.findElement(By.linkText("My Invited Games")).click(); //This will navigate to the Invited games page
		    sleep(3);
		    driver.findElement(By.xpath("//TextView[@value='Waiting Games']")).click(); //This will navigate to the Waiting games page
		    sleep(10);
		    WaitingGames_1.get(WaitedGame).click();
	    	sleep(6);
	    	System.out.println("\n"+"The Current Page is "+driver.findElement(By.id("action_bar_title")).getText()+ " Page");
	    if(!Button_Reject.isEnabled()){
	    	Button_Accept.click();
	    	sleep(3);
	    }
	    else{
	    	System.out.println("The Button Not ready is still enabled even after once clicked");
	    }
	    }
	    while(!Button_Reject.isEnabled()){
	    	Button_Accept.click();
	    	sleep(3);
		    driver.findElement(By.linkText("My Invited Games")).click(); //This will navigate to the Invited games page
		    sleep(3);
		    driver.findElement(By.xpath("//TextView[@value='Waiting Games']")).click(); //This will navigate to the Waiting games page
		    sleep(10);
		    WaitingGames_1.get(WaitedGame).click();
	    	sleep(6);
	    	System.out.println("\n"+"The Current Page is "+driver.findElement(By.id("action_bar_title")).getText()+ " Page");
	    if(!Button_Accept.isEnabled()){
	   		Button_Reject.click();
	   		sleep(3);
		    driver.findElement(By.linkText("My Invited Games")).click(); //This will navigate to the Invited games page
		    sleep(3);
		    driver.findElement(By.xpath("//TextView[@value='Waiting Games']")).click(); //This will navigate to the Waiting games page
		    sleep(10);
		    WaitingGames_1.get(WaitedGame).click();
	    	sleep(6);
	    	System.out.println("\n"+"The Current Page is "+driver.findElement(By.id("action_bar_title")).getText()+ " Page");
	   		Button_Accept.click();
	    	}
	    else{
	    	System.out.println("The Button Accept is still enabled after clicking it once");
	    }
	    }
	    } 
//Navigation To HomePage
		    sleep(5);
			System.out.println("Title of Navigated Page: " + driver.findElement(By.id("action_bar_title")).getText());
	   
	  	  
//Validating Completed games
		
			sleep(3);
		
		if (driver.findElement(By.linkText("My Invited Games")).isEnabled()){
		    driver.findElement(By.linkText("My Invited Games")).click();
		    sleep(3);
		}
			sleep(3);
			System.out.println("\n"+"Validating Current Games"+"\n");
		    driver.findElement(By.xpath("//TextView[@value='Completed Games']")).click();;
		    sleep(5);   
	    List<WebElement> CompletedGamesList_0 = driver.findElement(By.xpath("//FrameLayout[@id='content']")).findElements(By.id("lv_view_scheduled_games"));    
	    	sleep(10);
	    List<WebElement> CompletedGamesList_1 = new ArrayList<WebElement>();
	    CompletedGamesList_1 = CompletedGamesList_0.get(1).findElements(By.id("tv_item_joined_game_name"));
	    if(CompletedGamesList_1.size() == 0){
	    	System.out.println("There are currently no games in the Completed Games list");
	    	
	    }
	    else{
		    System.out.println("\n"+"Number of games in Completed games List : " +  CompletedGamesList_1.size());
		    System.out.println("Name of the Games in Completed Games are :");
	    for(int g=0;g<CompletedGamesList_1.size();g++){
	    	System.out.println(CompletedGamesList_1.get(g).getText());
	    }
		    sleep(6);
		    int CompletedGame = r.nextInt(CompletedGamesList_1.size());
		    System.out.println("\n"+"Randomly Selected Game Number : " +CompletedGame+",\nRandomly Selected Game Name : "+ CompletedGamesList_1.get(CompletedGame).getText());
		    String Name1 = CompletedGamesList_1.get(CompletedGame).getText();
		    sleep(6);
		    CompletedGamesList_1.get(CompletedGame).click();
		    sleep(6);
		    System.out.println("\n"+"The Current Page is "+driver.findElement(By.id("action_bar_title")).getText()+ " Page");
	    List<WebElement> GameStatsticsNamesList = driver.findElement(By.id("lv_players_completed_game")).findElements(By.id("tv_completed_player_name"));   
	    List<WebElement> GameStatsticsRanksList = driver.findElements(By.id("tv_player_rank"));
	    	System.out.println("Printing the Names & Their respective Ranks");
	    for(int GSN=0; GSN<GameStatsticsNamesList.size();GSN++){
	    	System.out.println(GameStatsticsNamesList.get(GSN).getText()+" : "+GameStatsticsRanksList.get(GSN).getText());	    	
	    }
//Navigation To HomePage
	  		driver.findElement(By.id("action_bar_title")).click();
	  		System.out.println("Title of Navigated Page: " + driver.findElement(By.id("action_bar_title")).getText());
	    }	
	  		sleep(10);
	  }
}