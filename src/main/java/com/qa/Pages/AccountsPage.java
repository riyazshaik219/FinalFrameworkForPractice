package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {

    private WebDriver driver;

    private By accountsSection=By.cssSelector("div#center_column span");

    public AccountsPage(WebDriver driver){
        this.driver=driver;

    }

    public int getSectionCount(){
        return driver.findElements(accountsSection).size();
    }
    public String getaccountsPagetitle(){
        return driver.getTitle();
    }
    public List<String> getSectionList(){
        List<String> accountsList= new ArrayList<>();
        List<WebElement> accountsHeaderList=driver.findElements(accountsSection);
        for(WebElement e:accountsHeaderList )
        {
           String text= e.getText();
           System.out.println(text);
           accountsList.add(text);
        }
        return accountsList;
    }

}
