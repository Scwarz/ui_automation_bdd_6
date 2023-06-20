package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.TechGlobalProject4Page;
import utils.Driver;
import utils.Waiter;

import java.util.List;
import java.util.NoSuchElementException;

public class TechGlobalProject4Steps {
    WebDriver driver;
    TechGlobalProject4Page techGlobalProject4Page;

    @Before
    public void setDriver(){
        driver = Driver.getDriver();
        techGlobalProject4Page = new TechGlobalProject4Page();
    }
    @Then("the user should see the {string} heading")
    public void the_user_should_see_the_inventory_heading(String headerText) {
        Assert.assertEquals(headerText, techGlobalProject4Page.inventoryHeading.getText());
    }


    @Then("the user should see the table with the headers below")
    public void the_user_should_see_the_table_with_the_headers_below(DataTable dataTable) {
        List<String> expectedText = dataTable.asList();
        for (int i = 0; i < expectedText.size(); i++) {
            Assert.assertEquals(expectedText.get(i), techGlobalProject4Page.theTableHeaders.get(i).getText());
        }
    }
    @Then("the user should see the table with the rows below")
    public void the_user_should_see_the_table_with_the_rows_below(DataTable dataTable) {
        List<List<String>> expectedData = dataTable.asLists(String.class);

        Assert.assertEquals(expectedData.size(), techGlobalProject4Page.theTableRows.size());

        for (int i = 0; i < expectedData.size(); i++) {
            List<String> expectedRowData = expectedData.get(i);
            List<WebElement> actualColumns = techGlobalProject4Page.theTableRows.get(i).findElements(By.cssSelector("td"));


            // Iterate through each column and assert the data
            for (int j = 0; j < expectedRowData.size(); j++) {
                String expectedValue = expectedRowData.get(j);
                String actualValue = actualColumns.get(j).getText();
                Assert.assertEquals(expectedValue, actualValue);
            }
        }
        /* List<List<String>> expectedData = dataTable.asLists();
        Assert.assertEquals(expectedData.size(), techGlobalProject4Page.theTableRows.size());
        for (int i = 0; i < expectedData.size(); i++) {
            //List<String> expectedRowData = expectedData.get(i);
            //List<WebElement> actualColumns = techGlobalProject4Page.theTableColumns;
            for (int j = 0; j < expectedData.get(i).size(); j++) {
                String expectedValue = expectedData.get(i).get(j);
                String actualValue = techGlobalProject4Page.theTableColumns.get(j).getText();
                Assert.assertEquals(expectedValue, actualValue);
            }
        } */
    }
    @Then("the user should see the {string} button is enabled")
    public void the_user_should_see_the_add_product_button_is_enabled(String button) {
        Assert.assertTrue(techGlobalProject4Page.addProductButton.isEnabled());
    }
    @Then("the user should see the {string} text displayed")
    public void the_user_should_see_the_total_$_text_displayed(String text) {
        Assert.assertTrue(techGlobalProject4Page.totalAmount.isDisplayed());
    }

