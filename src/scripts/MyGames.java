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
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class MyGames {
 
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
	
	
	//New Note Method 
	  public void NewNote() throws InterruptedException{
		  Date d = new Date();
		  Thread.sleep(2000);
		  driver.findElement(By.id("bt_address_map")).click();
		  driver.findElement(By.xpath("//ActionMenuView")).click();;
		  driver.findElement(By.xpath("(//RelativeLayout)[1]")).click();
		  Thread.sleep(3000);
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
	  
	  
	
	@Test
	public void Test1() throws Exception {
		
		Date d = new Date();
//Signin Button 
	    if(!driver.findElements(By.id("btn_sign_in")).isEmpty()) {
		  	driver.findElement(By.id("btn_sign_in")).click();
		   }
		
//My Games validation
	    Thread.sleep(5000);
	    driver.findElement(By.linkText("My Games")).click();
	    System.out.println("Validating My Games tab");
	    
	    //Listing the elements & Picking Randomly in My Games
	    
	    Thread.sleep(5000);
	    List<WebElement> MyGames_1 = driver.findElements(By.id("tv_item_game_list"));
	  /*  System.out.println("Number of Games in My Games list : " + MyGames_1.size());
	    System.out.println("The List of Games are :  "+"\n");
	    for(int a=0 ;a<MyGames_1.size();a++){
	    	
	    	System.out.println(MyGames_1.get(a).getText());
	    	
	    }
	    
	    Thread.sleep(5000);*/
	    
	    Random r = new Random();
	    int Mygame_Random = r.nextInt(MyGames_1.size());
	    System.out.println("Randomly Picked Element from My Games List :"+"\n" +MyGames_1.get(Mygame_Random).getText());
	    MyGames_1.get(Mygame_Random).click();
	    
	  
	  //Display how many Notes are created & Their names
	    Thread.sleep(6000);
	    driver.findElement(By.id("tv_game_title")).getText();
	    driver.findElement(By.id("et_game_desc")).getText();;
	    List<WebElement> CreatedNoteList = driver.findElement(By.id("notes_listView")).findElements(By.id("tv_item_note_list"));
	    System.out.println("Number Of Notes Plotted : " + CreatedNoteList.size());
	    
	    for(int c=0;c<CreatedNoteList.size();c++){
	    	System.out.println("Name of the Notes :" + CreatedNoteList.get(c).getText());
	       }
	    
	    Thread.sleep(10000);
	     
	//Validating New Note Before tab.
	    
	    int n = r.nextInt(CreatedNoteList.size());
	    System.out.println("Number of Element: " +n+" ,  The Element is: "+ CreatedNoteList.get(n).getText());
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
	    Thread.sleep(10000);
	    
	 
	//Validating Update Note Button
	    List<WebElement> UpdateList = driver.findElement(By.id("notes_listView")).findElements(By.id("iv_update_note"));
	    System.out.println("Number Of Notes Created : " + UpdateList.size());
	    
	    
	    int x = r.nextInt(UpdateList.size());
	    System.out.println("Randomly picked Element for Updation is : " +x+" ,  The Element is: "+ UpdateList.get(x).getText());
	        
	    UpdateList.get(x).click();
	    Thread.sleep(5000);
	        
	    //driver.findElement(By.id("et_note_name")).clear();
	    driver.findElement(By.id("et_note_name")).sendKeys(d.toString());
	    Thread.sleep(5000);
	    
	   // driver.findElement(By.id("et_note_desc")).clear();
	     driver.findElement(By.id("et_note_desc")).sendKeys(d.toString());
	     Thread.sleep(10000);
	     
	   //driver.findElement(By.id("et_note_radius")).clear();
	    driver.findElement(By.id("et_note_radius")).sendKeys("100");
	    Thread.sleep(10000);
	    
	    driver.findElement(By.id("bt_note_save")).click();;
	    Thread.sleep(10000);
	    ViewGame();
	    Thread.sleep(6000);
	    
	//Validating Delete Note Button
	    List<WebElement> DeleteList = driver.findElement(By.id("notes_listView")).findElements(By.id("iv_delete_note"));
	    System.out.println("Number Of Notes Created : " + DeleteList.size()); 
	    
	    
	    int w = r.nextInt(DeleteList.size());
	    System.out.println("Number of Element: " +w+" ,  The Element is: "+ DeleteList.get(w).getText());
	    
	  //Clicking on "No" option in Delete Game Popup
	    DeleteList.get(w).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id("button2")).click();
	    
	  //Clicking on "Yes" option in Delete Game Popup
	    Thread.sleep(10000);
	    DeleteList.get(w).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id("button1")).click(); 
	    Thread.sleep(10000);  
	    

//Validating Action Menu in View Game Page
	    
	    //Manage Notes
	     
	     driver.findElement(By.xpath("//ActionMenuView")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("(//RelativeLayout)[1]")).click();
	     Thread.sleep(5000);
	     driver.findElement(By.id("atoText")).sendKeys("vizag,India");
	     Thread.sleep(5000);
	     NewNote();
	     Thread.sleep(5000);
	     ViewGame(); 
	    
	   //Edit game
	     
	     Thread.sleep(5000);
	     driver.findElement(By.xpath("//ActionMenuView")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("(//RelativeLayout)[2]")).click();
	     Thread.sleep(5000);
	     driver.findElement(By.id("et_game_name")).clear();
	     driver.findElement(By.id("et_game_name")).sendKeys(d.toString());
	     driver.findElement(By.id("et_game_desc")).sendKeys(d.toString());
	     Thread.sleep(3000);
	     driver.navigate().back();
	     Thread.sleep(3000);
	     driver.findElement(By.linkText("Update Game")).click();
	     //driver.findElement(By.id("bt_note_save")).click();*/
	    
	    
	   //Delete game
	     
	     Thread.sleep(5000);
	     MyGames_1.get(Mygame_Random).click();
	     Thread.sleep(5000);
	     driver.findElement(By.xpath("//ActionMenuView")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("(//RelativeLayout)[3]")).click();
	     Thread.sleep(5000);
	     
	   //Clicking on "No" option in Delete Game Popup
	     driver.findElement(By.id("button2")).click();
	     
	   //Clicking on "Yes" option in Delete Game Popup
	     Thread.sleep(10000);
	     DeleteList.get(w).click();
	     Thread.sleep(5000);
	     driver.findElement(By.id("button1")).click(); 
	     Thread.sleep(1000000);  
	     
	     
	     
	     
	     
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
  

  @AfterMethod
  public void afterMethod() {
  }

}
