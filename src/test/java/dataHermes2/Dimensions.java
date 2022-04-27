package dataHermes2;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Dimensions {
    public static SelenideElement lengthPackage = $("[id ='dimension-length-input']"),
            widthPackage = $("[id ='dimension-width-input']"),
            heightPackage = $("[id ='dimension-height-input']"),
            shippingWeightPackage = $("[id ='selected-shipping-weight']");

    public static void dimension() {
        lengthPackage.setValue("25");
        widthPackage.setValue("15");
        heightPackage.setValue("30");
        shippingWeightPackage.setValue("150");
    }

}
