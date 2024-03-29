package Jira.tests;

import Jira.Utils.ConfProperties;
import Jira.hooks.WebHooks;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Jira.pageElements.BoardPage.btnStatusBar;
import static Jira.steps.BoardSteps.*;
import static Jira.steps.NavigationSteps.*;

@DisplayName("Тесты Jira (https://edujira.ifellow.ru)")
public class RunTest extends WebHooks {
    @Epic(value = "Информация с Jira")
    @Feature(value = "Получение информации с Jira")
    @Step("Получение количества заведенных задач")
    @DisplayName("Получение количества заведенных задач в Jira")
    @Test
    @Description("Получение количества заведенных задач в Jira")
    public void transitionalToTheTasks() {
        openAllTasks();
        changeViewList();
        checkNumTaskAll();
        changeView();
    }

    @Epic(value = "Информация с Jira")
    @Feature(value = "Проверка теста с Jira")
    @DisplayName("Проверка производит сравнение полученных данных задачи с сайта и входных данных")
    @Step("Проверка теста на принадлежность к версии")
    @Test
    @Description("Проверка теста на принадлежность к версии")
    public void checkVersionTest() {
        String nameTest = ConfProperties.getProperty("nameTest");
        String versionTest = ConfProperties.getProperty("versionTest");
        openAllTasks();
        searchTest(nameTest);
        checkTest(nameTest, versionTest);

    }

    @Epic(value = "Заведение и работа с задачей в Jira")
    @Feature(value = "Заведение задачи в Jira")
    @DisplayName("Заведение задачи в системе Jira")
    @Test
    @Description("Добавление на сайт новой задачи с описанием из входных параметров")
    @Step("Заведение задачи в системе Jira")
    public void createBug() {
        String theme = ConfProperties.getProperty("themeBug");
        String description = ConfProperties.getProperty("descriptionBug");
        String environment = ConfProperties.getProperty("environmentBug");
        createBugNavigation(theme, description, environment);
        checkCreateBug(theme, description, environment);
    }

    @Epic(value = "Заведение и работа с задачей в Jira")
    @Feature(value = "Перевод и проверка задачи в различные статусы")
    @DisplayName("Перевод и проверка задачи в различные статусы")
    @Test
    @Description("Перевод и проверка в различные статусы последней заведенной задачи в Jira")
    @Step("Перевод и проверка в различные статусы последней заведенной задачи в Jira")
    public void statusChange() {
        openMyBug();
        checkStatusBag("СДЕЛАТЬ");
        btnStatusBar("В работе").click();
        checkStatusBag("В РАБОТЕ");
        selectExecuted();
        checkStatusBag("РЕШЕННЫЕ");
        selectConfirm();
        checkStatusBag("ГОТОВО");
    }


}