    //TestCase02 STEPS below


    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String string) {
        switch (string){
            case "ADD PRODUCT":
                techGlobalProject4Page.addProductButton.click();
                break;
            case "X":
                techGlobalProject4Page.deleteButton.click();
                break;
            case "SUBMIT":
                techGlobalProject4Page.submitButton.click();
                break;
            default:
                throw new NotFoundException("Not Found given element");
        }
    }

    @Then("the user should see the {string} modal with its heading")
    public void the_user_should_see_the_add_new_product_modal_with_its_heading(String modalHeading) {
        Assert.assertEquals(modalHeading, techGlobalProject4Page.modalHeading.getText());
    }
    @And("the user should see the X button is enabled")
    public void the_user_should_see_the_x_button_is_enabled(String closeButton) {
        Assert.assertTrue(techGlobalProject4Page.deleteButton.isEnabled());
    }
    @And("the user should see the {string} label")
    public void the_user_should_see_the_label(String label) {
        switch (label) {
            case "Please select the quantity":
                Assert.assertTrue(techGlobalProject4Page.selectQuantityLabel.isDisplayed());
                Assert.assertEquals(techGlobalProject4Page.selectQuantityLabel.getText(), label);
                break;
            case "Please enter the name of the product":
                Assert.assertTrue(techGlobalProject4Page.nameOfProductLabel.isDisplayed());
                Assert.assertEquals(techGlobalProject4Page.nameOfProductLabel.getText(), label);
                break;
            case "Please enter the price of the product":
                Assert.assertTrue(techGlobalProject4Page.priceOfProductLabel.isDisplayed());
                Assert.assertEquals(techGlobalProject4Page.priceOfProductLabel.getText(), label);
                break;
            default:
                throw new NotFoundException("No elements have been found!");

        }
    }
    /*
    @And("the user should see the Please select the quantity label")
    public void the_user_should_see_the_select_quantity_label(String quantityLabel) {
        Assert.assertEquals(quantityLabel, techGlobalProject4Page.selectQuantityLabel.getText());
    } old way, no use */

    /*@And("the user should see the Please enter the name of the product label")
    public void the_user_should_see_the_enter_name_of_product_label(String nameProductLabel) {
        Assert.assertEquals(nameProductLabel, techGlobalProject4Page.nameOfProductLabel.getText());
    } old way, no use */
    /* @And("the user should see the Please enter the price of the product label")
    public void the_user_should_see_the_please_enter_the_price_of_the_product_label(String priceProductLabel) {
        Assert.assertEquals(priceProductLabel, techGlobalProject4Page.priceOfProductLabel.getText());
    } old way, no use */


    @And("the user should see the {string} input box is enabled")
    public void the_user_should_see_the_input_box_is_enabled(String inputBox) {
        switch (inputBox) {
            case "Quantity":
                    Assert.assertTrue(techGlobalProject4Page.inputBoxQuantity.isEnabled());
                    break;
            case "Product":
                    Assert.assertTrue(techGlobalProject4Page.inputBoxProduct.isEnabled());
                    break;
            case "Price":
                    Assert.assertTrue(techGlobalProject4Page.inputBoxPrice.isEnabled());
                    break;
            default:
                    throw new NotFoundException("No elements have been found!");

            }
    }
    /* public void the_user_should_see_the_quantity_input_box_is_enabled(String inputBox) {
            Assert.assertTrue(techGlobalProject4Page.inputBoxQuantity.isEnabled());
    }
    @And("the user should see the Product input box is enabled")
    public void the_user_should_see_the_product_input_box_is_enabled() {
        Assert.assertTrue(techGlobalProject4Page.inputBoxProduct.isEnabled());
    }

    @And("the user should see the Price input box is enabled")
    public void the_user_should_see_the_price_input_box_is_enabled() {
        Assert.assertTrue(techGlobalProject4Page.inputBoxPrice.isEnabled());
    }
    @And("the user should see the “SUBMIT” button is enabled")
    public void the_user_should_see_the_submit_button_is_enabled() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    } old way */
    @Then("the user should not see the {string} modal")
    public void the_user_should_not_see_the_modal(String error) {
        try {
            Assert.assertFalse(techGlobalProject4Page.modalPageOpened.isDisplayed());
        } catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }
    }

    @When("the user enters the quantity as {string}")
    public void the_user_enters_the_quantity_as(String string) {
        techGlobalProject4Page.inputBoxQuantity.sendKeys(string);
    }

    @When("the user enters the product as {string}")
    public void the_user_enters_the_product_as(String str) {
        techGlobalProject4Page.inputBoxProduct.sendKeys(str);

    }

    @When("the user enters the price as {string}")
    public void the_user_enters_the_price_as(String str) {
        techGlobalProject4Page.inputBoxPrice.sendKeys(str);

    }

    @Then("the user should see the table with the new row below")
    public void the_user_should_see_the_table_with_the_new_row_below(DataTable dataTable) {
        List<String> expectedResult = dataTable.asList();
        for (int i = 0; i < expectedResult.size(); i++) {
            Assert.assertTrue(techGlobalProject4Page.newRow.get(i).isDisplayed());
            Assert.assertEquals(techGlobalProject4Page.newRow.get(i).getText(), expectedResult.get(i));
        }
    }
}
