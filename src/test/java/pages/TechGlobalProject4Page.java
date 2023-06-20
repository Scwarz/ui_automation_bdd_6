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

    @FindBy(id = "add_product_btn")
    public WebElement addProductButton;

    @FindBy(id = "total_amount")
    public WebElement totalAmount;

    @FindBy(id = "modal_title")
    public WebElement modalHeading;

    @FindBy(css = "modal-card-body")
    public WebElement modalPageOpened;

    @FindBy(css = ".delete")
    public WebElement deleteButton;

    @FindBy(xpath = "//label[@for='product_quantity']")
    public WebElement selectQuantityLabel;

    @FindBy(id = "quantity")
    public WebElement inputBoxQuantity;

    @FindBy(xpath = "//label[@for='product_name']")
    public WebElement nameOfProductLabel;

    @FindBy(xpath = "//input[@id='product']")
    public WebElement inputBoxProduct;
    @FindBy(xpath = "//label[@for='product_price']")
    public WebElement priceOfProductLabel;

    @FindBy(xpath = "//input[@id='price']")
    public WebElement inputBoxPrice;

    @FindBy(id ="submit")
    public  WebElement submitButton;

    @FindBy(css = "tr:nth-child(4) td")
    public List<WebElement> newRow;
}
