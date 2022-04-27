package FunctionalTest;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import dataHermes.hermesStandardTypeDelivery;
import dataHermes2.Dimensions;
import dataHermes2.FioEmailNumber;
import dataHermes2.LoginPage;
import dataHermes2.PriceOfPackage;
import io.qameta.allure.selenide.AllureSelenide;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class CreateParcelTestHermes {

    String s = RandomStringUtils.randomNumeric(2);
    Date curDate = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    String DateToStr = format.format(curDate);


    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure",new AllureSelenide());

    }

    @Test
        //TestID=11&&& (ЛК  Functional test) Создать отправление.Hermes.Стандартное отправление
    void CreateStandardParcelBUHermes() throws InterruptedException {
        Configuration.holdBrowserOpen = true;
        open("http://my.hermesrussia.ru/preadvice/upsert");
        LoginPage.login("b2c", "EL0no8ie");

        hermesStandardTypeDelivery.setTypeDeliveryHermes();
        Thread.sleep(12000);
        $("[id ='selected-pvz-delivery']").shouldBe(visible).click(); // Выбор ПВЗ
        $("[class='inp_herm_st']").setValue("997726");
        $("[type ='button']").click();
        // $(xpath("//*[@id="#header-pvz0"]/div[1]/div[3]/button")).click();
        Dimensions.dimension();// Ввод габаритов отправления
        PriceOfPackage.price();// Ввод стоимости отправления
        //$("[id='nearest-pickup-date']").shouldHave(text("ошибка расчета")); // Ориентировочная дата пикапа // Ожидаем ремонта метода
        $("[id ='selected-package-number-in-customer-system']").setValue("AutoTestID=11???" + ' ' + s + ' ' + DateToStr);
        FioEmailNumber.fastinput(); // Ввод ФИО, номера телефона и email
        $("[id ='create-upsert-button']").click(); // Создание стандартного отправления
        $(withText("Отправление успешно создано")).shouldBe(visible, Duration.ofSeconds(15));
        $("[data-bb-handler ='ok']").click();
        $("[class ='btn d-lg-inline-block d-none']").click();
        $("[class ='dropdown-item bg-primary text-white text-center mt-3']").click();

    }

}
