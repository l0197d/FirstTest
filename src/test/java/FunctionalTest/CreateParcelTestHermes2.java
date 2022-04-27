package FunctionalTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import dataHermes2.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class CreateParcelTestHermes2 {

    String s = RandomStringUtils.randomNumeric(2);
    Date curDate = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    String DateToStr = format.format(curDate);

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());

    }
    // Номер отправления в системе клиента (Генерация числа и даты)


    @Epic(value = "ЛК  Functional test")
    @Feature(value = "Создать отправление.Hermes2.Стандартное отправление")
    @Story(value = "TestID=20")
    @Test

    void CreateStandardParcelBUHermes2() {
        open("http://my.hermesrussia.ru/preadvice/upsert");
        LoginPage.login("b2c", "EL0no8ie");
        Hermes2StandardTypeDelivery.setTypeDelivery();

        $("[id ='selected-pvz-delivery']").shouldBe(visible).click(); // Выбор ПВЗ
        $("[class='inp_herm_st']").setValue("900000 ");
        $("[class ='btn btn-light btn-select-pvz-hermes']").click();

        Dimensions.dimension();// Ввод габаритов отправления
        PriceOfPackage.price();// Ввод стоимости отправления
        //$("[id='nearest-pickup-date']").shouldHave(text("ошибка расчета")); // Ориентировочная дата пикапа // Ожидаем ремонта метода
        $("[id ='selected-package-number-in-customer-system']").setValue("AutoTestID=11494" + ' ' + s + ' ' + DateToStr);
        FioEmailNumber.fastinput(); // Ввод ФИО, номера телефона и email
        $("[id ='create-upsert-button']").click(); // Создание стандартного отправления
        $(withText("Отправление успешно создано")).shouldBe(Condition.visible, Duration.ofSeconds(25));
        $("[data-bb-handler ='ok']").click();
        $("[class ='btn d-lg-inline-block d-none']").click();
        $("[class ='dropdown-item bg-primary text-white text-center mt-3']").click();

    }

    @Epic(value = "ЛК  Functional test")
    @Feature(value = "Создать отправление.Hermes2.Курьерское отправления")
    @Story(value = "TestID=11492")
    @Test

    void CreateCourierParcelBUHermes2() {
        open("http://my.hermesrussia.ru/preadvice/upsert");
        LoginPage.login("b2c", "EL0no8ie");
        // holdBrowserOpen = true;
        Hermes2CourierTypeDelivery.setTypeDelivery();
        CourierLocation.courierLocation();
        Dimensions.dimension();// Ввод габаритов отправления
        PriceOfPackage.price();// Ввод стоимости отправления
        //$("[id='nearest-pickup-date']").shouldHave(text("ошибка расчета")); // Ориентировочная дата пикапа // Ожидаем ремонта метода
        $("[id ='selected-package-number-in-customer-system']").setValue("AutoTestID=11492" + ' ' + s + ' ' + DateToStr);
        FioEmailNumber.fastinput(); // Ввод ФИО, номера телефона и email
        $("[id ='create-upsert-button']").click(); // Создание стандартного отправления
        $(withText("Отправление успешно создано")).shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-bb-handler ='ok']").click();
        $("[class ='btn d-lg-inline-block d-none']").click();
        $("[class ='dropdown-item bg-primary text-white text-center mt-3']").click();

    }
    @Epic(value = "ЛК  Functional test")
    @Feature(value = "Создать отправление.Hermes2.Мульти-курьерские отправления")
    @Story(value = "TestID=11783")
    @Test

    void CreateCourierMultiParcelBUHermes2() {
        open("http://my.hermesrussia.ru/preadvice/upsert");
        LoginPage.login("b2c", "EL0no8ie");
        //holdBrowserOpen = true;
        Hermes2CourierTypeDelivery.setTypeDelivery();
        CourierLocation.courierLocation();
        Dimensions.dimension();// Ввод габаритов отправления
        PriceOfPackage.price();// Ввод стоимости отправления
        //$("[id='nearest-pickup-date']").shouldHave(text("ошибка расчета")); // Ориентировочная дата пикапа // Ожидаем ремонта метода
        $("[id ='selected-package-number-in-customer-system']").setValue("AutoTestID=11783" + ' ' + s + ' ' + DateToStr);
        $("[id ='selected-order-number-in-customer-system']").setValue("AutoTestIDMultiParcelCourier");
        FioEmailNumber.fastinput(); // Ввод ФИО, номера телефона и email
        $("[id ='create-upsert-button']").click(); // Создание стандартного отправления
        $(withText("Отправление успешно создано")).shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-bb-handler ='ok']").click();
        Hermes2CourierTypeDelivery.setTypeDelivery();
        CourierLocation.courierLocation();
        Dimensions.dimension();// Ввод габаритов отправления
        PriceOfPackage.price();// Ввод стоимости отправления
        //$("[id='nearest-pickup-date']").shouldHave(text("ошибка расчета")); // Ориентировочная дата пикапа // Ожидаем ремонта метода
        // Номер отправления в системе клиента (Генерация числа и даты)
        $("[id ='selected-package-number-in-customer-system']").setValue("AutoTestID=11783" + ' ' + s + ' ' + DateToStr);
        $("[id ='selected-order-number-in-customer-system']").setValue("AutoTestIDMultiParcelCourier");
        FioEmailNumber.fastinput(); // Ввод ФИО, номера телефона и email
        $("[id ='create-upsert-button']").click(); // Создание стандартного отправления
        $(withText("Отправление успешно создано")).shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-bb-handler ='ok']").click();
        $("[class ='btn d-lg-inline-block d-none']").click();
        $("[class ='dropdown-item bg-primary text-white text-center mt-3']").click();
    }

    @Epic(value = "ЛК  Functional test")
    @Feature(value = "Создать отправление.Hermes2.Создать мульти отправление.Hermes2.Стандартное отправление")
    @Story(value = "TestID=11784")
    @Test

    void CreateStandardMultiParcelBUHermes2() {
        open("http://my.hermesrussia.ru/preadvice/upsert");
        LoginPage.login("b2c", "EL0no8ie");
        //holdBrowserOpen = true;
        Hermes2StandardTypeDelivery.setTypeDelivery();
        $("[id ='selected-pvz-delivery']").click(); // Выбор ПВЗ
        $("[class='inp_herm_st']").shouldBe(visible).setValue("900000");
        $("[class ='btn btn-light btn-select-pvz-hermes']").click();
        Dimensions.dimension();// Ввод габаритов отправления
        PriceOfPackage.price();// Ввод стоимости отправления
        //$("[id='nearest-pickup-date']").shouldHave(text("ошибка расчета")); // Ориентировочная дата пикапа // Ожидаем ремонта метода
        // Номер отправления в системе клиента (Генерация числа и даты)
        $("[id ='selected-package-number-in-customer-system']").setValue("AutoTestID=11784" + ' ' + s + ' ' + DateToStr);
        $("[id ='selected-order-number-in-customer-system']").setValue("AutoTestIDMultiParcelStandard");
        FioEmailNumber.fastinput(); // Ввод ФИО, номера телефона и email
        $("[id ='create-upsert-button']").click(); // Создание стандартного отправления
        $(withText("Отправление успешно создано")).shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-bb-handler ='ok']").click();
        $("[class ='btn d-lg-inline-block d-none']").click();
        $("[class ='dropdown-item bg-primary text-white text-center mt-3']").click();

