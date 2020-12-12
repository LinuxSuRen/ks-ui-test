package test.page;

import com.surenpi.autotest.webui.core.LocatorType;
import com.surenpi.autotest.webui.ui.Button;
import com.surenpi.autotest.webui.ui.Text;
import org.suren.autotest.web.framework.annotation.AutoData;
import org.suren.autotest.web.framework.annotation.AutoLocator;
import org.suren.autotest.web.framework.annotation.AutoPage;
import org.suren.autotest.web.framework.selenium.WebPage;

@AutoPage
public class WorkspacePage extends WebPage {
    @AutoLocator(locator = LocatorType.BY_LINK_TEXT, value = "good", timeout = 9)
    @AutoData(value = "target workspace button")
    private Button targetWS;
    @AutoLocator(locator = LocatorType.BY_PARTIAL_LINK_TEXT, value = "DevOps 工程", timeout = 9)
    @AutoData(value = "DevOps project button")
    private Button devopsProject;
    @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[text(),'创建']")
    @AutoData("create workspace button")
    private Button createButton;
    @AutoLocator(locator = LocatorType.BY_ID, value = "metadata.name")
    @AutoData("workspache name filed")
    private Text wsName;
    @AutoLocator(locator = LocatorType.BY_XPATH, value = "//input[@placeholder='请输入关键字进行查找']", timeout = 3)
    @AutoData("search workspace")
    private Text searchWS;

    // paging buttons
    @AutoLocator(locator = LocatorType.BY_XPATH, value = "//button/span/svg[contains(@class, 'qicon-next')]")
    @AutoData("next page")
    private Button nextButton;

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

    public Button getNextButton() {
        return nextButton;
    }

    public void setNextButton(Button nextButton) {
        this.nextButton = nextButton;
    }

    public Button getCreateButton() {
        return createButton;
    }

    public void setCreateButton(Button createButton) {
        this.createButton = createButton;
    }

    public Text getWsName() {
        return wsName;
    }

    public void setWsName(Text wsName) {
        this.wsName = wsName;
    }

    public Text getSearchWS() {
        return searchWS;
    }

    public void setSearchWS(Text searchWS) {
        this.searchWS = searchWS;
    }
}
