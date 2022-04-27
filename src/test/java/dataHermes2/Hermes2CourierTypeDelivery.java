package dataHermes2;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Hermes2CourierTypeDelivery {
    public static SelenideElement
            changeBU = $("[data-id='selected-bu']"),
            selectHermes2 = $("[id ='bs-select-1-1']"),
            typeDelivery = $("[data-id='type-delivery']"),
            standardOrder = $("[id ='bs-select-2-1']"),
            selectedDcDd = $("[data-id='selected-dc-dd']"),
            selectedDcDr = $("[data-id='selected-dc-dr']"),
            typeDeliveryVisible = $("[data-id='type-delivery']");

    public static void setTypeDelivery() {
        changeBU.click();
        selectHermes2.find(byText("hermes2")).click();
        typeDelivery.click();
        standardOrder.find(byText("Курьерское отправление")).click();
        selectedDcDd.shouldHave(text("19")).shouldBe(visible);
        selectedDcDr.shouldHave(text("19"));
        typeDeliveryVisible.shouldBe(visible);

    }


}