// Второе отправление
        Hermes2StandardTypeDelivery.setTypeDelivery();
        $("[id ='selected-pvz-delivery']").click(); // Выбор ПВЗ
        $("[class='inp_herm_st']").shouldBe(visible).setValue("900000");
        $("[class ='btn btn-light btn-select-pvz-hermes']").click();
        Dimensions.dimension();// Ввод габаритов отправления
        PriceOfPackage.price();// Ввод стоимости отправления
        //$("[id='nearest-pickup-date']").shouldHave(text("ошибка расчета")); // Ориентировочная дата пикапа // Ожидаем ремонта метода
        // Номер отправления в системе клиента (Генерация числа и даты)
        $("[id ='selected-package-number-in-customer-system']").setValue("AutoTestID=11784" + ' ' + s + ' ' + DateToStr);
        $("[id ='selected-order-number-in-customer-system']").setValue("AutoTestIDMultiParcelStandard");
        FioEmailNumber.fastinput(); // Ввод ФИО, номера телефона и email
        $("[id ='create-upsert-button']").click(); // Создание стандартного отправления
        $(withText("Отправление успешно создано")).shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-bb-handler ='ok']").click();
        $("[class ='btn d-lg-inline-block d-none']").click();
        $("[class ='dropdown-item bg-primary text-white text-center mt-3']").click();
    }

    @Epic(value = "ЛК  Functional test")
    @Feature(value = "Создать отправление.Hermes2.Создание стандартного отправления с частичной выдачей.")
    @Story(value = "TestID=11536")
    @Test

    void CreateStandardParcelWithPartialHandoutAndFittingBUHermes2() {
        open("http://my.hermesrussia.ru/preadvice/upsert");
        LoginPage.login("b2c", "EL0no8ie");
        holdBrowserOpen = true;
        Hermes2StandardTypeDelivery.setTypeDelivery();
        $("[id ='selected-pvz-delivery']").click(); // Выбор ПВЗ
        $("[for ='filterPartialHandoutCheckbox']").click(); // Частичная выдача
        $("[for ='filterFittingClothesCheckbox']").click(); // Примерка
        $("[class='inp_herm_st']").shouldBe(visible).setValue("900193");
        $("[class ='btn btn-light btn-select-pvz-hermes']").click();
        //$("[id='nearest-pickup-date']").shouldHave(text("ошибка расчета")); // Ориентировочная дата пикапа // Ожидаем ремонта метода

        Dimensions.dimension();// Ввод габаритов отправления
        PriceOfPackage.price();// Ввод стоимости отправления
        $("[id ='selected-package-number-in-customer-system']").setValue("AutoTestID=11536" + ' ' + s + ' ' + DateToStr);
        $("[id ='selected-order-number-in-customer-system']").setValue("AutoTestIDSPWPartialHandoutAndFittingBUHermes2");
        // Добавление товара
        $("[for ='partialHandoutCheck']").click(); // Частичная выдача
        $("[id='addParcelItemBtn']").click(); // Добавить описание товара

        //$("[id ='itemType']").setValue("2"); // Товар
        $("[id ='Code']").setValue("123456"); // SKU Код
        $("[id ='MarkingCode']").setValue("321"); // Код маркировки
        $("[id ='Article']").setValue("555"); // Артикул
        $("[id ='Name']").setValue("Штаны"); // Наименование
        $("[id ='PricePlaceholder']").setValue("250"); // Стоимость
        $("[id ='InsuranceValue']").setValue("250"); // Страховая стоимость


        FioEmailNumber.fastinput(); // Ввод ФИО, номера телефона и email
        $("[id ='create-upsert-button']").click(); // Создание стандартного отправления
        $(withText("Отправление успешно создано")).shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-bb-handler ='ok']").click();
        $("[class ='btn d-lg-inline-block d-none']").click();
        $("[class ='dropdown-item bg-primary text-white text-center mt-3']").click();
    }

    @Epic(value = "ЛК  Functional test")
    @Feature(value = "Создать отправление.Hermes2.Последняя миля. Курьерская доставка.")
    @Story(value = "TestID=11787")
    @Test

    void CreateCourierLastMileParcelBUHermes2() {
        open("http://my.hermesrussia.ru/preadvice/upsert");
        LoginPage.login("b2c", "EL0no8ie");
        holdBrowserOpen = true;
        Hermes2CourierTypeDelivery.setTypeDelivery();
        CourierLastMile.courierLastMileLocation();
        Dimensions.dimension();// Ввод габаритов отправления
        PriceOfPackage.price();// Ввод стоимости отправления
        //$("[id='nearest-pickup-date']").shouldHave(text("ошибка расчета")); // Ориентировочная дата пикапа // Ожидаем ремонта метода
        $("[id ='selected-package-number-in-customer-system']").setValue("AutoTestID=11787" + ' ' + s + ' ' + DateToStr);
        $("[id ='selected-order-number-in-customer-system']").setValue("KizilUrtCourierMultiParcel2");
        FioEmailNumber.fastinput(); // Ввод ФИО, номера телефона и email
        $("[id ='create-upsert-button']").click(); // Создание стандартного отправления
        $(withText("Отправление успешно создано")).shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-bb-handler ='ok']").click();
        $("[class ='btn d-lg-inline-block d-none']").click();
        $("[class ='dropdown-item bg-primary text-white text-center mt-3']").click();

    }

    @Epic(value = "ЛК  Functional test")
    @Feature(value = "Создать отправление.Hermes2.Последняя миля. Курьерская доставка.Мультипосылка")
    @Story(value = "TestID=11???")
    @Test

    void CreateCourierLastMileMultiParcelBUHermes2() {
        open("http://my.hermesrussia.ru/preadvice/upsert");
        LoginPage.login("b2c", "EL0no8ie");
        holdBrowserOpen = true;
        Hermes2CourierTypeDelivery.setTypeDelivery();
        CourierLastMile.courierLastMileLocation();
        Dimensions.dimension();// Ввод габаритов отправления
        PriceOfPackage.price();// Ввод стоимости отправления
        //$("[id='nearest-pickup-date']").shouldHave(text("ошибка расчета")); // Ориентировочная дата пикапа // Ожидаем ремонта метода
        $("[id ='selected-package-number-in-customer-system']").setValue("AutoTestID=11123" + ' ' + s + ' ' + DateToStr);
        $("[id ='selected-order-number-in-customer-system']").setValue("IzberbashMultiParcel2"); //AutoTestIDCourierLastMileMultiParcelBUHermes3
        FioEmailNumber.fastinput(); // Ввод ФИО, номера телефона и email
        $("[id ='create-upsert-button']").click(); // Создание стандартного отправления
        $(withText("Отправление успешно создано")).shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-bb-handler ='ok']").click();
        Hermes2CourierTypeDelivery.setTypeDelivery();
        CourierLastMile.courierLastMileLocation();
        Dimensions.dimension();// Ввод габаритов отправления
        PriceOfPackage.price();// Ввод стоимости отправления
        //$("[id='nearest-pickup-date']").shouldHave(text("ошибка расчета")); // Ориентировочная дата пикапа // Ожидаем ремонта метода
        $("[id ='selected-package-number-in-customer-system']").setValue("AutoTestID=11123" + ' ' + s + ' ' + DateToStr);
        $("[id ='selected-order-number-in-customer-system']").setValue("IzberbashMultiParcel2");
        FioEmailNumber.fastinput(); // Ввод ФИО, номера телефона и email
        $("[id ='create-upsert-button']").click(); // Создание стандартного отправления
        $(withText("Отправление успешно создано")).shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-bb-handler ='ok']").click();
        $("[class ='btn d-lg-inline-block d-none']").click();
        $("[class ='dropdown-item bg-primary text-white text-center mt-3']").click();

    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }


}
