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
	    
	   //Signin Button Validation
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
	    
//=================================================================================================================================================

//Validating Current Games
	    
	    //Getting the Current Games list and printing Thier Names.
	    List<WebElement> CurrentGamesList_0 = driver.findElement(By.xpath("//FrameLayout[@id='content']")).findElements(By.id("lv_view_scheduled_games"));
	    // System.out.println(CurrentGamesList_0.size());
	    Thread.sleep(5000);
	    
	    List<WebElement> CurrentGamesList_1 = new ArrayList<WebElement>();
	    CurrentGamesList_1 = CurrentGamesList_0.get(0).findElements(By.id("tv_item_joined_game_name"));   
	    System.out.println("Number of games in Current Games List are : " +  CurrentGamesList_1.size());
	    System.out.println("Name of the Games in Waiting Games :");
	    
	    for(int g=0;g<CurrentGamesList_1.size();g++){
	    	System.out.println(CurrentGamesList_1.get(g).getText());
	    }
	    
	    Random r = new Random();
	    int CurrentGame = r.nextInt(CurrentGamesList_1.size());
	    System.out.println("\n"+"Random Game Number selected is: " +CurrentGame+" ,  Randomly selected game name is: "+ CurrentGamesList_1.get(CurrentGame).getText());
	   // String Name = CurrentGamesList_1.get(CurrentGame).getText();
	   // System.out.println(Name);
	    Thread.sleep(6000);
	    CurrentGamesList_1.get(CurrentGame).click();
	    Thread.sleep(6000);
	   
	    System.out.println("\n"+"The Current Page is "+driver.findElement(By.id("action_bar_title")).getText()+ " Page");
	    //Handling Notes
	    System.out.println("\n"+"First Note Name : " + driver.findElement(By.id("tv_current_note_name")).getText());
	    System.out.println("First Note Desc : " +driver.findElement(By.id("tv_current_note_desc")).getText());
	    
	    Thread.sleep(6000);
	    System.out.println("\n"+"Clicking on My Location Button");
	    driver.findElement(By.xpath("//View[@name='My Location']")).click();;
	    
	    Thread.sleep(6000);
	    System.out.println("Clicking on View Change Button");
	    driver.findElement(By.id("iv_change_view")).click();
	   
	    Thread.sleep(6000);
	    System.out.println("Clicking on Zoom In Button");
	    driver.findElement(By.xpath("//View[@name='Zoom in']")).click();
	    
	    Thread.sleep(6000);
	    System.out.println("Clicking on Zoom Out Button");
	    driver.findElement(By.xpath("//View[@name='Zoom out']")).click();
	    Thread.sleep(5000);
	    driver.navigate().back();
	    Thread.sleep(10000);
	    
	    
