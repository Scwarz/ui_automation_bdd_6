import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.Project5Pages;
import utils.Driver;

import java.util.List;

public class Project05Steps {
    WebDriver driver;
    Project5Pages project05pages;

    @Before
    public void setDriver() {
        driver = Driver.getDriver();
        project05pages = new Project5Pages();

    }

    @Given("the user is on https:\\/\\/techglobal-training.com\\/frontend\\/project{int}")
    public void the_user_is_on_https_techglobal_training_com_frontend_project(int n) {
        driver.get("https://techglobal-training.com/frontend/project-5");
    }

    @Then("the user should see the “Pagination” heading")
    public void the_user_should_see_the_pagination_heading() {
        Assert.assertTrue(project05pages.pageHeader.isDisplayed());
    }

    @Then("the user should see the “World City Populations {int}” heading")
    public void the_user_should_see_the_world_city_populations_heading(int n) {
        Assert.assertTrue(project05pages.subHeading.isDisplayed());
    }

    @Then("the user should see the “What are the most populated cities in the world? Here is a list of the top five most populated cities in the world:” paragraph")
    public void the_user_should_see_the_what_are_the_most_populated_cities_in_the_world_here_is_a_list_of_the_top_five_most_populated_cities_in_the_world_paragraph() {
        Assert.assertTrue(project05pages.headingContent.isDisplayed());
        Assert.assertEquals(project05pages.headingContent.getText(), "What are the most populated cities in the world? Here is a list of the top five" +
                " most populated cities in the world:");
    }

    @Then("the user should see the “Previous” button is disabled")
    public void the_user_should_see_the_previous_button_is_disabled() {
        Assert.assertFalse(project05pages.previousButton.isEnabled());
    }

    @Then("the user should see the “Next” button is enabled")
    public void the_user_should_see_the_next_button_is_enabled() {
        Assert.assertTrue(project05pages.nextButton.isEnabled());
    }

    @When("the user clicks on the “Next” button")
    public void the_user_clicks_on_the_next_button() {
        project05pages.nextButton.click();
    }

    @Then("the user should see the “Previous” button is enabled")
    public void the_user_should_see_the_previous_button_is_enabled() {
        Assert.assertTrue(project05pages.previousButton.isEnabled());

    }

    @When("the user clicks on the “Next” button till it becomes disabled")
    public void the_user_clicks_on_the_next_button_till_it_becomes_disabled() {
        while (project05pages.nextButton.isEnabled()) {
            project05pages.nextButton.click();
        }
    }

    @Then("the user should see the “Next” button is disabled")
    public void the_user_should_see_the_next_button_is_disabled() {
        Assert.assertFalse(project05pages.nextButton.isEnabled());
    }

    @Then("the user should see “Tokyo” City with the info below and an image")
    public void the_user_should_see_tokyo_city_with_the_info_below_and_an_image(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedResult = dataTable.asList();
        for (int i = 0; i < expectedResult.size(); i++) {
            Assert.assertTrue(project05pages.cityInfo.get(i).isDisplayed()); //
            Assert.assertEquals(project05pages.cityInfo.get(i).getText(), expectedResult.get(i)); //
        }
    }

    @Then("the user should see “Delhi” City with the info below and an image")
    public void the_user_should_see_delhi_city_with_the_info_below_and_an_image(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedResult2 = dataTable.asList();
        for (int i = 0; i < expectedResult2.size(); i++) {
            Assert.assertTrue(project05pages.cityInfo2.get(i).isDisplayed());
            Assert.assertEquals(project05pages.cityInfo2.get(i).getText(), expectedResult2.get(i));
        }
    }

    @Then("the user should see “Shangai“ City with the info below and an image")
    public void the_user_should_see_shangai_city_with_the_info_below_and_an_image(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedResult3 = dataTable.asList();
        for (int i = 0; i < expectedResult3.size(); i++) {
            Assert.assertTrue(project05pages.cityInfo3.get(i).isDisplayed());
            Assert.assertEquals(project05pages.cityInfo3.get(i).getText(), expectedResult3.get(i));
        }
    }

    @Then("the user should see “Sao Paulo“ City with the info below and an image")
    public void the_user_should_see_sao_paulo_city_with_the_info_below_and_an_image(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedResult4 = dataTable.asList();
        for (int i = 0; i < expectedResult4.size(); i++) {
            Assert.assertTrue(project05pages.cityInfo4.get(i).isDisplayed());
            Assert.assertEquals(project05pages.cityInfo4.get(i).getText(), expectedResult4.get(i));
        }
    }

    @Then("the user should see “Mexico City” City with the info below and an image")
    public void the_user_should_see_mexico_city_city_with_the_info_below_and_an_image
            (io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedResult5 = dataTable.asList();
        for (int i = 0; i < expectedResult5.size(); i++) {
            Assert.assertTrue(project05pages.cityInfo5.get(i).isDisplayed());
            Assert.assertEquals(project05pages.cityInfo5.get(i).getText(), expectedResult5.get(i));
        }

    }
}
