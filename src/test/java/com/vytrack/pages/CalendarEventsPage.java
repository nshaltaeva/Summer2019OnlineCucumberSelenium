package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class CalendarEventsPage extends BasePage{

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

  //  @FindBy(xpath = "//*[@class=\"btn-group\"]/button")
    @FindBy(css = "button[class*='btn dropdown-toggle']")
    public WebElement viewPerPageToggle;

    @FindBy(css = "span[class='grid-header-cell__label']")
    public List<WebElement> columnNames;

    @FindBy(css = "[class*='btn-group'] [class='dropdown-menu pull-right'] li")
    public List<WebElement> viewPerPageOptions;


    public void clickToCreateCalendarEvent(){
        BrowserUtils.waitForVisibility(createCalendarEvent, 5);
        BrowserUtils.waitForClickablility(createCalendarEvent, 5);
        createCalendarEvent.click();
    }

    /*
    Warm-UP Task:
    Write two methods, that will return:
        1. list of options from "view per page" dropdown as list of strings.
        2. list of column names  as list of strings.
    You can use qa1.vytrack.com environment and Calendar Events page.
public List<String> getViewPerPageOptions(){
}
public List<String> getColumnNames(){
}
     */

    public List<String> getColumnNames(){
        return BrowserUtils.getListOfString(columnNames);
    }

    public List<String> getViewPerPageOptions(){
        BrowserUtils.waitForVisibility(viewPerPageToggle, 10);
        BrowserUtils.clickWithWait(viewPerPageToggle);
        return BrowserUtils.getListOfString(viewPerPageOptions);
    }

}