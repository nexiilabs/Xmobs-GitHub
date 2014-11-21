package scripts;

import java.net.URL;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.ListView;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidKeys;
import io.selendroid.SelendroidLauncher;
import io.selendroid.device.DeviceTargetPlatform;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
//import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.SystemClock;



//import com.opera.core.systems.mobile.MobileDevices;

public class CreateGameAndInvite {
	private SelendroidLauncher selendroidServer = null;
	public static SelendroidDriver dr = null;
	// WebDriver dr1 = null;
	public static Date date = new Date();

	@Test
	public void FirstTEST() throws Exception {
		if (selendroidServer != null) {
			selendroidServer.stopSelendroid();
		}
		SelendroidConfiguration config = new SelendroidConfiguration();
		config.addSupportedApp("D:\\Selendroid\\LapsiTreasureHunt (13).apk");
		config.addSupportedApp("D:\\Selendroid\\com.whatsapp.apk");
		selendroidServer = new SelendroidLauncher(config);
		selendroidServer.launchSelendroid();
		SelendroidCapabilities capa = new SelendroidCapabilities("com.nexii.treasurehunt:1.0");
		capa.setPlatformVersion(DeviceTargetPlatform.ANDROID19);
		capa.setEmulator(false);
		URL url = new URL("http://localhost:4444/wd/hub");
		capa.setLaunchActivity("com.nexii.treasurehunt.SplashScreen");
		//this.dr = new EventFiringWebDriver(new SelendroidDriver(new URL("http://localhost:4444/wd/hub"), capa));
		dr = new SelendroidDriver(url,capa);
		Thread.sleep(2000);
		if (!dr.findElements(By.id("btn_sign_in")).isEmpty()) {
			dr.findElement(By.id("btn_sign_in")).click();
			Thread.sleep(5000);
		}
		System.out.println("hello hello");
		// dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// dr.findElement(By.id("btn_join_game")).click();
		// /*
		// * ------ Current
		// Games-----------------------------------------------------------------
		// */
		// dr.findElement(By.linkText("Current Games")).click();
		// List<WebElement> currentgames =
		// dr.findElements(By.id("tv_item_joined_game_name"));
		// if (currentgames.isEmpty()) {
		// System.out.println("There are no current games");
		// }
		// System.out.println("There are"+" "+currentgames.size()+" "+"current games");
		// for (int i = 0; i < currentgames.size(); i++) {
		// Thread.sleep(15000);
		// System.out.println(currentgames.get(i).getText());
		// currentgames.get(i).click();
		// Thread.sleep(15000);
		// dr.navigate().back();
		//
		// dr.navigate().back();
		// }
		//
		// /*
		// * ------- Waiting
		// Games--------------------------------------------------------------
		// */
		// System.out.println(dr.getPageSource());
		// dr.findElement(By.linkText("Waiting Games")).click();
		// List<WebElement> waitinggames =
		// dr.findElements(By.id("tv_item_joined_game_name"));
		//
		// if (waitinggames.isEmpty()) {
		// System.out.println("There are no waiting games");
		// }
		// System.out.println("There are"+" "+waitinggames.size()+" "+"waiting games in your list");
		//
		// for (int j = 0; j < waitinggames.size(); j++) {
		// Thread.sleep(15000);
		// System.out.println(waitinggames.get(j).getText());
		// waitinggames.get(j).click();
		// Thread.sleep(15000);
		// if (dr.findElements(By.linkText("Waiting Games")).size() == 0) {
		// dr.navigate().back();
		// dr.navigate().back();
		// }
		//
		// }
		//
		// /*
		// * -------- completed
		// Games---------------------------------------------------------
		// */
		//
		// dr.findElement(By.linkText("Completed Games")).click();
		// List<WebElement> completedgames =
		// dr.findElements(By.id("tv_item_joined_game_name"));
		// if (completedgames.isEmpty()) {
		// System.out.println("There are no completed games");
		// }
		// System.out.println("There are"+" "+completedgames.size()+" "+"completed games");
		// for (int k = 0; k < completedgames.size(); k++) {
		// System.out.println(completedgames.get(k).getText());
		// dr.navigate().back();
		//
		// }

		/*
		 * ------------ My Games----------------------------------------------
		 */

			dr.findElement(By.id("btn_view_activites")).click();
			Thread.sleep(5000);
			dr.findElement(By.linkText("Games")).click();
			List<WebElement> createdgames =	dr.findElements(By.id("tv_item_game_list"));
			System.out.println(createdgames.size());
			for (int i = 0; i < createdgames.size(); i++) {
				System.out.println(createdgames.get(i).getText());
			}
			createdgames.get(0).click();
			Thread.sleep(5000);
			dr.findElement(By.xpath("//ActionMenuView")).click();
			Thread.sleep(5000);
			dr.findElement(By.linkText("Manage Notes")).click();
			//Thread.sleep(5000);
			if (!dr.findElements(By.id("alertTitle")).isEmpty()) {
				dr.navigate().back();
			}
			Thread.sleep(5000);
			dr.findElement(By.id("atoText")).sendKeys("pune");
			Thread.sleep(5000);
		// // System.out.println(dr.getPageSource());
			dr.findElement(By.xpath("//ActionMenuView")).click();
			dr.findElement(By.linkText("New Note Here")).click();
			Thread.sleep(5000);
			Date d3 = new Date();
			dr.findElement(By.id("et_note_name")).sendKeys("Note "+d3.toString());
			dr.findElement(By.id("et_note_desc")).sendKeys("Desc "+d3.toString());
			dr.findElement(By.id("et_note_radius")).sendKeys("10");
			dr.navigate().back();
			dr.findElement(By.id("bt_note_save")).click();
			Thread.sleep(10000);
			dr.findElement(By.xpath("//ActionMenuView")).click();
			dr.findElement(By.linkText("View Game")).click();
			Thread.sleep(5000);
			dr.findElement(By.id("iv_update_note")).click();
//			List<WebElement> notescount = dr.findElements(By.id("iv_update_note"));
//			System.out.println(notescount.size());
//			Random r = new Random();
//			int editnote = r.nextInt(notescount.size());
////			//((JavascriptExecutor)dr).executeScript("arguments[0].click();", notescount.get(editnote));
////			System.out.println(notescount.size());
//			Thread.sleep(5000);
//			int attempts = 0;
//			while (attempts < 10) {
//				try {
//					notescount.get(editnote).click();
//					break;
//				} catch (Exception e) {
//					// TODO: handle exception
//					System.out.println("the this");
//					attempts++;
//				}
//			}
			
			Thread.sleep(5000);
			dr.findElement(By.id("et_note_name")).sendKeys("edited ");
			dr.findElement(By.id("et_note_desc")).sendKeys("edited ");
			dr.findElement(By.id("et_note_radius")).sendKeys("0");
			dr.navigate().back();
			dr.findElement(By.id("bt_note_save")).click();

			  // Deleting Note
			
			Thread.sleep(3000);
			dr.findElement(By.xpath("//ActionMenuView")).click();
			dr.findElement(By.linkText("View Game")).click();
			Thread.sleep(7000);
//			List<WebElement> notesCountOfNewNote = dr.findElements(By.id("iv_delete_note"));
//			int deletingnote = r.nextInt(notesCountOfNewNote.size());
			//((JavascriptExecutor)dr).executeScript("arguments[0].click();", notesCountOfNewNote.get(deletingnote));
			dr.findElementById("iv_delete_note").click();
			dr.findElement(By.linkText("OK")).click();
			Thread.sleep(5000);
			dr.findElement(By.xpath("//ActionMenuView")).click();
			dr.findElement(By.linkText("Edit Game")).click();
			Thread.sleep(3000);
			dr.findElement(By.id("et_game_name")).sendKeys("+updated");
			dr.findElement(By.id("et_game_desc")).sendKeys("+updated");
			dr.navigate().back();
			dr.findElement(By.id("bt_newgame_next")).click();
			Thread.sleep(4000);
			List<WebElement> editedcreatedgame = dr.findElements(By.id("tv_item_game_list"));
			editedcreatedgame.get(0).click();
			dr.findElement(By.xpath("//ActionMenuView")).click();
			if (!dr.findElementsByLinkText("Publish Game").isEmpty()) {
				dr.findElement(By.linkText("Publish Game")).click();
			}
			Thread.sleep(6000);
			//dr.findElement(By.xpath("//ActionMenuView")).click();
			dr.findElement(By.linkText("Schedule Game")).click();
			dr.findElement(By.id("ib_date")).click();
			dr.findElement(By.linkText("Done")).click();
			dr.findElement(By.id("ib_time")).click();
			List<WebElement> time = dr.findElements(By.id("numberpicker_input"));
			System.out.println(time.size());
			String timing = (time.get(1).getText()+":"+time.get(2).getText());
			System.out.println(timing);
			dr.findElement(By.linkText("Done")).click();
			dr.findElement(By.id("bt_invite_game")).click();
			Thread.sleep(15000);
//			dr.navigate().back();
//			dr.navigate().back();
			Thread.sleep(10000);
		//
		dr.findElement(By.linkText("Game Schedules")).click();
		TouchActions flick = new TouchActions(dr).flick(dr.findElement(By.id("content")), 0, -2000,100);
		flick.perform();
		 List<WebElement> scheduledgamestime = dr.findElements(By.id("tv_item_schedule_time"));
		//
		for (int j = 0; j < scheduledgamestime.size(); j++) {
			if (scheduledgamestime.get(j).getText().contains(timing)) {
				scheduledgamestime.get(j).click();
				dr.findElement(By.xpath("//ActionMenuView")).click();
				dr.findElement(By.linkText("Invite Game")).click();
				break;
			}
		}
		//
		TouchActions flick1 = new TouchActions(dr).flick(dr.findElement(By.id("customPanel")), 0,-1000, 100);
		flick1.perform();
		dr.findElement(By.linkText("WhatsApp")).click();
//		dr.switchTo().window("NATIVE_APP");
//		((JavascriptExecutor)dr).executeScript("arguments[0].click();",
//		// dr.findElement(By.linkText("Nexiians QA")));
		// ((JavascriptExecutor)dr).executeScript("arguments[0].click();",
		// dr.findElement(By.linkText("OK")));
		//
		
		/*
		 * ------------ Create a Game---------------
		 */
		
//		dr.findElement(By.id("btn_create_game")).click();
//		String s = date.toString();
//
//		dr.findElement(By.id("et_game_name")).sendKeys("Name " + s);
//		dr.navigate().back();
//		dr.findElement(By.id("et_game_desc")).sendKeys("Desc " + s);
//		dr.navigate().back();
//		dr.findElement(By.id("bt_newgame_next")).click();
//		Thread.sleep(3000);
//				
//		for (int i = 0; i < 3; i++) {
//		
//			TouchActions locSelection = new TouchActions(dr).flick(dr.findElement(By.id("map")),0, -2000, 1000);
//			locSelection.perform();
//			Thread.sleep(5000);
//			
//			dr.findElement(By.xpath("//ActionMenuView")).click();
//			dr.findElement(By.linkText("New Note Here")).click();
//			Thread.sleep(5000);
//			Date d = new Date();
//			dr.findElement(By.id("et_note_name")).sendKeys("Note " + d.toString());
//			dr.findElement(By.id("et_note_desc")).sendKeys("NoteDesc " + d.toString());
//			dr.findElement(By.id("et_note_radius")).sendKeys("100");
//			dr.navigate().back();
//			dr.findElement(By.id("bt_note_save")).click();
//			Thread.sleep(3000);
//		}
//		
//		dr.findElement(By.xpath("//ActionMenuView")).click();
//		dr.findElement(By.linkText("View Game")).click();
//		Thread.sleep(5000);
//		
//		dr.findElement(By.xpath("//ActionMenuView")).click();
//		dr.findElement(By.linkText("Manage Notes")).click();
//		Thread.sleep(5000);
//		for (int i = 0; i < 2 ; i++) {
//			TouchActions locSelection = new TouchActions(dr).flick(dr.findElement(By.id("map")),0, -2000, 1000);
//			locSelection.perform();
//			Thread.sleep(3000);
//			dr.findElement(By.xpath("//ActionMenuView")).click();
//			dr.findElement(By.linkText("New Note Here")).click();
//			Thread.sleep(5000);
//			Date d1= new Date();
//			dr.findElement(By.id("et_note_name")).sendKeys("Note " + d1.toString());
//			dr.findElement(By.id("et_note_desc")).sendKeys("NoteDesc " + d1.toString());
//			dr.findElement(By.id("et_note_radius")).sendKeys("50");
//			dr.navigate().back();
//			dr.findElement(By.id("bt_note_save")).click();
//			Thread.sleep(3000);
//		}
//		
//		
//		TouchActions longP = new TouchActions(dr).longPress(dr.findElement(By.id("map")));
//		longP.perform();
//		Thread.sleep(5000);
//		dr.findElement(By.id("dialog_new_note")).click();
//		Thread.sleep(5000);
//		Date d2= new Date();
//		dr.findElement(By.id("et_note_name")).sendKeys("Note " + d2.toString());
//		dr.findElement(By.id("et_note_desc")).sendKeys("NoteDesc " + d2.toString());
//		dr.findElement(By.id("et_note_radius")).sendKeys("50");
//		dr.navigate().back();
//		dr.findElement(By.id("bt_note_save")).click();
//		Thread.sleep(3000);
//		
//		dr.findElement(By.xpath("//ActionMenuView")).click();
//		dr.findElement(By.linkText("View Game")).click();
//		Thread.sleep(2000);
//
//		dr.findElement(By.xpath("//ActionMenuView")).click();
//		dr.findElement(By.linkText("Publish Game")).click();
//		Thread.sleep(10000);
//		TouchActions flick2 = new TouchActions(dr).flick(dr.findElement(By.id("content")), 0, -50000, 50000);
//		flick2.perform();
//
//		List<WebElement> justpublishedgame = dr.findElements(By.id("tv_item_game_list"));
//		for (int i = 0; i < justpublishedgame.size(); i++) {
//			if (justpublishedgame.get(i).getText().equalsIgnoreCase("Name " + s)) {
//				String gamename = justpublishedgame.get(i).getText();
//				justpublishedgame.get(i).click();
//				System.out.println(gamename);
//				break;
//			}
//		}
//		Thread.sleep(3000);
//		dr.findElement(By.xpath("//ActionMenuView")).click();
//		dr.findElement(By.linkText("Schedule Game")).click();
//		dr.findElement(By.id("ib_date")).click();
//		dr.findElement(By.linkText("Done")).click();
//		dr.findElement(By.id("ib_time")).click();
//		List<WebElement> timewhilecreating = dr.findElements(By
//				.id("numberpicker_input"));
//		System.out.println(timewhilecreating.size());
//		String timing = (timewhilecreating.get(1).getText() + ":" + timewhilecreating
//				.get(2).getText());
//		System.out.println(timing);
//		dr.findElement(By.linkText("Done")).click();
//		dr.findElement(By.id("bt_invite_game")).click();
//		Thread.sleep(13000);
//
//		dr.findElement(By.linkText("Game Schedules")).click();
//		
//		TouchActions flick3 = new TouchActions(dr).flick(dr.findElement(By.id("content")), 0, -10000, 100);
//		flick3.perform();
//		
//		List<WebElement> scheduledgamestimewhilecreating = dr.findElements(By.id("tv_item_schedule_time"));
//		for (int i = 0; i < scheduledgamestimewhilecreating.size(); i++) {
//			if (scheduledgamestimewhilecreating.get(i).getText()
//					.contains(timing)) {
//				scheduledgamestimewhilecreating.get(i).click();
//				break;
//			}
//		}
//		Thread.sleep(3000);
//		dr.findElement(By.xpath("//ActionMenuView")).click();
//		dr.findElement(By.linkText("Invite Game")).click();
//		Thread.sleep(3000);
//		TouchActions flick4 = new TouchActions(dr).flick(dr.findElement(By.id("customPanel")), 0, -100000, 1000);
//		flick4.perform();
//		dr.findElement(By.linkText("WhatsApp")).click();
//		Thread.sleep(15000);
//
//		SelendroidCapabilities cap = new SelendroidCapabilities("com.whatsapp:2.11.422");
//		cap.setPlatformVersion(DeviceTargetPlatform.ANDROID19);
//		cap.setEmulator(false);
//		cap.setLaunchActivity("com.whatsapp.Main");
//		
//		Thread.sleep(10000);
//		dr.findElement(By.linkText("444444")).click();
//		dr = new SelendroidDriver(cap);
		 
	}
}