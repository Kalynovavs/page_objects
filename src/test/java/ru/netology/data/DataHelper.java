package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {

    private DataHelper(){};

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo() {
        return new AuthInfo("Nikolay", "qwerty");
    }

    @Value
    public static class Verification {
        private String code;
    }

    public static Verification getVerificationCodeFor(AuthInfo authInfo) {
        return new Verification("12345");
    }

    @Value
    public static class CardsId {
        private String firstCard;
        private String secondCard;
    }

    public static CardsId getCardIds() {
        return new CardsId("92df3f1c-a033-48e6-8390-206f6b1f56c0", "0f3f5c2a-249e-4c3d-8287-09f7a039391d");
    }

    @Value
    public static class CardsNumber {
        private String firstCardNumber;
        private String secondCardNumber;
    }

    public static CardsNumber getCardNumbers() {
        return new CardsNumber("5559 0000 0000 0001", "5559 0000 0000 0002");
    }

    @Value
    public static class Amount {
        private int amount;
    }

    public static Amount getAmount() {
        Faker faker = new Faker(new Locale("ru"));
        return new Amount(faker.number().numberBetween(1, 9999));
    }

}
