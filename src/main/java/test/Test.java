package test;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.surenpi.autotest.utils.ThreadUtil;
import test.page.Dashboard;
import test.page.DevOpsProjectPage;
import test.page.LoginPage;
import org.suren.autotest.web.framework.annotation.AutoApplication;
import org.suren.autotest.web.framework.settings.Phoenix;
import test.page.WorkspacePage;

import java.io.IOException;

/**
 * UI test for Kubesphere</br>
 * @author suren
 * @date 2016年12月13日 下午7:52:06
 */
@AutoApplication
public class Test {

    /**
     * 入口函数
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // receive parameters from CLI
        EntryParam entryParam = new Test().getEntryParam(args);

        Phoenix phoenix = new Phoenix(Test.class);
        phoenix.init();

        //获取Page类，然后获取对应的元素，再进行操作
        LoginPage loginPage = phoenix.getPage(LoginPage.class);
        loginPage.setUrl(entryParam.url);
        loginPage.open();
        loginPage.getUsername().fillValue(entryParam.username);
        loginPage.getPassword().fillValue(entryParam.password);
        loginPage.getSubmit().click();

        Dashboard dashboard = phoenix.getPage(Dashboard.class);
        dashboard.getWorkspace().click();

        // going to devops project
        WorkspacePage workspacePage = phoenix.getPage(WorkspacePage.class);
        workspacePage.getTargetWS().click();
        workspacePage.getDevopsProject().click();

        // create devops project
        DevOpsProjectPage devopsProject = phoenix.getPage(DevOpsProjectPage.class);
        devopsProject.getNewProject().click();
        devopsProject.getProjectName().fillValue("test-" + System.currentTimeMillis());
        devopsProject.getSubmit().click();

        ThreadUtil.silentSleep(3000);

        phoenix.close(); //关闭框架
    }

    private EntryParam getEntryParam(String []args) {
        EntryParam entryParam = new EntryParam();
        JCommander.Builder builder = JCommander.newBuilder();
        JCommander commander = builder.addObject(entryParam).build();
        commander.parse(args);
        return entryParam;
    }
}

class EntryParam {
    @Parameter(names = "-url", description = "kubesphere url", required = true)
    public String url;
    @Parameter(names = "-username", description = "username")
    public String username = "admin";
    @Parameter(names = "-password", description = "password", password = true)
    public String password = "P@88w0rd";
}
