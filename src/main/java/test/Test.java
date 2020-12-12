/**
 * http://surenpi.com
 */
package test;

import com.surenpi.autotest.utils.ThreadUtil;
import com.surenpi.autotest.webui.ui.Text;
import org.openqa.selenium.NoSuchElementException;
import test.page.Dashboard;
import test.page.DevOpsProjectPage;
import test.page.LoginPage;
import org.suren.autotest.web.framework.annotation.AutoApplication;
import org.suren.autotest.web.framework.settings.Phoenix;
import test.page.WorkspacePage;

import java.io.IOException;

/**
 * AutoTest框架的一个简单示例</br>
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
        Phoenix phoenix = new Phoenix(Test.class);
        phoenix.init();

        //获取Page类，然后获取对应的元素，再进行操作
        LoginPage page = phoenix.getPage(LoginPage.class);
        page.open();
        page.getUsername().fillValue("admin");
        page.getPassword().fillValue("P@88w0rd");

        page.getSubmit().click();

        Dashboard dashboard = phoenix.getPage(Dashboard.class);
        dashboard.getWorkspace().click();

        // going to devops project
        WorkspacePage workspacePage = phoenix.getPage(WorkspacePage.class);
//        workspacePage.getSearchWS().fillValue("good").performEnter();
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

}
