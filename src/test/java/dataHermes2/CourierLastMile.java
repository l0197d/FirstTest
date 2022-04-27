package dataHermes2;

import com.codeborne.selenide.SelenideElement;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class CourierLastMile {

        public static SelenideElement
                zipCode = $("[id ='selected-delivery-zipcode']"),
                cityDestination = $(withText("Выберите значение")),
                city = $("[id='bs-select-5-99']"),
                address = $("[id='selected-delivery-address']"),
                apartmentAddress = $("[id='selected-delivery-apartment-address']"),
                additionalAddress = $("[id='selected-delivery-additional-address']"),
                selectedDayOfTime = $("[data-id='selected-day-of-time']"),
                dayOfTimeSelection = $("[id='bs-select-6-0']"),
                selectDay = $("[id='date-d']"),
                daySelection = $("[data-handler='selectDay']");


        public static void courierLastMileLocation() {

            zipCode.setValue("368121");
            cityDestination.click();
            city.click();
            address.setValue("улица Ленина, 86");
            apartmentAddress.setValue("23");
            additionalAddress.setValue("2301В, 5 этаж");
            selectedDayOfTime.click();
            dayOfTimeSelection.click();
            selectDay.click();
            daySelection.click();

            Calendar calendar = new GregorianCalendar();
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
            $(byText(String.valueOf(dayOfMonth + 5))).click();


        }
    }


