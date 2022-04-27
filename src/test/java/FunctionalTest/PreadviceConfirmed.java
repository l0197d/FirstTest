package FunctionalTest;

import com.codeborne.selenide.Configuration;
import dataHermes2.LoginPage;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PreadviceConfirmed {

    @Test
        //TestID=11??? (ЛК Functional positive test) Импортировать отправление
    void ParcelConfirmedCheckAllButtonUI() throws InterruptedException {
        Configuration.holdBrowserOpen = true;
        open("http://my.hermesrussia.ru/preadvice/upsert");
        LoginPage.login("b2c", "EL0no8ie");
        open("https://my.hermesrussia.ru/parcel/confirmed");

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

        $("[aria-owns ='bs-select-2']").click();
        $("[id ='bs-select-2-0']").shouldBe(visible).click();

}
}
