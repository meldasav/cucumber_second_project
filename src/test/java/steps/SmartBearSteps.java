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
import utils.Driver;

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

    @And("user clicks on Login button")
    public void user_clicks_on_Login_button() {
        smartBearPage.loginButton.click();

    }


    @Then("user should see {string} Message")
    public void user_should_see_Message(String text) {
        Assert.assertEquals(text, smartBearPage.errorMessage.getText());

    }

    @Then("user should be routed to {string}")
    public void userShouldBeRoutedTo(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @Then("validate below menu items are displayed")
    public void validate_below_menu_items_are_displayed(DataTable dataTable) {
        try {
            for (int i = 0; i < dataTable.asList().size(); i++) {
                Assert.assertTrue(webOrdersPage.orderMenuItems.get(i).isDisplayed());
                Assert.assertEquals(dataTable.asList().get(i), webOrdersPage.orderMenuItems.get(i).getText());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @And("user clicks on {string} button")
    public void user_clicks_on_button(String button) {
        switch (button) {
            case "Check All":
               webOrdersPage.checkAllLink.click();
                break;
            case "Uncheck All":
                webOrdersPage.uncheckAllLink.click();
                break;

        }

    }


    @Then("all rows should be checked")
    public void allRowsShouldBeChecked() {
            Assert.assertTrue(webOrdersPage.checkAllLink.isSelected());
        }

    @Then("all rows should be unchecked")
    public void allRowsShouldBeUnchecked() {
        Assert.assertFalse(webOrdersPage.uncheckAllLink.isSelected());
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String menuItem) {

         }


    @And("user selects {string} as product")
    public void userSelectsAsProduct(String arg0) {
    }

    @And("user enters {int} as quantity")
    public void userEntersAsQuantity(int arg0) {
    }

    @And("user enters all address information")
    public void userEntersAllAddressInformation() {
    }

    @And("user enters all payment information")
    public void userEntersAllPaymentInformation() {
    }

    @Then("user should see their order displayed in the {string} table")
    public void userShouldSeeTheirOrderDisplayedInTheTable(String arg0) {
    }

    @And("validate all information entered displayed correct with the order")
    public void validateAllInformationEnteredDisplayedCorrectWithTheOrder() {
    }

    @And("user clicks on {string}button")
    public void userClicksOnButton(String arg0) {
    }

    @Then("validate all orders are deleted from the {string}")
    public void validateAllOrdersAreDeletedFromThe(String arg0) {
    }

    @And("validate user sees {string}Message")
    public void validateUserSeesMessage(String arg0) {
    }
}