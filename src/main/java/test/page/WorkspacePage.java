package test.page;

import com.surenpi.autotest.webui.core.LocatorType;
import com.surenpi.autotest.webui.ui.Button;
import org.suren.autotest.web.framework.annotation.AutoLocator;
import org.suren.autotest.web.framework.annotation.AutoPage;
import org.suren.autotest.web.framework.selenium.WebPage;

@AutoPage
public class WorkspacePage extends WebPage {
    @AutoLocator(locator = LocatorType.BY_LINK_TEXT, value = "good", timeout = 9000)
    private Button targetWS;
    @AutoLocator(locator = LocatorType.BY_PARTIAL_LINK_TEXT, value = "DevOps 工程", timeout = 9000)
    private Button devopsProject;

    public Button getTargetWS() {
        return targetWS;
    }

    public void setTargetWS(Button targetWS) {
        this.targetWS = targetWS;
    }

    public Button getDevopsProject() {
        return devopsProject;
    }

    public void setDevopsProject(Button devopsProject) {
        this.devopsProject = devopsProject;
    }
}
