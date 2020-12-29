package test.module;

import com.surenpi.autotest.utils.ThreadUtil;
import com.surenpi.autotest.webui.ui.AbstractElement;
import org.suren.autotest.web.framework.annotation.AutoField;
import org.suren.autotest.web.framework.annotation.AutoModule;
import org.suren.autotest.web.framework.annotation.AutoPage;
import org.suren.autotest.web.framework.annotation.AutoReporter;
import test.page.Dashboard;
import test.page.WorkspacePage;

@AutoModule(name = "工作空间")
@AutoPage
public class WorkspaceModule {
    @AutoField
    private WorkspacePage workspacePage;
    @AutoField
    private Dashboard dashboard;

    @AutoReporter
    public void create() {
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
        workspacePage.getTargetWS().getClickAble().click(new AbstractElement() {
            @Override
            public String getLinkText() {
                return wsName;
            }

            @Override
            public long getTimeOut() {
                return 3;
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
    }

    public WorkspacePage getWorkspacePage() {
        return workspacePage;
    }

    public void setWorkspacePage(WorkspacePage workspacePage) {
        this.workspacePage = workspacePage;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }
}
