package scripts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidLauncher;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import testUtils.Helper;

public class MyGames{
 
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
	    Thread.sleep(30000);
	  }
	
	
	//New Note Method 
	  public void NewNote() throws InterruptedException{
		  Date d = new Date();
		  Thread.sleep(4000);
		  driver.findElement(By.id("bt_address_map")).click();
		  driver.findElement(By.xpath("//ActionMenuView")).click();;
		  driver.findElement(By.xpath("(//RelativeLayout)[1]")).click();
		  Thread.sleep(4000);
		  driver.findElement(By.id("et_note_name")).sendKeys(d.toString());
	      driver.findElement(By.id("et_note_desc")).sendKeys(d.toString());
	      driver.findElement(By.id("et_note_radius")).sendKeys("50");
	      driver.findElement(By.id("bt_note_save")).click();
	  }
	      
	//View Game Method
	  public void ViewGame() throws InterruptedException{
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("//ActionMenuView")).click();
	      driver.findElement(By.xpath("(//RelativeLayout)[2]")).click();
	
	  }
	
	
	  
	 public void MyGamesList() throws InterruptedException{ 
	  
	  
	  List<WebElement> MyGames_1 = driver.findElements(By.id("tv_item_game_list"));
	    System.out.println("Number of Games in My Games list : " + MyGames_1.size());
	    System.out.println("The List of Games are :  "+"\n");
	    for(int a=0 ;a<MyGames_1.size();a++){
	    	
	    	System.out.println(MyGames_1.get(a).getText());
	    	
	    }
	    
	    Thread.sleep(5000);
	    
	    Random r = new Random();
	    int Mygame_Random = r.nextInt(MyGames_1.size());
	    System.out.println("Randomly Picked Element from My Games List :"+"\n" +MyGames_1.get(Mygame_Random).getText());
	    MyGames_1.get(Mygame_Random).click();
	    
	 }
	
	 public void SchedulingGame() throws InterruptedException{ 
	 
	 Thread.sleep(3000);
	    driver.findElement(By.id("ib_date")).click();
	    Thread.sleep(3000);
	    
	    //Picking date from Date Picker
	    WebElement day =driver.findElement(By.id("day")).findElement(By.id("numberpicker_input"));
	    day.sendKeys("15");
	    Thread.sleep(3000);
	    System.out.println("Selected Day is : "+ day.getText());
	    
	    WebElement Month =driver.findElement(By.id("month")).findElement(By.id("numberpicker_input"));
	    Month.sendKeys("Dec");
	    Thread.sleep(3000);
	    System.out.println("Selected Month is : "+Month.getText());
	    
	    
	    WebElement Year =driver.findElement(By.id("year")).findElement(By.id("numberpicker_input"));
	    Year.sendKeys("2015");
	    Thread.sleep(3000);
	    System.out.println("Selected year is : "+Year.getText());
	    Thread.sleep(3000);
	    
	    driver.findElement(By.linkText("Done")).click();
	    
	    //Picking Time From Time Picker
	    
	    Thread.sleep(3000);
	    driver.findElement(By.id("ib_time")).click();
	    Thread.sleep(3000);
	    	 
	    WebElement Hour =driver.findElement(By.id("hour")).findElement(By.id("numberpicker_input"));
	    Hour.sendKeys("9");
	    Thread.sleep(3000);
	    System.out.println("Selected Hour is : "+Hour.getText());
	    
	    WebElement Minute =driver.findElement(By.id("minute")).findElement(By.id("numberpicker_input"));
	    Minute.sendKeys("45");
	    Thread.sleep(3000);
	    System.out.println("Selected Minute is : "+Minute.getText());
	    
	    WebElement AmPm =driver.findElement(By.id("amPm")).findElement(By.id("numberpicker_input"));
	    AmPm.sendKeys("am");
	    Thread.sleep(3000);
	    System.out.println("Selected Noon is : "+AmPm.getText());
	    
	    Thread.sleep(3000);
	    driver.findElement(By.linkText("Done")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText("Schedule This Game")).click();    
	    Thread.sleep(10000);
	    
	    System.out.println("Game Succesfully Scheduled");
	    }
	 
	  
	
	
	@Test
	public void Test1() throws Exception {
		
		
		Date d = new Date();
//Signin Button 
	    if(!driver.findElements(By.id("btn_sign_in")).isEmpty()) {
		  	System.out.println("\n"+"Validating Signin Button");
	    	driver.findElement(By.id("btn_sign_in")).click();
		   }
		
//My Games validation
	    Thread.sleep(5000);
	    driver.findElement(By.linkText("My Games")).click();
	    System.out.println("Validating My Games tab :");
	    
	  //  System.out.println(driver.findElement(By.id("action_bar_title")).getText());
	    //Listing the elements & Picking Randomly in My Games
	    
	    Thread.sleep(15000);
	    List<WebElement> MyGames_1 = driver.findElements(By.id("tv_item_game_list"));
	    /*  System.out.println("Number of Games in My Games list : " + MyGames_1.size());
	    System.out.println("The List of Games are :  "+"\n");
	    for(int a=0 ;a<MyGames_1.size();a++){
	    	
	    	System.out.println(MyGames_1.get(a).getText());
	    	
	    }
	    
	    Thread.sleep(5000);*/
	    
	    Random r = new Random();
	    int Mygame_Random = r.nextInt(MyGames_1.size());
	    System.out.println("\n"+"Randomly Picked Element from My Games List : "+MyGames_1.get(Mygame_Random).getText()+"\n");
	    MyGames_1.get(Mygame_Random).click();
	    
	  
	  //Display how many Notes are created & Their names
	    Thread.sleep(6000);
	    System.out.println("Validating a Randomly Selected Game :");
	    System.out.println("Game Name : "+driver.findElement(By.id("tv_game_title")).getText());
	    System.out.println("Game " +driver.findElement(By.id("et_game_desc")).getText());
	    List<WebElement> CreatedNoteList = driver.findElement(By.id("notes_listView")).findElements(By.id("tv_item_note_list"));
	    System.out.println("\n"+"Number Of Notes Plotted : " + CreatedNoteList.size()+"\n");
	    System.out.println("Names of the Notes plotted : "); 
	    for(int c=0;c<CreatedNoteList.size();c++){
	    	System.out.println(CreatedNoteList.get(c).getText());
	       }
	    
	    Thread.sleep(10000);
	     
//Validating New Note Before tab.
	    
	    System.out.println("\n"+"Validating Edit Note & New Note Before : ");
	    int n = r.nextInt(CreatedNoteList.size());
	    System.out.println("Randomly Picked Note Number : " +n+"\n"+"Randomly Picked Note Name : "+ CreatedNoteList.get(n).getText());
	    CreatedNoteList.get(n).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//ActionMenuView")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//RelativeLayout")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id("atoText")).sendKeys("Bombay,India");
	    Thread.sleep(10000);
	    NewNote();
	    Thread.sleep(5000);
	    ViewGame();
	    Thread.sleep(5000);
	    
	    Thread.sleep(10000);
	    
	    
	 
//Validating Update Note Button
	    
	    List<WebElement> UpdateList = driver.findElement(By.id("notes_listView")).findElements(By.id("iv_update_note"));
	    System.out.println("Count Of Notes after performing New Note Before : " + UpdateList.size()+"\n");
	    System.out.println("\n"+"Validating Update Note Button : ");
	    int x = r.nextInt(UpdateList.size());
	    System.out.println("Randomly picked Note for Updation : " +x+" ,  The Element is: "+ UpdateList.get(x).getText());
	        
	    UpdateList.get(x).click();
	    Thread.sleep(5000);
	        
	    System.out.println("Name Of The Note Before Editing : " + driver.findElement(By.id("et_note_name")).getText());
	    driver.findElement(By.id("et_note_name")).clear();
	    driver.findElement(By.id("et_note_name")).sendKeys(d.toString());
	    Thread.sleep(3000);
	    System.out.println("Name Of The Note After Editing : " + driver.findElement(By.id("et_note_name")).getText());
	    Thread.sleep(5000);
	    
	    driver.findElement(By.id("et_note_desc")).clear();
	    driver.findElement(By.id("et_note_desc")).sendKeys(d.toString());
	    Thread.sleep(10000);
	     
	    driver.findElement(By.id("et_note_radius")).clear();
	    driver.findElement(By.id("et_note_radius")).sendKeys("100");
	    Thread.sleep(10000);
	    
	    driver.findElement(By.id("bt_note_save")).click();;
	    Thread.sleep(6000);
	    
//Validating Delete Note Button
	    
	    List<WebElement> DeleteList = driver.findElement(By.id("notes_listView")).findElements(By.id("iv_delete_note"));
	    System.out.println("Count Of Notes after Updaation of Note : " + DeleteList.size()); 
	    System.out.println("\n"+"Validating Delete Note Button");
	    
	    int w = r.nextInt(DeleteList.size());
	    System.out.println("Randomly picked Note Number for Deleting note " +w+"\n"+"Randomly picked Note Name for Deleting note : "+ DeleteList.get(w).getText());
	    
	  //Clicking on "No" option in Delete Game Popup
	    System.out.println("Clicking on 'No' Option in Delete game Popup");
	    DeleteList.get(w).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id("button2")).click();
	    
	  //Clicking on "Yes" option in Delete Game Popup
	    System.out.println("Clicking on 'Yes' Option in Delete game Popup"+"\n");
	    Thread.sleep(10000);
	    DeleteList.get(w).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id("button1")).click(); 
	    Thread.sleep(10000); 
	    

