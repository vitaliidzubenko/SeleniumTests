package RiaPages;

import TestOptions.DriverInit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QuestionsPage extends DriverInit {
    private final Logger log = LogManager.getLogger(QuestionsPage.class);
    private final By inputBlock = By.xpath("//input[@name= 'question']");
    private final By searchButton = By.xpath("//button[@class = 'btn-send no-style']");
    private final By searchLink = By.xpath("//a[contains (text(), 'Как зарегистрироваться')]");
    private final By answerContent = By.xpath("//div[@class = 'answer-list']");

    public By getAnswerContent() {
        return answerContent;
    }

    public QuestionsPage clickLink() {
        log.info("clickLink");
        oneLocClick(searchLink);
        return this;
    }

    public QuestionsPage viewLink() {
        log.info("viewLink");
        oneLocClick(answerContent);
        return this;
    }

    public QuestionsPage enterQuestion() {
        log.info("enterQuestion");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(inputBlock)).sendKeys("Как зарегистрироваться");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(searchButton)).click();
        return this;
    }
}
