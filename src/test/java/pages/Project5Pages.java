package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import javax.swing.text.html.CSS;
import java.util.List;

public class Project5Pages {
    public Project5Pages() {
        PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(css = ".is-size-2")
    public WebElement pageHeader;

    @FindBy(id = "sub_heading")
    public WebElement subHeading;

    @FindBy(css = "p[id='content']")
    public WebElement headingContent;

    @FindBy(css = "button[id='previous']")
    public WebElement previousButton;

    @FindBy(css = "button[id='next']")
    public WebElement nextButton;

    @FindBy(css = "div[class*='Pagination_pagBodyData'] p")
    public List<WebElement> cityInfo;

    @FindBy(css = "div[class*='Pagination_pagBodyData'] p")
    public List<WebElement> cityInfo2;

    @FindBy(css = "div[class*='Pagination_pagBodyData'] p")
    public List<WebElement> cityInfo3;

    @FindBy(css = "div[class*='Pagination_pagBodyData'] p")
    public List<WebElement> cityInfo4;

    @FindBy(css = "div[class*='Pagination_pagBodyData'] p")
    public List<WebElement> cityInfo5;
}
