package com.guru.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru.qa.base.GuruTestBase;
import com.guru.qa.pages.SearchPage;

public class SearchPageTest extends GuruTestBase{
	
	SearchPage searchPage;
	
	public SearchPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		searchPage = new SearchPage();
	}
	
	@Test
	public void searchButton()
	{
		searchPage.search();		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
