package io.github.ryszardp.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://5element.by/registration";

    @FindBy(xpath = "//div[@id='reg-tab-bpm-email']")
    private WebElement withEmailTab;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public RegisterPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public RegisterPage clickToEmailTab(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(withEmailTab)).click();
        logger.info("Click to email tab");
        return this;
    }

    
}
