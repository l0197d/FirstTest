package FunctionalTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import dataHermes2.LoginPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;

public class PreadviceNotConfirmed {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure",new AllureSelenide());

    }

    @Test
        //TestID=11517 (ЛК Functional positive test) Импортировать отправление
    void ParcelNotConfirmedCheckAllButton() throws InterruptedException {
        Configuration.holdBrowserOpen = true;
        open("http://my.hermesrussia.ru/preadvice/upsert");
        LoginPage.login("b2c", "EL0no8ie");
        open("https://my.hermesrussia.ru/parcel/not-confirmed");

        $(xpath("//tbody/tr[1]/td[2]/input[1]")).click();// выбрать чекбокс

        $("[id ='CalculateDelivery']").should(exist).click();

        $("[id ='StickerGeneration']").should(exist).click();// Генерация наклеек
        //А4
        $(xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/p[2]/input[1]")).click(); //печать без окантовки
        $(xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/p[3]/input[1]")).click(); // По одной наклейке на страницу
        $(xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/button[1]")).shouldBe(visible).click(); // Скачать А4

        //А4 с наклейками
        $("[id ='StickerGeneration']").shouldBe(visible).click();// Генерация наклеек
        $(xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/p[2]/input[1]")).click(); //печать без окантовки
        $(xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/p[3]/input[1]")).click(); // По одной наклейке на страницу
        $(xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/button[2]")).shouldBe(visible).click(); // Скачать А4 с наклейками

        //А4 портретный
        $("[id ='StickerGeneration']").shouldBe(visible).click();// Генерация наклеек
        $(xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/p[2]/input[1]")).click(); //печать без окантовки
        $(xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/p[3]/input[1]")).click(); // По одной наклейке на страницу
        $(xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/button[3]")).shouldBe(visible).click(); // Скачать А4 портретный

        //А5
        $("[id ='StickerGeneration']").shouldBe(visible).click();// Генерация наклеек
        $(xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/p[2]/input[1]")).click(); //печать без окантовки
        $(xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/p[3]/input[1]")).click(); // По одной наклейке на страницу
        $(xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/button[4]")).click(); // Скачать А5

        //Зебра
        $("[id ='StickerGeneration']").shouldBe(visible).click();// Генерация наклеек
        $(xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/p[2]/input[1]")).click(); //печать без окантовки
        $(xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/p[3]/input[1]")).click(); // По одной наклейке на страницу
        $(xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/button[5]")).click(); // Зебра




        $("[id ='SealOfAct']").should(exist).click();
        $("[for ='checkBoxNoNamePdfAct']").should(exist).click();
        $("[class ='btn btn-success']").should(exist).click(); // выбрать чекбокс
        $("[id ='UploadToFile']").should(exist).click();//Выгрузить отпраление
        $("[id ='DeletePreadvice']").should(exist).click(); //Удалить отпраление
        $("[data-bb-handler ='ok']").should(exist).click();
        $("[id ='SendForDelivery']").should(exist).click();
        Thread.sleep(5000);
        //$(xpath("//button[contains(text(),'OK')]")).shouldBe(visible).click();
        $(xpath("/html/body/div[4]/div/div/div[1]/button")).should(exist).click();

    }

    @Test
        //TestID=11??? (ЛК Functional positive test) Импортировать отправление
    void ParcelNotConfirmedCheckAllButtonUI() throws InterruptedException {
        Configuration.holdBrowserOpen = true;
        open("http://my.hermesrussia.ru/preadvice/upsert");
        LoginPage.login("b2c", "EL0no8ie");
        open("https://my.hermesrussia.ru/parcel/not-confirmed");


        $("[aria-owns ='bs-select-1']").click();
        $("[id ='bs-select-1-2']").click();
        $("[id ='date-s']").click();
        $("[data-handler='selectDay']").click();
        Calendar calendar = new GregorianCalendar();
        var dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        $(byText(String.valueOf(dayOfMonth - 5))).click();

        $("[id ='date-po']").click();
        $("[data-handler='selectDay']").click();
        $(byText(String.valueOf(dayOfMonth = 18))).click();


    }
}




