package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class TechGlobalProject4Page {
    public TechGlobalProject4Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".is-size-2")
    public WebElement inventoryHeading;

    @FindBy(xpath = "//th[@class='header has-text-white']")
    public List<WebElement> theTableHeaders;

    @FindBy(css = "#product_table > tbody > tr")
    public List<WebElement> theTableRows;

    @FindBy(css = "#product_table > tbody > tr > td")
    public List<WebElement> theTableColumns;



}
