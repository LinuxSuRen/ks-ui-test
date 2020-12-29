package test.page;

import com.surenpi.autotest.datasource.DataSourceConstants;
import com.surenpi.autotest.webui.core.LocatorType;
import com.surenpi.autotest.webui.core.StrategyType;
import com.surenpi.autotest.webui.ui.Button;
import com.surenpi.autotest.webui.ui.Text;
import org.suren.autotest.web.framework.annotation.*;
import org.suren.autotest.web.framework.selenium.WebPage;

@AutoPage
@AutoDataSource(resource = "workspace.data.yml", type = DataSourceConstants.DS_TYPE_YAML)
public class WorkspacePage extends WebPage {
    @AutoLocator(locator = LocatorType.BY_LINK_TEXT, value = "good", timeout = 9)
    @AutoData(value = "target workspace button")
    private Button targetWS;
    @AutoLocators(strategy = StrategyType.CYLE, locators = {
            @AutoLocator(locator = LocatorType.BY_PARTIAL_LINK_TEXT, value = "DevOps 工程", timeout = 9),
            @AutoLocator(locator = LocatorType.BY_PARTIAL_LINK_TEXT, value = "DevOps Projects", timeout = 9)
    })
    @AutoData(value = "DevOps project button")
    private Button devopsProject;
    @AutoLocators(strategy = StrategyType.CYLE, locators = {
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[contains(text(),'创建')]/parent::button", timeout = 9),
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[contains(text(),'Create')]/parent::button", timeout = 9, lang = "en-US")
    })
    @AutoData("create workspace button")
    private Button createButton;

    @AutoLocators(strategy = StrategyType.CYLE, locators = {
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[@role='dialog' and @tabindex='-1']/descendant::div[contains(text(),'Create')]/parent::button", timeout = 9, lang = "en-US"),
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[@role='dialog' and @tabindex='-1']/descendant::div[contains(text(),'创建')]/parent::button", timeout = 9)
    })
    @AutoData("confirm create workspace button")
    private Button wsConfirmButton;

    @AutoLocator(locator = LocatorType.BY_ID, value = "metadata.name")
    @AutoData("workspache name filed")
    private Text wsName;
    @AutoLocators(strategy = StrategyType.CYLE, locators = {
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//input[@placeholder='请输入关键字进行查找']", timeout = 3),
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//input[@placeholder='请输入名称进行查找']", timeout = 3),
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//input[@placeholder='Search by name']", timeout = 3),
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//input[@placeholder='Search by keyword']", timeout = 3)
    })
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

    public Button getWsConfirmButton() {
        return wsConfirmButton;
    }

    public void setWsConfirmButton(Button wsConfirmButton) {
        this.wsConfirmButton = wsConfirmButton;
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
