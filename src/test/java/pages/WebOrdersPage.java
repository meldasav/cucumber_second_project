package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class WebOrdersPage {
    public WebOrdersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//ul[@id='ctl00_menu']//a")
    public List<WebElement> orderMenuItems;

    @FindBy(xpath="//ul[@id='ctl00_menu']/li[3]/a")
    public WebElement orderLink;

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    public WebElement checkAllLink;


    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    public WebElement uncheckAllLink;



    @FindBy(css = ".CheckUncheck>a")
    public List<WebElement> checkAndUncheck;

   @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr//td[1]")
    public List<WebElement> checkBoxes;
}
