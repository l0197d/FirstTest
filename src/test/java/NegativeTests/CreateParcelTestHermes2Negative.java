package NegativeTests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import dataHermes2.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CreateParcelTestHermes2Negative {



        String s = RandomStringUtils.randomNumeric(2);
        Date curDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String DateToStr = format.format(curDate);

        @BeforeAll
        static void setUpAll() {
            SelenideLogger.addListener("allure", new AllureSelenide());
            open("http://my.hermesrussia.ru/preadvice/upsert");
            LoginPage.login("b2c", "EL0no8ie");

        }

        @Test
            //TestID=11494 (ЛК  Functional test) Создать отправление.Hermes2.Стандартное отправление
        void CreateStandardParcelBUHermes2NegativeCheckValidationPVZ() {

            Hermes2StandardTypeDelivery.setTypeDelivery();

            $("[id ='selected-pvz-delivery']").click(); // Выбор ПВЗ
            $("[class='inp_herm_st']").setValue("Озёрная ");
            $("[class ='btn btn-light btn-select-pvz-hermes']").click();

        }

            @Test
            //TestID=11494 (ЛК  Functional test) Создать отправление.Hermes2.Стандартное отправление
            void CreateStandardParcelBUHermes2NegativeCheckValidationDimension() {

                Hermes2StandardTypeDelivery.setTypeDelivery();

                $("[id ='selected-pvz-delivery']").click(); // Выбор ПВЗ
                $("[class='inp_herm_st']").setValue("900000 ");
                $("[class ='btn btn-light btn-select-pvz-hermes']").click();


            }

/*
            Dimensions.dimension();// Ввод габаритов отправления
            PriceOfPackage.price();// Ввод стоимости отправления
            //$("[id='nearest-pickup-date']").shouldHave(text("ошибка расчета")); // Ориентировочная дата пикапа // Ожидаем ремонта метода
            $("[id ='selected-package-number-in-customer-system']").setValue("AutoTestID=11494" + ' ' + s + ' ' + DateToStr);
            FioEmailNumber.fastinput(); // Ввод ФИО, номера телефона и email
            $("[id ='create-upsert-button']").click(); // Создание стандартного отправления
            $(withText("Отправление успешно создано")).shouldBe(Condition.visible, Duration.ofSeconds(15));
            $("[data-bb-handler ='ok']").click();
            refresh();

        }
*/

}
