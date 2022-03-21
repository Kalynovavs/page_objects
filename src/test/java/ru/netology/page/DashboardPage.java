package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private ElementsCollection cards = $$(".list__item");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";
    private SelenideElement reloadButton = $("[data-test-id=action-reload]");


    public DashboardPage() {
        heading.shouldBe(Condition.visible);
    }

    public SelenideElement getCardElementById(String id) {
        return $(byAttribute("data-test-id", id));
    }

    public int getCardBalanceFor(String id) {
        var card = getCardElementById(id);
        var text = card.text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public TransferPage makeTransfer(DataHelper.Card card) {
        getCardElementById(card.getId()).$("[data-test-id=action-deposit]").click();
        return new TransferPage();
    }


}
