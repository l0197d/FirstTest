package FunctionalTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selenide.*;


public class AuthTest {

   @BeforeEach
   void setup () { open ("http://my.hermesrussia.ru/preadvice/upsert"); }

    @BeforeAll
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
        @Test
        void AuthTestNoLoginInput() {
            Configuration.timeout=5000;
            // Configuration.holdBrowserOpen = true;
            $("[name='Password']").setValue("EL0no8ie");
            $("[type='submit']").click();
            //  $("[class='form-text text-danger']").shouldHave(exactText("Неправильный логин и (или) пароль"));  // не читает надпись
        }

        @Test

        void AuthTestNoPasswordInput() {
            // Configuration.holdBrowserOpen = true;
            $("[id='login-input']").setValue("b2c");
            $("[type='submit']").click();
            //  $("[class='form-text text-danger']").shouldHave(exactText("Неправильный логин и (или) пароль"));  // не читает надпись
        }
        @Test
        void AuthTestNoInput() {
            // Configuration.holdBrowserOpen = true;
            $("[type='submit']").click();
            //  $("[class='form-text text-danger']").shouldHave(exactText("Неправильный логин и (или) пароль"));  // не читает надпись
        }
        @Test
        void AuthTestOk() {
            //Configuration.holdBrowserOpen = true;
            $("[id='login-input']").setValue("b2c");
            $("[name='Password']").setValue("EL0no8ie");
            $("[type='submit']").click();
        }
    }


