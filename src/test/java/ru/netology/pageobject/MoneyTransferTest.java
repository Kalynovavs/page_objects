package ru.netology.pageobject;


import org.junit.jupiter.api.Test;

import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;
import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {

    @Test
    void shouldSuccessAuth() {
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validCode(verificationCode);
    }

    @Test
    void shouldTransferMoneyBetweenOwnCards() {
        //auth
        open("http://localhost:9999");
        var amount = DataHelper.getAmount().getAmount();
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validCode(verificationCode);

        // make transfer
        var balanceStartFrom = dashboardPage.getCardBalanceFor(DataHelper.getCardIds().getFirstCard());
        var balanceStartTo = dashboardPage.getCardBalanceFor(DataHelper.getCardIds().getSecondCard());
        var transferPage = dashboardPage.makeTransfer(DataHelper.getCardIds());
        dashboardPage = transferPage.transferMoney(amount, DataHelper.getCardNumbers());
        // check result
        dashboardPage.checkBalance(balanceStartFrom, balanceStartTo, amount, DataHelper.getCardIds().getFirstCard(), DataHelper.getCardIds().getSecondCard());
    }
}