//Validating Action Menu in View Game Page
	    
	   //Manage Notes
	     System.out.println("Validating manage Notes");
	     driver.findElement(By.xpath("//ActionMenuView")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("(//RelativeLayout)[1]")).click();
	     Thread.sleep(5000);
	     driver.findElement(By.id("atoText")).sendKeys("vizag,India");
	     Thread.sleep(5000);
	     System.out.println("Creating a New Note"+"\n");
	     NewNote();
	     Thread.sleep(5000);
	     ViewGame(); 
	    
	  //Edit game
	     System.out.println("Validating Edit Game Tab :");
	     Thread.sleep(5000);
	     driver.findElement(By.xpath("//ActionMenuView")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("(//RelativeLayout)[2]")).click();
	     Thread.sleep(5000);
	     System.out.println("Game name before Game Editing : " +driver.findElement(By.id("et_game_name")).getText());
	     driver.findElement(By.id("et_game_name")).clear();
	     driver.findElement(By.id("et_game_name")).sendKeys(d.toString());
	     Thread.sleep(3000);
	     
	     String EditedGamename = driver.findElement(By.id("et_game_name")).getText();
	     System.out.println("Game name After Game Editing :  "+EditedGamename+"\n");
	     driver.findElement(By.id("et_game_desc")).clear();
	     driver.findElement(By.id("et_game_desc")).sendKeys(d.toString());
	     Thread.sleep(3000);
	     driver.navigate().back();
	     Thread.sleep(3000);
	     driver.findElement(By.linkText("Update Game")).click();
	     //driver.findElement(By.id("bt_note_save")).click();
	    
	     Thread.sleep(10000);
	     
	     
	    //Picking The Edited game
	     List<WebElement> MyGames_2 = driver.findElements(By.id("tv_item_game_list"));
	     
	     for(int j=0;j<MyGames_2.size();j++){
	    	 
	    	 if(MyGames_2.get(j).getText().equalsIgnoreCase(EditedGamename)){
	    		
	    		 Thread.sleep(8000);
	    		 MyGames_2.get(j).click();
	    		 break;
	    	 	}
	      }
	     
	     
	     Thread.sleep(10000); 
	    //Publish Game & Sheduling The Game
	    String editedGameName1 = driver.findElement(By.id("tv_game_title")).getText();
	    Thread.sleep(5000);
	    if(editedGameName1.equalsIgnoreCase(EditedGamename)){
	    	System.out.println("The Randomly Picked Game Name for Sheduling  matches With Edited game name"); 
	    }else{
	    Assert.fail("\n"+"The Randomly Picked Game Name for Sheduling Doesn't matches With Edited game name ");	
	    }
	   
	    
	    
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//ActionMenuView")).click();
	    Thread.sleep(3000);
	    String ActionTab4 = driver.findElement(By.xpath("(//RelativeLayout)[4]")).findElement(By.id("title")).getText();
	    System.out.println("Fourth Element in Action Bar : " +ActionTab4);
	    Thread.sleep(10000); 
	    
	   
	    if(ActionTab4.equalsIgnoreCase("Schedule Game")){
	    
	    System.out.println("\n"+"Validating Schedule Game page : ");
	    driver.findElement(By.xpath("(//RelativeLayout)[4]")).click();
	    Thread.sleep(3000);
	    SchedulingGame();
	    Thread.sleep(30000);
	    
	    }else {
	    	Thread.sleep(10000);
	    	driver.findElement(By.xpath("(//RelativeLayout)[4]")).click();
	    	Thread.sleep(10000);
	    	System.out.println("Game Has Published Now");
	    	Thread.sleep(10000);
	    	List<WebElement> MyGames_3 = driver.findElements(By.id("tv_item_game_list"));
		     
		     for(int j=0;j<MyGames_2.size();j++){
		    	 
		    	 if(MyGames_3.get(j).getText().equalsIgnoreCase(EditedGamename)){
		    		
		    		 Thread.sleep(3000);
		    		 MyGames_3.get(j).click();
		    		 break;
		    	 	}
		      }
		     System.out.println("Scheduling the Published game : ");
		     Thread.sleep(5000);
			 driver.findElement(By.xpath("//ActionMenuView")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("(//RelativeLayout)[4]")).click();
			 Thread.sleep(7000);
		     
		     SchedulingGame();
	    }
	    
	        
	     
	 //Picking The Edited game
	    
	    List<WebElement> MyGames_4 = driver.findElements(By.id("tv_item_game_list"));
	    for(int j=0;j<MyGames_4.size();j++){
	    	 
	    	 if(MyGames_4.get(j).getText().equalsIgnoreCase(EditedGamename)){
	    		
	    		 Thread.sleep(3000);
	    		 MyGames_4.get(j).click();
	    		 break;
	    	 	}
	      }
	     
	     
	     
	   //Delete game
	    
	     System.out.println("\n"+ "Validating Delete Game");
	     Thread.sleep(10000);
		 String editedGameName2 = driver.findElement(By.id("tv_game_title")).getText();
		 Thread.sleep(5000);
		 if(editedGameName2.equalsIgnoreCase(EditedGamename)){
		    	System.out.println("The Randomly Picked Game Name for Sheduling  matches With Edited game name"); 
		 }else{
			    Assert.fail("The Randomly Picked Game Name for Sheduling Doesn't matches With Edited game name ");	
			    }
		 
	     
	     Thread.sleep(10000); 
	     driver.findElement(By.xpath("//ActionMenuView")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("(//RelativeLayout)[3]")).click();
	     Thread.sleep(5000);
	     
	   //Clicking on "No" option in Delete Game Popup
	     driver.findElement(By.id("button2")).click();
	     
	   //Clicking on "Yes" option in Delete Game Popup
	     Thread.sleep(5000);
	     driver.findElement(By.xpath("//ActionMenuView")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("(//RelativeLayout)[3]")).click();
	     Thread.sleep(5000);
	     driver.findElement(By.id("button1")).click();
	    
	     System.out.println("Game Succesfully Deleted");
	     
	     Thread.sleep(1000000);  
	     
	     
	    
		}
  

  @AfterMethod
  public void afterMethod() {
  }

}
