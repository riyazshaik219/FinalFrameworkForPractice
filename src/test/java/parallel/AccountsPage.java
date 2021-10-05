package parallel;

import com.qa.Pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class AccountsPage {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private com.qa.Pages.AccountsPage accountsPage;

    @Given("user has already logged into application")
    public void user_has_already_logged_into_application(DataTable dataTable){
        List<Map<String,String>> credList=dataTable.asMaps();
        String userName=credList.get(0).get("username");
        String password=credList.get(0).get("password");

        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        accountsPage=loginPage.doLogin(userName,password);


    }
    @Given("user is on accounts page")
    public void user_is_on_accounts_page() {
        accountsPage.getaccountsPagetitle();


    }

    @Then("user gets account section")
    public void user_gets_account_section(DataTable sectionsTable) {
       List<String> expectedList= sectionsTable.asList();
       System.out.println(expectedList);

      List<String>actualList= accountsPage.getSectionList();
      System.out.println(actualList);

      Assert.assertTrue(expectedList.containsAll(actualList));


    }

    @Then("accounts section should be {int}")
    public void accounts_section_should_be(Integer expected) {
        Assert.assertTrue(accountsPage.getSectionCount()==expected);



    }
}
