package Jira.steps;

import io.qameta.allure.Step;

import static Jira.pageElements.LoginPage.loginInput;
import static Jira.pageElements.LoginPage.passwordInput;

public class AuthenticationSteps {
    @Step("Ввод логина и пароля")
    public static void authentication(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
    }
}
