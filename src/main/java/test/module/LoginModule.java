package test.module;


import org.apache.commons.lang.StringUtils;
import org.suren.autotest.web.framework.annotation.AutoField;
import org.suren.autotest.web.framework.annotation.AutoModule;
import org.suren.autotest.web.framework.annotation.AutoPage;
import org.suren.autotest.web.framework.annotation.AutoReporter;
import test.page.LoginPage;

@AutoModule(name = "登录")
@AutoPage
public class LoginModule {
    @AutoField
    private LoginPage loginPage;

    @AutoReporter
    public void login() {
        loginPage.open();

        loginPage.getUsername().fillValue();
        loginPage.getPassword().fillValue();
        loginPage.getSubmit().click();

        loginPage.urlNotContains("login");
        if (StringUtils.contains(loginPage.getCurrentUrl(), "login")) {
            throw new RuntimeException("login failed");
        }
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(LoginPage loginPage) {
        this.loginPage = loginPage;
    }
}
