package dataHermes2;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PriceOfPackage {
    public static SelenideElement
            amountPaymentByTheRecipient = $("[id ='selected-amount-payment-by-the-recipient']"),
            insuranceValue = $("[id ='selected-insurance-value']"),
            selectedCostDelivery = $("[id='selected-cost-delivery']");

    public static void price() {
       // amountPaymentByTheRecipient.setValue("250.00");
        amountPaymentByTheRecipient.setValue("1.00");
       // insuranceValue.setValue("250.00");
        insuranceValue.setValue("1.00");
        selectedCostDelivery.shouldBe(visible);
    }
}
