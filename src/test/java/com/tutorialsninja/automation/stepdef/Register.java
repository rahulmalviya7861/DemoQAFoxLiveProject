package com.tutorialsninja.automation.stepdef;

import java.util.Map;

import org.junit.Assert;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.AccountSuccessPage;
import com.tutorialsninja.automation.pages.HeaderSection;
import com.tutorialsninja.automation.pages.RegisterPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Register {
	
	HeaderSection headersection = new HeaderSection();
	RegisterPage registerpage = new RegisterPage();
	AccountSuccessPage accountSuccessPage = new AccountSuccessPage();
	 
	@Given("^I launch the application$")
	public void i_launch_the_application()  {
		Base.driver.get(Base.reader.getUrl());
	 
	}

	@And("^I navigate to Account Registration page$")
	public void i_navigate_to_Account_Registration_page()  {
	  
		Elements.click(HeaderSection.myAccountLink); 
		Elements.click(HeaderSection.register);
		
	}

	@When("^I provide all the below valid details$")
	public void i_provide_all_the_below_valid_details(DataTable datatable)  {
	 
	RegisterPage.enterAllDetails(datatable, "unique");
	
	}

	@And("^I select the Privacy Policy$")
	public void i_select_the_Privacy_Policy()  {
		
		Elements.click(RegisterPage.privacypolicy);
	
	}

	@And("^I click on Continue button$")
	public void i_click_on_Continue_button()  {
	 
		Elements.click(RegisterPage.continuebutton);
		
	}

	@Then("^I should see that the User Account has successfully created$")
	public void i_should_see_that_the_User_Account_has_successfully_created()  {
	   
		Assert.assertTrue(Elements.isDisplayed(AccountSuccessPage.successBreadCrumb));
	}
	
	
	@Then("^I should see that the User Account is not created$")
	public void i_should_see_that_the_User_Account_is_not_created()  {
	    
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.registerBreadcrumb));
		
	}

	@Then("^I should see the error messages informing the user to fill the mandatory fields$")
	public void i_should_see_the_error_messages_informing_the_user_to_fill_the_mandatory_fields()  {
	 
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.firstNameWarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.lastNameWarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.emailWarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.telephoneWarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.passwordWarning));
		Assert.assertTrue(Elements.isDisplayed(RegisterPage.mainWarning));	
		
	}
	
	@And("^I subscribe to Newsletter$")
	public void i_subscribe_to_Newsletter()  {	
		Elements.click(RegisterPage.yesToNewsLetter);
			}

	@When("^I provide the below duplicate details into the fields$")
	public void i_provide_the_below_duplicate_details_into_the_fields(DataTable datatable1)  {
	 
		RegisterPage.enterAllDetails(datatable1, "duplicate");
	}

	@Then("^I should see the warning message stating that the user is already created$")
	public void i_should_see_the_warning_message_stating_that_the_user_is_already_created()  {
	  
		Assert.assertTrue(Elements.VerifyTextEquals(RegisterPage.mainWarning, "Warning: E-Mail Address is already registered!"));
		
	}
	
}
