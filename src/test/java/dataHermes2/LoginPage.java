package dataHermes2;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {


    public static   SelenideElement loginField = $("[id='login-input']"),
                                     passwordField = $("[name='Password'] "),
                                    loginButton = $("[type='submit']");


public static void login(String user, String pwd){
    loginField.setValue("b2c");
    passwordField.setValue("EL0no8ie");
    loginButton.click();
}
}
