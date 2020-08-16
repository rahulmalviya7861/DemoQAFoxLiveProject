package com.tutorialsninja.automation.pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;

import cucumber.api.DataTable;

public class RegisterPage {
	
	public RegisterPage() {
		
		PageFactory.initElements(Base.driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"input-firstname\"]")
	public static WebElement firstName;
	
	@FindBy(xpath="//*[@id=\"input-lastname\"]")
	public static WebElement lastName;
	
	@FindBy(xpath="//*[@id=\"input-email\"]")
	public static WebElement email;
	
	@FindBy(xpath="//*[@id=\"input-telephone\"]")
	public static WebElement telephone;
	
	@FindBy(xpath="//*[@id=\"input-password\"]")
	public static WebElement password;
	
	@FindBy(xpath="//*[@id=\"input-confirm\"]")
	public static WebElement comfirmpassword;
	
	@FindBy(xpath="//*[@name=\"agree\"]")
	public static WebElement privacypolicy;
	
	@FindBy(xpath="//*[@class=\"btn btn-primary\"]")
	public static WebElement continuebutton;
	
	@FindBy(xpath="//*[@id=\"account-register\"]/ul/li[3]/a")
	public static WebElement registerBreadcrumb;
	
	@FindBy(xpath="//*[@id=\"account\"]/div[2]/div/div")
	public static WebElement firstNameWarning;
	
	@FindBy(xpath="//*[@id=\"account\"]/div[3]/div/div")
	public static WebElement lastNameWarning;
	
	@FindBy(xpath="//*[@id=\"account\"]/div[4]/div/div")
	public static WebElement emailWarning;
	
	@FindBy(xpath="//*[@id=\"account\"]/div[5]/div/div")
	public static WebElement telephoneWarning;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")
	public static WebElement passwordWarning;
	
	@FindBy(xpath="//*[@id=\"account-register\"]/div[1]")
	public static WebElement mainWarning;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")
	public static WebElement yesToNewsLetter;
	

	public static void enterAllDetails(DataTable datatable,String detailsType)
	{
		Map<String, String> map= datatable.asMap(String.class, String.class);
		Elements.TypeText(RegisterPage.firstName, map.get("FirstName"));
		Elements.TypeText(RegisterPage.lastName, map.get("LastName"));
		Elements.TypeText(RegisterPage.telephone, map.get("Telephone"));
		Elements.TypeText(RegisterPage.password, map.get("Password"));
		Elements.TypeText(RegisterPage.comfirmpassword, map.get("Password"));

		
		if(detailsType.equalsIgnoreCase("duplicate"))
			Elements.TypeText(RegisterPage.email, map.get("Email"));
		else
			Elements.TypeText(RegisterPage.email, System.currentTimeMillis() + map.get("Email"));	
		
	}
	
}
