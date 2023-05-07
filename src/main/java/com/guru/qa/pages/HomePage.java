package com.guru.qa.pages;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.guru.qa.base.GuruTestBase;
import com.guru.qa.util.TestUtil;

//Author @ShaheenM 

public class HomePage extends GuruTestBase{

	//PageFactory / OR:
	
	//Find list of tutorials available on home page
	@FindBy(id="java_technologies")
	WebElement list;
	
	//To verify the logo
	@FindBy(xpath="//*[@id='main-header']//img[@alt='Guru99']")
	WebElement guruLogo;
	
	//To verify title of page and its attribute
	@FindBy(xpath="//*[@id=\"post-2669\"]//h3")
	WebElement title;
	
	//To verify title of page and its attribute
	@FindBy(xpath="//*[@id=\"post-2669\"]//h3")
	WebElement titleColor;
	
	//Initializing page object
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	

	//To identify list of tutorials available
	public void validateListOfTutorials() throws StaleElementReferenceException {
		List<WebElement> allLinks = driver.findElements(By.id("java_technologies"));
		for(WebElement list: allLinks) {
			System.out.println(list.getText());
			if(list.getText().contains("QTP")) {
				list.click();	
				System.out.println("Clicked Link page title is: " +driver.getTitle());
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				break;
			}
		}
	}
	
	//To identify logo of the application if it exists
	public boolean validateGuruLogo() {
		return guruLogo.isDisplayed();
	}
	
	//To getTitle of page
	public String validateTitle() {
		return title.getText();	
	}
	
	//To get title color
	public String validateTitleColor() {
		return titleColor.getCssValue("color");
	}

}

