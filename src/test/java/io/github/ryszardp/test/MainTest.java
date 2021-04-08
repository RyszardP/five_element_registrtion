package io.github.ryszardp.test;

import io.github.ryszardp.model.User;
import io.github.ryszardp.page.MainPage;
import io.github.ryszardp.page.RegisterPage;
import io.github.ryszardp.service.UserCreator;
import org.testng.annotations.Test;

public class MainTest extends CommonConditions {
    @Test
    public void openAndClick() {
        User testUser = UserCreator.withCredentialsFromProperty();
        RegisterPage page = new MainPage(driver)
                .openPage()
                .clickToLogin()
                .clickToRegistration()
                .clickToEmailTab();
    }

}
