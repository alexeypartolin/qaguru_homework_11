package com.alexeypartolin;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.DataInputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class StudentRegistrationFormTest extends TestBase {

    @Test
    @Tag("demoTests")
    @DisplayName("Successful fill registration test")
    public void newTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

       step("Открываем страницу", () -> {
          open("https://demoqa.com/automation-practice-form");
      });

        step("Ввод имени и фамилии", () -> {
            $("#userForm").$("#firstName").setValue("Alexey");
            $("#userForm").$("#lastName").setValue("Partolin");
        });

        step("Ввод e-mail", () -> {
            $("#userForm").$("#userEmail").setValue("alexeypartolin@yahoo.com");
        });

        step("Выбор radio-button", () -> {
            $("[for='gender-radio-1']").click();
        });

        step("Ввод мобильного телефона", () -> {
            $(By.id("userNumber")).setValue("9163322170");
        });
        step("Выбор значения из выпадающего списка", () -> {
            $(By.id("subjectsInput")).setValue("Computer").pressEnter();
            $("#subjectsContainer").shouldHave(text("Computer Science"));
        });
        step("Загрузка файла", () -> {
            $("#uploadPicture").uploadFromClasspath("upload-folder/homeAlone.jpeg");
        });
        step("Выбор дня рождения", () -> {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("July");
            $(".react-datepicker__year-select").selectOption("2021");
            $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)").click();
        });
        step("Выбор чекбоксов", () -> {
            $("[for='hobbies-checkbox-1']").click();
            $("[for='hobbies-checkbox-3']").click();
        });
        step("Ввод адреса", () -> {
            $("#currentAddress").setValue("Ovchinnikovskaya наб., 6 стр1, Москва, 19128");
        });
        step("Выбор штата и города", () -> {
            $("#state").scrollTo().click();
            $("#stateCity-wrapper").$(byText("NCR")).click();
            $("#city").click();
            $("#react-select-4-input").setValue("Noida").pressEnter();
        });

        step("Нажатие на кнопку \"Sumbit\"", () -> {
            executeJavaScript("$('footer').remove()"); // убираем рекламный баннер который мешает кликнуть на кнопку submit
            executeJavaScript("$('fixedban').remove()");
            $("#submit").scrollTo().click();
        });

        // Asserts

        step("Asserts", () -> {
            $(".modal-content").shouldBe(visible);
            $(".table-responsive").shouldHave(text("Alexey"), text("Partolin"), text("Alexey"),
                    text("alexeypartolin@yahoo.com"), text("01 July,2021"), text("Male"), text("Sports, Music"), text("NCR Noida"),
                    text("9163322170"), text("homeAlone.jpeg"), text("Ovchinnikovskaya наб., 6 стр1, Москва, 19128"));
        });
    }
}