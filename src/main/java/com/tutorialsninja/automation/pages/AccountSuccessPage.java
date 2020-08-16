package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;

public class AccountSuccessPage {

	
public AccountSuccessPage() {
		
		PageFactory.initElements(Base.driver, this);
	}
	
	
	@FindBy(xpath="//*[@id=\"common-success\"]/ul/li[3]/a")
	public static WebElement successBreadCrumb;
	
}
