package stepDefinitions;

import com.qa.Pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private static String title;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");



    }
    @When("user gets title of the page")
    public void user_gets_title_of_the_page() {
         title= loginPage.getLoginPageTitle();
        System.out.println(title);


    }
    @Then("forgot password link should be displayed")
    public void forgot_password_link_should_be_displayed() {
        Assert.assertTrue(loginPage.isForgotPwdLink());


    }
    @When("user enters username {string}")
    public void user_enters_username(String username) {
        loginPage.enterUsername(username);


    }
    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {

        Assert.assertTrue(title.contains(expectedTitleName));


    }
    @When("user enters password {string}")
    public void user_enters_password(String pwd) {
        loginPage.enterPassword(pwd);


    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLogin();


    }

    @Then("user gets title of the home page")
    public void user_gets_title_of_the_home_page() {



    }





    }
