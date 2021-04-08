package io.github.ryszardp.test;

import io.github.ryszardp.model.User;
import io.github.ryszardp.page.MainPage;
import io.github.ryszardp.page.RegisterPage;
import io.github.ryszardp.service.UserCreator;
import org.testng.annotations.Test;

public class RegTest extends CommonConditions  {
    @Test
    public void openAndClick() {
        User testUser = UserCreator.withCredentialsFromProperty();
        RegisterPage page = new RegisterPage(driver)
                .openPage()
                .clickToEmailTab()
                .typeName(testUser)
                .typePassword(testUser)
                .typePasswordRepeat(testUser)
                .typeEmail(testUser)
                .selectSex(testUser)
                .clickRegister()
                ;
    }
}
