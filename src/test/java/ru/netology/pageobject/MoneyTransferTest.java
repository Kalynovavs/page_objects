package ru.netology.pageobject;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;
import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {

    @Test
    void shouldTransferMoneyBetweenOwnCards() {
        //auth
        open("http://localhost:9999");
        var amount = DataHelper.getAmount().getAmount();
        var firstCard = DataHelper.getFirstCardInfo();
        var secondCard = DataHelper.getSecondCardInfo();
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validCode(verificationCode);
        // make transfer
        var balanceStartFrom = dashboardPage.getCardBalanceFor(secondCard.getId());
        var balanceStartTo = dashboardPage.getCardBalanceFor(firstCard.getId());
        var transferPage = dashboardPage.makeTransfer(firstCard);
        var newDashboardPage = transferPage.transferMoney(amount, secondCard);
        // check result
        int expectedToBalance = balanceStartTo + amount;
        int actualToBalance = newDashboardPage.getCardBalanceFor(firstCard.getId());
        int expectedFromBalance = balanceStartFrom - amount;
        int actualFromBalance = newDashboardPage.getCardBalanceFor(secondCard.getId());
        Assert.assertEquals(expectedToBalance,actualToBalance);
        Assert.assertEquals(expectedFromBalance,actualFromBalance);
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsReturn() {
        //auth
        open("http://localhost:9999");
        var amount = DataHelper.getAmount().getAmount();
        var firstCard = DataHelper.getFirstCardInfo();
        var secondCard = DataHelper.getSecondCardInfo();
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validCode(verificationCode);
        // make transfer
        var balanceStartFrom = dashboardPage.getCardBalanceFor(firstCard.getId());
        var balanceStartTo = dashboardPage.getCardBalanceFor(secondCard.getId());
        var transferPage = dashboardPage.makeTransfer(secondCard);
        var newDashboardPage = transferPage.transferMoney(amount, firstCard);
        // check result
        int expectedToBalance = balanceStartTo + amount;
        int actualToBalance = newDashboardPage.getCardBalanceFor(secondCard.getId());
        int expectedFromBalance = balanceStartFrom - amount;
        int actualFromBalance = newDashboardPage.getCardBalanceFor(firstCard.getId());
        Assert.assertEquals(expectedToBalance,actualToBalance);
        Assert.assertEquals(expectedFromBalance,actualFromBalance);
    }


    @Test
    void shouldTransferMoneyMoreBalance() {
        //auth
        open("http://localhost:9999");
        var amount = 30000;
        var firstCard = DataHelper.getFirstCardInfo();
        var secondCard = DataHelper.getSecondCardInfo();
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validCode(verificationCode);
        // make transfer
        var balanceStartFrom = dashboardPage.getCardBalanceFor(secondCard.getId());
        var balanceStartTo = dashboardPage.getCardBalanceFor(firstCard.getId());
        var transferPage = dashboardPage.makeTransfer(firstCard);
        var newDashboardPage = transferPage.transferMoney(amount, secondCard);
        // check result
        int expectedToBalance = balanceStartTo + amount;
        int actualToBalance = newDashboardPage.getCardBalanceFor(firstCard.getId());
        int expectedFromBalance = balanceStartFrom - amount;
        int actualFromBalance = newDashboardPage.getCardBalanceFor(secondCard.getId());
        Assert.assertEquals(expectedToBalance,actualToBalance);
        Assert.assertEquals(expectedFromBalance,actualFromBalance);
    }

    @Test
    void shouldTransferALotOfMoney() {
        //auth
        open("http://localhost:9999");
        var amount = 1000000;
        var firstCard = DataHelper.getFirstCardInfo();
        var secondCard = DataHelper.getSecondCardInfo();
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validCode(verificationCode);
        // make transfer
        var balanceStartFrom = dashboardPage.getCardBalanceFor(secondCard.getId());
        var balanceStartTo = dashboardPage.getCardBalanceFor(firstCard.getId());
        var transferPage = dashboardPage.makeTransfer(firstCard);
        var newDashboardPage = transferPage.transferMoney(amount, secondCard);
        // check result
        int expectedToBalance = balanceStartTo + amount;
        int actualToBalance = newDashboardPage.getCardBalanceFor(firstCard.getId());
        int expectedFromBalance = balanceStartFrom - amount;
        int actualFromBalance = newDashboardPage.getCardBalanceFor(secondCard.getId());
        Assert.assertEquals(expectedToBalance,actualToBalance);
        Assert.assertEquals(expectedFromBalance,actualFromBalance);
    }
}
