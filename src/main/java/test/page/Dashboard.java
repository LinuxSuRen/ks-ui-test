package test.page;

import com.surenpi.autotest.webui.core.LocatorType;
import com.surenpi.autotest.webui.core.StrategyType;
import com.surenpi.autotest.webui.ui.Button;
import org.suren.autotest.web.framework.annotation.AutoData;
import org.suren.autotest.web.framework.annotation.AutoLocator;
import org.suren.autotest.web.framework.annotation.AutoLocators;
import org.suren.autotest.web.framework.annotation.AutoPage;
import org.suren.autotest.web.framework.selenium.WebPage;

@AutoPage
public class Dashboard extends WebPage {
    @AutoLocators(strategy = StrategyType.CYLE, locators = {
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//p[contains(text(),'企业空间')]", timeout = 9),
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//p[contains(text(),'Workspaces')]", timeout = 9)
    })
    @AutoData(value = "open workspace button")
    private Button workspace;

    public Button getWorkspace() {
        return workspace;
    }

    public void setWorkspace(Button workspace) {
        this.workspace = workspace;
    }
}
