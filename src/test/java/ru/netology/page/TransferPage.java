package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement form = $("form.form");
    private SelenideElement amountField = form.$("[data-test-id=amount] input");
    private SelenideElement fromField = form.$("[data-test-id=from] input");
    private SelenideElement transferButton = form.$("[data-test-id=action-transfer]");


    public TransferPage() {
        form.shouldBe(Condition.visible);
    }

    public DashboardPage transferMoney(int amount, DataHelper.Card from) {
        String amountString = Integer.toString(amount);
        amountField.setValue(amountString);
        fromField.setValue(from.getNumber());
        transferButton.click();
        return new DashboardPage();
    }
}
