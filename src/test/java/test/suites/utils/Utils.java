package test.suites.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import test.suites.TestSuite1;

public class Utils {
	
	private WebDriver driver;
	private String folder;
	
	SimpleDateFormat dt = new SimpleDateFormat("yyyyy.MM.dd-hh.mm.ss");
	String datetime;
	
	private static final Logger log = 
			LogManager.getLogger(TestSuite1.class.getName());
	
	public Utils(WebDriver driver, String folder) {
		this.driver = driver;
		this.folder = folder;
		this.datetime = dt.format(new Date());
	}
	
	public void takeScreenshot(String name) {
				
		try {
			TakesScreenshot scrShot = (TakesScreenshot) driver;
			File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./screenshots/" + folder + "/" + 
							datetime + "/" + name + ".png");
			try {
				FileUtils.copyFile(scrFile, destFile);
			} catch (Exception e) {
				log.error("Couldn't save screenshot file: " + e.getMessage());
			}
		} catch (Exception e) {
			log.error("Couldn't take screenshot: " + e.getMessage());
		}
		
	}

}
