package com.guru.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.qa.base.GuruTestBase;

public class SearchPage extends GuruTestBase {
	
	@FindBy(xpath="//div[@class='search-toggle-open-container']")
	WebElement search;
	
	//Initializing page object
		public SearchPage() {
			PageFactory.initElements(driver, this);
		}
		
	public boolean search() {
		return search.isDisplayed();
	}
		
}
	
	
