package Tests;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;
import io.selendroid.device.DeviceTargetPlatform;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.annotations.Test;

public class CreateGame extends TestBase {
  
	
		/*
		 *     ---------------- CREATE A GAME -------------------------
		 */
	
		@Test
		public void creatingGame() throws Exception {
		
		// --------Clicking on Google+ Sign-in button ---------------
		
		if (!dr.findElements(By.id("btn_sign_in")).isEmpty()) {
			dr.findElement(By.id("btn_sign_in")).click();
			Thread.sleep(15000);
		}
				
		// --------Tapping 'Create Games' from Main Menu-------------
		
		dr.findElement(By.id("btn_create_game")).click();
		//dr.findElement(By.id("btn_view_activites")).click();
 		String dateForNames = date.toString(); // Storing current date in 'dateForNames' object to use this as Game Name and Description
 		
 		//-------- Creating a Name -----------------------------------
 		
 		dr.findElement(By.id("et_game_name")).sendKeys("Name " + dateForNames);
 		dr.navigate().back();
 		dr.findElement(By.id("et_game_desc")).sendKeys("Desc " + dateForNames);
 		dr.navigate().back();
 		dr.findElement(By.id("bt_newgame_next")).click();
 		Thread.sleep(3000);
 		
 		// ------ Creating 3 Notes without entering any address --------------------------------------
 		
 		for (int i = 0; i < 3; i++) {
 		
 			TouchActions locSelection = new TouchActions(dr).flick(dr.findElement(By.id("map")),0, -2000, 1000);
 			locSelection.perform();
 			Thread.sleep(3000);
 			dr.findElement(By.xpath("//ActionMenuView")).click();
 			dr.findElement(By.linkText("New Note Here")).click();
 			Thread.sleep(3000);
 			Date newDate = new Date();
 			dr.findElement(By.id("et_note_name")).sendKeys("Note " + newDate.toString());
 			dr.findElement(By.id("et_note_desc")).sendKeys("NoteDesc " + newDate.toString());
 			dr.findElement(By.id("et_note_radius")).sendKeys("100");
 			dr.navigate().back();
 			dr.findElement(By.id("bt_note_save")).click();
 			Thread.sleep(3000);
 		}

 		// --------- Adding 2 extra new notes using 'Manage Notes' option
 		
 		dr.findElement(By.xpath("//ActionMenuView")).click();
 		dr.findElement(By.linkText("View Game")).click();
 		Thread.sleep(3000);
 		
 		dr.findElement(By.xpath("//ActionMenuView")).click();
 		dr.findElement(By.linkText("Manage Notes")).click();
 		Thread.sleep(3000);
 		for (int i = 0; i < 2 ; i++) {
 			TouchActions locSelection = new TouchActions(dr).flick(dr.findElement(By.id("map")),0, -2000, 1000);
 			locSelection.perform();
 			Thread.sleep(3000);
 			dr.findElement(By.xpath("//ActionMenuView")).click();
 			dr.findElement(By.linkText("New Note Here")).click();
 			Thread.sleep(5000);
 			Date d1= new Date();
 			dr.findElement(By.id("et_note_name")).sendKeys("Note " + d1.toString());
 			dr.findElement(By.id("et_note_desc")).sendKeys("NoteDesc " + d1.toString());
 			dr.findElement(By.id("et_note_radius")).sendKeys("50");
 			dr.navigate().back();
 			dr.findElement(By.id("bt_note_save")).click();
 			Thread.sleep(3000);
 		}
 		
 		// --------- Creating a Note using long press on the map
 		
 		TouchActions longP = new TouchActions(dr).longPress(dr.findElement(By.id("map")));
 		longP.perform();
 		Thread.sleep(5000);
 		if (!dr.findElementsById("dialog_new_note").isEmpty()) {
 			dr.findElement(By.id("dialog_new_note")).click();
 	 		Thread.sleep(5000);
 	 		Date d2= new Date();
 	 		dr.findElement(By.id("et_note_name")).sendKeys("Note " + d2.toString());
 	 		dr.findElement(By.id("et_note_desc")).sendKeys("NoteDesc " + d2.toString());
 	 		dr.findElement(By.id("et_note_radius")).sendKeys("50");
 	 		dr.navigate().back();
 	 		dr.findElement(By.id("bt_note_save")).click();
 	 	}
 		Thread.sleep(3000);
 		
 		// -------- Publishing the created Game -------------------------
 		
 		dr.findElement(By.xpath("//ActionMenuView")).click();
 		dr.findElement(By.linkText("View Game")).click();
 		Thread.sleep(2000);
 		dr.findElement(By.xpath("//ActionMenuView")).click();
 		dr.findElement(By.linkText("Publish Game")).click();
 		Thread.sleep(3000);
 		while (("Name " + dateForNames).isEmpty()) {
 			TouchActions flick2 = new TouchActions(dr).flick(dr.findElement(By.id("content")), 0, -50000, 50000);
 	 		flick2.perform();
		}
 		
 		List<WebElement> justpublishedgame = dr.findElements(By.id("tv_item_game_list")); // Storing all published games into a List
 		
 		for (int i = 0; i < justpublishedgame.size(); i++) {
 			if (justpublishedgame.get(i).getText().equalsIgnoreCase("Name " + dateForNames)) {
 				String gamename = justpublishedgame.get(i).getText();
 				justpublishedgame.get(i).click();
 				System.out.println(gamename);
 				break;
 			}
 		}
 		Thread.sleep(3000);
 		
 		// ------- Scheduling the above published Game------------------------------------
 		
 		dr.findElement(By.xpath("//ActionMenuView")).click();
 		dr.findElement(By.linkText("Schedule Game")).click();
 		dr.findElement(By.id("ib_date")).click();
 		dr.findElement(By.linkText("Done")).click();
 		dr.findElement(By.id("ib_time")).click();
 		List<WebElement> timewhilecreating = dr.findElements(By
 				.id("numberpicker_input"));
 		System.out.println(timewhilecreating.size());
 		String timing = (timewhilecreating.get(1).getText() + ":" + timewhilecreating
 				.get(2).getText());
 		System.out.println(timing);
 		dr.findElement(By.linkText("Done")).click();
 		dr.findElement(By.id("bt_invite_game")).click();
 		Thread.sleep(13000);
 
 		// ------- Switching to 'Game Schedules' Screen and fining the above scheduled Game ---------------------
 		
 		dr.findElement(By.linkText("Game Schedules")).click();
 		TouchActions flick3 = new TouchActions(dr).flick(dr.findElement(By.id("content")), 0, -10000, 100);
 		flick3.perform();
 		
 		List<WebElement> scheduledgamestimewhilecreating = dr.findElements(By.id("tv_item_schedule_time"));
 		for (int i = 0; i < scheduledgamestimewhilecreating.size(); i++) {
 			if (scheduledgamestimewhilecreating.get(i).getText()
 					.contains(timing)) {
 				scheduledgamestimewhilecreating.get(i).click();
 				break;
 			}
 		}
 		Thread.sleep(3000);
 		
 		// -------- Inviting the above scheduled Game -----------------------------
 		
 		dr.findElement(By.xpath("//ActionMenuView")).click();
 		dr.findElement(By.linkText("Invite Game")).click();
 		Thread.sleep(3000);
 		TouchActions flick4 = new TouchActions(dr).flick(dr.findElement(By.id("customPanel")), 0, -100000, 1000);
 		flick4.perform();
 		dr.findElement(By.linkText("WhatsApp")).click();
 		//dr.navigate().back();
 		//dr.backgroundApp();
//		SelendroidCapabilities cap = new SelendroidCapabilities("com.whatsapp:2.11.422");
//		cap.setPlatformVersion(DeviceTargetPlatform.ANDROID19);
//		cap.setEmulator(false);
//		cap.setLaunchActivity("com.whatsapp.Main");
//		dr = new SelendroidDriver(cap);
//		dr.resumeApp();
  }
}
