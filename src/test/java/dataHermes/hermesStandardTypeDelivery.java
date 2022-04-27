package dataHermes;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class hermesStandardTypeDelivery {
    public static SelenideElement
            changeBU = $("[data-id='selected-bu']"),
            selectHermes = $("[id ='bs-select-1-0']"),
            typeDelivery = $("[data-id='type-delivery']"),
            standardOrder = $("[id ='bs-select-2-0']"),
            selectedDcDd = $("[data-id='selected-dc-dd']"),
            selectedDcDr = $("[data-id='selected-dc-dr']");
           //typeDeliveryVisible = $("[data-id='type-delivery']");

    public static void setTypeDeliveryHermes() {
        changeBU.click();
        selectHermes.find(byText("hermes")).click();
        typeDelivery.click();
        standardOrder.find(byText("Стандартное отправление")).click();
       // selectedDcDd.shouldHave(text("19"));
       //selectedDcDr.shouldHave(text("19"));
        //typeDeliveryVisible.shouldBe(visible);

    }


}