// Validating Waiting Games
	    System.out.println("\n"+"Validating Waiting Games"+"\n");
	    driver.findElement(By.xpath("//TextView[@value='Waiting Games']")).click();;
	    Thread.sleep(5000);
	    //Waiting Games
	    List<WebElement> WaitingGamesList_0 = driver.findElement(By.xpath("//FrameLayout[@id='content']")).findElements(By.id("lv_view_scheduled_games"));
	    //System.out.println(WaitingGamesList_0.size());
	    Thread.sleep(10000);
	    List<WebElement> WaitingGames_1 = new ArrayList<WebElement>();
	    WaitingGames_1 = WaitingGamesList_0.get(1).findElements(By.id("tv_item_joined_game_name"));   
	    System.out.println("Number of games in waiting games List : " +  WaitingGames_1.size());
	    System.out.println("Name of the Games in Waiting Games :");
	    
	    for(int g=0;g<WaitingGames_1.size();g++){
	    	System.out.println(WaitingGames_1.get(g).getText());
	    }
	    
	    Thread.sleep(6000);
	    int WaitedGame = r.nextInt(WaitingGames_1.size());
	    //System.out.println("Randomly selected game Name is : "+);
	    System.out.println("Randomly Selected Game Number : " +WaitedGame+" ,  Randomly Selected Game Name : "+ WaitingGames_1.get(WaitedGame).getText());
	    String Name = WaitingGames_1.get(WaitedGame).getText();
	    //System.out.println(Name);
	    Thread.sleep(6000);
	    WaitingGames_1.get(WaitedGame).click();
	    Thread.sleep(6000);
	    System.out.println("\n"+"The Current Page is "+driver.findElement(By.id("action_bar_title")).getText()+ " Page");
	    System.out.println("\n"+"Clicking on Not Ready Button ");
	    driver.findElement(By.id("bt_reject_game")).click();
	    Thread.sleep(10000);
	    
	    //Navigation To HomePage
	    System.out.println("Title of Navigated Page: " + driver.findElement(By.id("action_bar_title")).getText());
	    
	    //Reverting back to Waiting games
	    Thread.sleep(3000);
	    driver.findElement(By.linkText("My Invited Games")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//TextView[@value='Waiting Games']")).click();;
	    Thread.sleep(10000);
	    
	    for(int v=0;v<WaitingGames_1.size();v++){
		Thread.sleep(10000);
		   
	//======================================================================================================================================================
		List<WebElement> WaitingGames3 = driver.findElement(By.xpath("//FrameLayout[@id='content']")).findElements(By.id("lv_view_scheduled_games"));
		Thread.sleep(5000);
		List<WebElement> WaitingGames4 = new ArrayList<WebElement>();
		WaitingGames4 = WaitingGames3.get(1).findElements(By.id("tv_item_joined_game_name"));   
	//========================================================================================================================================================  
		   
		if(WaitingGames4.get(v).getText().equalsIgnoreCase(Name));{
		Thread.sleep(3000);
		System.out.println("\n"+"Reverting back to "+driver.findElement(By.id("action_bar_title")).getText()+ " Page");
		WaitingGames4.get(v).click();
		Thread.sleep(3000);
		System.out.println("\n"+"Clicking on Not Ready Button ");
		driver.findElement(By.id("bt_join_game")).click();
		Thread.sleep(5000);
		}
	    }
		//Navigation To HomePage
		System.out.println("Title of Navigated Page: " + driver.findElement(By.id("action_bar_title")).getText());
	    
	    
//Validating Completed games
		
		Thread.sleep(3000);
	    driver.findElement(By.linkText("My Invited Games")).click();
	    Thread.sleep(3000);
		System.out.println("\n"+"Validating Current Games"+"\n");
	    driver.findElement(By.xpath("//TextView[@value='Completed Games']")).click();;
	    Thread.sleep(5000);
	    
	    List<WebElement> CompletedGamesList_0 = driver.findElement(By.xpath("//FrameLayout[@id='content']")).findElements(By.id("lv_view_scheduled_games"));
	    //System.out.println(CompletedGamesList_0.size());
	    Thread.sleep(10000);
	    List<WebElement> CompletedGamesList_1 = new ArrayList<WebElement>();
	    CompletedGamesList_1 = CompletedGamesList_0.get(1).findElements(By.id("tv_item_joined_game_name"));   
	    System.out.println("\n"+"Number of games in Completed games List : " +  CompletedGamesList_1.size());
	    System.out.println("Name of the Games in Completed Games :");
	    
	    for(int g=0;g<CompletedGamesList_1.size();g++){
	    	System.out.println(CompletedGamesList_1.get(g).getText());
	    }
	    
	    Thread.sleep(6000);
	    int CompletedGame = r.nextInt(CompletedGamesList_1.size());
	    System.out.println("\n"+"Randomly Selected Game Number : " +CompletedGame+" ,  Randomly Selected Game Name : "+ CompletedGamesList_1.get(CompletedGame).getText());
	    String Name1 = CompletedGamesList_1.get(CompletedGame).getText();
	    //System.out.println(Name);
	    Thread.sleep(6000);
	    CompletedGamesList_1.get(CompletedGame).click();
	    Thread.sleep(6000);
	    
	    System.out.println("\n"+"The Current Page is "+driver.findElement(By.id("action_bar_title")).getText()+ " Page");
	    List<WebElement> GameStatsticsNamesList = driver.findElement(By.id("lv_players_completed_game")).findElements(By.id("tv_completed_player_name"));
	   //System.out.println(GameStatsticsNamesList.size());
	    
	    List<WebElement> GameStatsticsRanksList = driver.findElements(By.id("tv_player_rank"));
	   // System.out.println(GameStatsticsRanksList.size());
	    
	    System.out.println("Printing the Names & Their respective Ranks");
	    for(int GSN=0; GSN<GameStatsticsNamesList.size();GSN++){
	    	
	    	System.out.println(GameStatsticsNamesList.get(GSN).getText()+" : "+GameStatsticsRanksList.get(GSN).getText());
	    	    	
	    }
	  //Navigation To HomePage
	  		System.out.println("Title of Navigated Page: " + driver.findElement(By.id("action_bar_title")).getText());
	    
	    
	   	      
//==================================================================================================================================================	    
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
	    sleep(1000000);
	    
	  }
}
