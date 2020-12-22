package test.runner;

import com.surenpi.autotest.utils.ThreadUtil;
import com.surenpi.autotest.webui.ui.AbstractElement;
import org.suren.autotest.web.framework.annotation.AutoField;
import org.suren.autotest.web.framework.annotation.AutoPage;
import org.suren.autotest.web.framework.runner.Runner;
import test.module.PipelineModule;
import test.page.Dashboard;
import test.page.DevOpsProjectPage;
import test.page.LoginPage;
import test.page.WorkspacePage;

//@AutoRunner
@AutoPage
public class Pipeline implements Runner {
    @AutoField
    private LoginPage loginPage;
    @AutoField
    private Dashboard dashboard;
    @AutoField
    private WorkspacePage workspacePage;
    @AutoField
    private DevOpsProjectPage devopsProject;
    @AutoField
    private PipelineModule pipelineModule;

    public void createPipeline() {
        loginPage.open();

        loginPage.getUsername().fillValue();//entryParam.username);
        loginPage.getPassword().fillValue();//entryParam.password);
        loginPage.getSubmit().click();

        dashboard.urlNotContains("login");
        if (!"https://console.kubesphere.io/access/workspaces".equals(dashboard.getCurrentUrl())) {
            dashboard.getWorkspace().click();
        }

        // going to devops project
        String wsName = "ws-" + System.currentTimeMillis();
        workspacePage.getCreateButton().click();
        workspacePage.getWsName().fillValue(wsName);
        workspacePage.getWsConfirmButton().click();

        workspacePage.getSearchWS().fillValue(wsName).performEnter();
        ThreadUtil.silentSleep(3000);
        workspacePage.getTargetWS().getClickAble().click(new AbstractElement() {
            @Override
            public String getLinkText() {
                return wsName;
            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public boolean isHidden() {
                return false;
            }
        });
        workspacePage.getDevopsProject().click();

        // create devops project
        String devopsProjectName = "test-" + System.currentTimeMillis();
        devopsProject.getNewProject().click();
        devopsProject.getProjectName().fillValue(devopsProjectName);
        devopsProject.getSubmit().click();

        // search target project
        devopsProject.getSearch().fillValue(devopsProjectName).performEnter();
        ThreadUtil.silentSleep(3000);
        devopsProject.getNewProject().getClickAble().click(new AbstractElement() {
            @Override
            public String getLinkText() {
                return devopsProjectName;
            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public boolean isHidden() {
                return false;
            }
        });

        String pipName = "pip-" + System.currentTimeMillis();
        pipelineModule.create(pipName);
        pipelineModule.execute(pipName);

        ThreadUtil.silentSleep(2000);
    }
}
