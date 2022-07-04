package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SmartBearPage;
import pages.WebOrdersPage;
import utils.AlertHandler;
import utils.Driver;
import utils.Waiter;

import java.util.List;

public class SmartBearSteps {
    WebDriver driver;
    SmartBearPage smartBearPage;
    WebOrdersPage webOrdersPage;

    @Before
    public void setUpPages() {
        smartBearPage = new SmartBearPage();
        driver = Driver.getDriver();
    }

    @Given("user is on {string}")
    public void user_is_on(String URL) {
        driver.get(URL);

    }

    @When("user enters username as {string}")
    public void user_enters_username_as(String userName) {
        smartBearPage.userNameInputBox.sendKeys(userName);

    }

    @When("user enters password as {string}")
    public void user_enters_password_as(String password) {
        smartBearPage.passWordInputBox.sendKeys(password);

    }

    @When("user clicks on Login button")
    public void user_clicks_on_Login_button() {
        smartBearPage.loginButton.click();
    }

    @Then("user should see {string} Message")
    public void user_should_see_Message(String text) {
        Assert.assertEquals(text, smartBearPage.errorMessage.getText());

    }

    @Then("user should be routed to {string}")
    public void userShouldBeRoutedTo(String url) {
        Assert.assertEquals(url,driver.getCurrentUrl());
    }

    @Then("validate below menu items are displayed")
    public void validate_below_menu_items_are_displayed(DataTable dataTable) {
        List<String> expectedText=dataTable.asList(String.class);


           for(int i=0;i<expectedText.size();i++){
               System.out.println(expectedText);
               Assert.assertEquals(expectedText.get(i),webOrdersPage.orderMenuItems.get(i).getText());
           }


    }
        }

