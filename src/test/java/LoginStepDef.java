
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class LoginStepDef {
    public WebDriver driver = new EdgeDriver();

    @Given("I am on main page")
    public void i_am_on_main_page() throws Throwable {

        driver.get("https://www.fashionette.de/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    //region Scenario1
    @Then("I press on login page")
    public void iPressOnLoginPage() throws Throwable {
        //accept the cookies
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = driver.findElement(By.cssSelector("#usercentrics-root"));
        SearchContext context = element.getShadowRoot();
        WebElement cookieAcceptAll = context.findElement(By.cssSelector("button[data-testid='uc-accept-all-button']"));
        cookieAcceptAll.click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginPage = driver.findElement(By.xpath("/html/body/header/div[2]/div/div[2]/div[1]/a"));
        loginPage.click();
    }

    @Then("I enter email")
    public void iEnterEmail() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailAdd = driver.findElement(By.xpath("//*[@id=\"form-login\"]/div[1]/div[1]/input"));
        if (emailAdd.isDisplayed()) {
            emailAdd.sendKeys("QA@fashionette.de");
        } else {
            throw new RuntimeException("EmailAddress is not displayed, check the element selector");
        }
    }

    @Then("I enter password")
    public void iEnterPassword() {
        WebElement password = driver.findElement(By.xpath("//*[@id=\"form-login\"]/div[2]/input"));
        if (password.isDisplayed()) {
            password.sendKeys("!8Ntr*BM@!#G3VH");
        } else {
            throw new RuntimeException("Password is not displayed, check the element selector");
        }
    }

    @And("I click Login button")
    public void iClickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"form-login\"]/div[5]/div"));
        if (loginButton.isDisplayed()) {
            loginButton.click();
        } else {
            throw new RuntimeException("Button for Login is not displayed, check the element selector");
        }
    }

    @Then("I see dashboard")
    public void iSeeDashboard() {
        WebElement dashboard = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div/div[1]/div/span[2]"));
        if (dashboard.isDisplayed()) {
            String dashboardText = dashboard.getText();
            String ExpectedTitle = "Willkommen in Deinem Kundenkonto.";
            Assert.assertEquals(ExpectedTitle, dashboardText);

        } else {
            throw new RuntimeException("Dashboard is not displayed, check the element selector");
        }
    }

    //endregion

    //region Scenario2
    @Then("I see error message for email")
    public void iSeeErrorMessageForEmail() {
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"email-error\"]"));
        if (errorMessage.isDisplayed()) {
            String text = errorMessage.getText();
            String expectedTitle = "Bitte gib Deine E-Mail-Adresse ein.";
            Assert.assertEquals(expectedTitle, text);
            driver.quit();
        }
    }

    //endregion

    //region Scenario 3
    @Then("I see error message for password")
    public void iSeeErrorMessageForPassword() {
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"password-error\"]"));
        if (errorMessage.isDisplayed()) {
            String text = errorMessage.getText();
            String expectedTitle = "Bitte gib Dein Passwort ein.";
            Assert.assertEquals(expectedTitle, text);
            driver.quit();
        }
    }

    //endregion

    //region Scenario 4
    @Then("I enter wrong password")
    public void iEnterWrongPassword() {
        WebElement password = driver.findElement(By.xpath("//*[@id=\"form-login\"]/div[2]/input"));
        if (password.isDisplayed()) {
            password.sendKeys("!8Ntr*BM@!#G3");
        } else {
            throw new RuntimeException("Password is not displayed, check the element selector");
        }
    }

    @Then("I see error message for password\\/email")
    public void iSeeErrorMessageForPasswordEmail() {
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"form-login\"]/div[4]"));
        if (errorMessage.isDisplayed()) {
            String text = errorMessage.getText();
            String expectedTitle = "\n" +
                    "                    Das hat leider nicht funktioniert. Bitte überprüfe Deine E-Mail Adressse und Dein Passwort. Solltest du Dein Passwort vergessen haben, kannst Du ein neues Passwort anfordern, indem Du auf \"Passwort vergessen\" klickst.\n" +
                    "            ";
            Assert.assertEquals(expectedTitle, text);
            driver.quit();
        }
        //endregion

    }

    //endregion

    //region Scenario 5
    @Then("I enter wrong email")
    public void iEnterWrongEmail() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailAdd = driver.findElement(By.xpath("//*[@id=\"form-login\"]/div[1]/div[1]/input"));
        if (emailAdd.isDisplayed()) {
            emailAdd.sendKeys("QA@fashionette.d");
        } else {
            throw new RuntimeException("EmailAddress is not displayed, check the element selector");
        }
    }

    @Then("I see error message for email credential")
    public void iSeeErrorMessageForEmailCredential() {
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"email-error\"]"));
        if (errorMessage.isDisplayed()) {
            String text = errorMessage.getText();
            String expectedTitle = "Bitte gib Deine E-Mail Adresse im richtigen Format an. Sie muss ein @ und einen . enthalten.";
            Assert.assertEquals(expectedTitle, text);
            driver.quit();
        }
        //endregion
    }
    //endregion

    //region Scenario 6
    @Then("I enter wrong password even not the characters and required size")
    public void iEnterWrongPasswordEvenNotTheCharactersAndRequiredSize() {
        WebElement password = driver.findElement(By.xpath("//*[@id=\"form-login\"]/div[2]/input"));
        if (password.isDisplayed()) {
            password.sendKeys("il1");
        } else {
            throw new RuntimeException("Password is not displayed, check the element selector");
        }
    }

    @Then("I see error message for email and password credential")
    public void iSeeErrorMessageForEmailAndPasswordCredential() {
        WebElement emailError = driver.findElement(By.xpath("//*[@id=\"password-error\"]"));
        if (emailError.isDisplayed()) {
            String dashboardText = emailError.getText();
            String ExpectedTitle = "Das Passwort muss mindestens 8 Zeichen lang sein und mindestens eine Zahl enthalten.";
            Assert.assertEquals(ExpectedTitle, dashboardText);
            driver.quit();
        } else {
            throw new RuntimeException("Dashboard is not displayed, check the element selector");
        }

    }

    //endregion

    //region Scenario 7
    @Then("I leave empty email")
    public void iLeaveEmptyEmail() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailAdd = driver.findElement(By.xpath("//*[@id=\"form-login\"]/div[1]/div[1]/input"));
        if (emailAdd.isDisplayed()) {
            emailAdd.sendKeys(" ");
        } else {
            throw new RuntimeException("EmailAddress is not displayed, check the element selector");
        }
    }

    @Then("I leave empty password")
    public void iLeaveEmptyPassword() {
        WebElement password = driver.findElement(By.xpath("//*[@id=\"form-login\"]/div[2]/input"));
        if (password.isDisplayed()) {
            password.click();
        } else {
            throw new RuntimeException("Password is not displayed, check the element selector");
        }
    }

    @And("the error for email appears")
    public void theErrorForEmailAppears() {
        WebElement error = driver.findElement(By.xpath("//*[@id=\"email-error\"]"));
        if (error.isDisplayed()) {
            String dashboardText = error.getText();
            String ExpectedTitle = "Bitte gib Deine E-Mail-Adresse ein.";
            Assert.assertEquals(ExpectedTitle, dashboardText);
            driver.quit();
        } else {
            throw new RuntimeException("Dashboard is not displayed, check the element selector");
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @And("error for password appears")
    public void errorForPasswordAppears() {
        WebElement error = driver.findElement(By.xpath("//*[@id=\"password-error\"]"));
        if (error.isDisplayed()) {
            String dashboardText = error.getText();
            String ExpectedTitle = "Bitte gib Dein Passwort ein.";
            Assert.assertEquals(ExpectedTitle, dashboardText);
            driver.quit();
        } else {
            throw new RuntimeException("Dashboard is not displayed, check the element selector");
        }
    }


    //endregion

    //region Scenario 8
    @Then("I press Forgot Password?")
    public void iPressForgotPassword() {
        WebElement forgotPassword = driver.findElement(By.xpath("//*[@id=\"form-login\"]/div[3]/a"));
        if (forgotPassword.isDisplayed()) {
            forgotPassword.click();
        } else {
            throw new RuntimeException("Forgot Password is not displayed, check the element selector");
        }
    }

    @Then("I should enter my email")
    public void iShouldEnterMyEmail() {
        WebElement enterEmail = driver.findElement(By.xpath("//*[@id=\"form-forgot-password\"]/div[1]/div[1]/input"));
        if (enterEmail.isDisplayed()) {
            enterEmail.sendKeys("QA@fashionette.de");
        } else {
            throw new RuntimeException("Forgot Password is not displayed, check the element selector");
        }
    }

    @And("press reset password")
    public void pressResetPassword() {
        WebElement resetPassword = driver.findElement(By.xpath("//*[@id=\"form-forgot-password\"]/div[2]/div"));
        if (resetPassword.isDisplayed()) {
            resetPassword.click();
        } else {
            throw new RuntimeException("reset button is not displayed, check the element selector");
        }
    }

    @Then("I should see a page that informs me to check email")
    public void iShouldSeeAPageThatInformsMeToCheckEmail() {
        WebElement text = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div[3]/div/div[1]"));
        if (text.isDisplayed()) {
            text.getText().equals("Vielen Dank");
            driver.quit();
        }
    }


    //endregion

    //region Scenario 9
    @And("I click the return button")
    public void iClickTheReturnButton() {
        WebElement link = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div[1]/a"));
        if (link.isDisplayed()) {
            link.click();
        } else {
            throw new RuntimeException("click back button is not displayed, check the element selector");
        }
    }

    @Then("I should see main page")
    public void iShouldSeeMainPage() {
        WebElement loginPage = driver.findElement(By.xpath("/html/body/header/div[2]/div/div[2]/div[1]/a"));
        loginPage.isDisplayed();
        driver.quit();
    }

//endregion
}