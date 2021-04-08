package io.github.ryszardp.page;

import io.github.ryszardp.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class RegisterPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://5element.by/registration";

    @FindBy(xpath = "//div[@id='reg-tab-bpm-email']")
    private WebElement withEmailTab;

    @FindBy(xpath = "//input[@name='NAME']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@name='PASSWORD']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='PASSWORD_RPT']")
    private WebElement passwordFieldRepeat;

    @FindBy(xpath = "//input[@name='EMAIL']")
    private WebElement emailField;

    @FindBy(xpath = "//a[@data-value='male'][@class='bpm-sex-email']")
    private WebElement sexRadioBtmMale;

    @FindBy(xpath = "//a[@data-value='female'][@class='bpm-sex-email']")
    private WebElement sexRadioBtmFemale;

    @FindBy(xpath = "//input[contains(@class,'button js-submit active')]")
    private WebElement registerButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public RegisterPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public RegisterPage clickToEmailTab() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(withEmailTab)).click();
        logger.info("Click to email tab");
        return this;
    }

    public RegisterPage typeName(User user) {
        nameField.sendKeys(user.getName());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        logger.info("Type name");
        return this;
    }

    public RegisterPage typePassword(User user) {
        passwordField.sendKeys(user.getPassword());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        logger.info("Type password");
        return this;
    }

    public RegisterPage typePasswordRepeat(User user) {
        passwordFieldRepeat.sendKeys(user.getRepeatPassword());
        logger.info("Type repeat password");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }

    public RegisterPage typeEmail(User user) {
        emailField.sendKeys(user.getEmail());
        logger.info("Type email");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }

    public RegisterPage selectSex(User user) {
        if (user.getSex().equalsIgnoreCase("male")) {
            sexRadioBtmMale.click();
        } else {
            sexRadioBtmFemale.click();
        }

        logger.info("select sex");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }

    public RegisterPage clickRegister(){
        registerButton.click();
        logger.info("click register");
        return this;
    }


}
