package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.TechGlobalProject4Page;
import utils.Driver;

import java.util.List;

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

        // Assert the number of rows
        Assert.assertEquals(expectedData.size(), techGlobalProject4Page.theTableRows.size());

        // Iterate through each row and assert the data
        for (int i = 0; i < expectedData.size(); i++) {
            List<String> expectedRowData = expectedData.get(i);
            List<WebElement> actualColumns = techGlobalProject4Page.theTableRows.get(i).findElements(By.cssSelector("#product_table > tbody > tr > td"));

            // Assert the number of columns
            Assert.assertEquals(expectedRowData.size(), actualColumns.size());

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
    /*@Then("the user should see the “ADD PRODUCT” button is enabled")
    public void the_user_should_see_the_add_product_button_is_enabled() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user should see the “Total = ${double}” text displayed")
    public void the_user_should_see_the_total_$_text_displayed(Double double1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    } */
}
