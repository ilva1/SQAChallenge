import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Voucher {
    private final LoginStepDef loginSteps;

    public Voucher(LoginStepDef loginSteps) {
        this.loginSteps = loginSteps;
    }

    //region Scenario 1
    @Then("I go to bags")
    public void iGoToBags() {
        WebElement bagsLink = loginSteps.driver.findElement(By.xpath("/html/body/header/div[3]/div/div[1]/ul/li[3]/a"));
        if (bagsLink.isDisplayed()) {
            bagsLink.click();
        } else {
            throw new RuntimeException("Bag Link is not displayed, check the element selector");
        }
    }

    @Then("I add new item in shopping bag")
    public void iAddNewItemInShoppingBag() {
        WebElement firstElement = loginSteps.driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/div[1]/div[2]/div[4]/div/div[1]/div/a/div"));
        if (firstElement.isDisplayed()) {
            firstElement.click();
        } else {
            throw new RuntimeException("Bag Element is not displayed, check the element selector");
        }
        WebElement addToBag = loginSteps.driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/article/div[2]/div[2]/div[3]/form/div[2]/div"));
        if (addToBag.isDisplayed()) {
            addToBag.click();
        } else {
            throw new RuntimeException("Add to bag element is not displayed, check the element selector");
        }
    }

    @And("i go to my bag")
    public void iGoToMyBag() {
        WebElement shoppingBag = loginSteps.driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[2]/div/div/table/tbody/tr[3]/td"));
        if (shoppingBag.isDisplayed()) {
            shoppingBag.click();
        } else {
            throw new RuntimeException("Shopping Bag element is not displayed, check the element selector");
        }
    }

    @Then("I apply the voucher with the code successfully")
    public void iApplyTheVoucherWithTheCodeSuccessfully() {
        WebElement voucherLink = loginSteps.driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[2]/div/div/table/tbody/tr[3]/td/a"));
        if (voucherLink.isDisplayed()) {
            voucherLink.click();
            WebElement applyVoucherText = loginSteps.driver.findElement(By.xpath("//*[@id=\"form-cart-voucher\"]/div[1]/div/input"));
            if (applyVoucherText.isDisplayed()) {
                applyVoucherText.sendKeys("qachallenge");
                WebElement applyButton = loginSteps.driver.findElement(By.xpath("//*[@id=\"form-cart-voucher\"]/div[2]/button"));
                applyButton.click();
            } else {

                throw new RuntimeException("voucher Text element is not displayed, check the element selector");
            }
        } else {
            throw new RuntimeException("voucher Link element is not displayed, check the element selector");
        }

    }
    //endregion

    //region Scenario 2
    @Then("I try to apply code nothing happens")
    public void iTryToApplyCodeNothingHappens() {
        WebElement voucherLink = loginSteps.driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/div[2]/div/div/table/tbody/tr[3]/td/a"));
        if (voucherLink.isDisplayed()) {
            voucherLink.click();
            WebElement applyVoucherText = loginSteps.driver.findElement(By.xpath("//*[@id=\"form-cart-voucher\"]/div[1]/div/input"));
            if (applyVoucherText.isDisplayed()) {
                applyVoucherText.sendKeys(" ");
                WebElement applyButton = loginSteps.driver.findElement(By.xpath("//*[@id=\"form-cart-voucher\"]/div[2]/button"));
                applyButton.click();
            } else {

                throw new RuntimeException("voucher Text element is not displayed, check the element selector");
            }
        } else {
            throw new RuntimeException("voucher Link element is not displayed, check the element selector");
        }
    }
    //endregion
}