package FunctionalTest;

import com.codeborne.selenide.logevents.SelenideLogger;
import dataHermes2.LoginPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class ImportParcel {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure",new AllureSelenide());

    }
    @Test
        //TestID=11517 (ЛК Functional positive test) Импортировать отправление
    void ImportParcelFile() throws InterruptedException {
        //holdBrowserOpen = true;
        open("http://my.hermesrussia.ru/preadvice/upsert");
        LoginPage.login("b2c", "EL0no8ie");
        open("https://my.hermesrussia.ru/parcel/import");
        $("[id ='files']").uploadFile(new File("src/test/resources/ImportFile.csv")); // добавить файл
        $("[class ='btn btn-sm btn-primary']").click(); // Создать файл
    }
}
