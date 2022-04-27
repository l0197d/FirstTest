package dataHermes2;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;


public class FioEmailNumber {


    public static SelenideElement lastName = $("[id ='upsert-form-lastname']"),
            firstName = $("[id ='upsert-form-firstname']"),
           middleName = $("[id ='upsert-form-middlename']"),
            eMail = $("[id ='selected-email']"),
            mainPhone = $("[id ='main-phone']"),
            additionallyPhone = $("[id ='additionally-phone']");

    public static void fastinput() {
        lastName.setValue("Тестов");
        firstName.setValue("Тест");
        middleName.setValue("Тестович");
        eMail.setValue("ilia.belalov@hermesrussia.ru");
        mainPhone.setValue("+79160105476");
        additionallyPhone.setValue("+79160105476");
    }
}
