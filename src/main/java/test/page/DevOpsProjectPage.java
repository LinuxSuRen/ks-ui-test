package test.page;

import com.surenpi.autotest.webui.action.KeyBoardAble;
import com.surenpi.autotest.webui.core.LocatorType;
import com.surenpi.autotest.webui.core.StrategyType;
import com.surenpi.autotest.webui.ui.Button;
import com.surenpi.autotest.webui.ui.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.suren.autotest.web.framework.annotation.AutoData;
import org.suren.autotest.web.framework.annotation.AutoLocator;
import org.suren.autotest.web.framework.annotation.AutoLocators;
import org.suren.autotest.web.framework.annotation.AutoPage;
import org.suren.autotest.web.framework.selenium.WebPage;

@AutoPage
public class DevOpsProjectPage extends WebPage {
    @AutoLocators(strategy = StrategyType.CYLE, locators = {
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[text()='创建']", timeout = 3),
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[text()='Create']", timeout = 3)
    })
    @AutoData(value = "new DevOps Project button")
    private Button newProject;
    @AutoLocator(locator = LocatorType.BY_ID, value = "metadata.generateName", timeout = 3)
    @AutoData(value = "project name")
    private Text projectName;
    @AutoLocators(strategy = StrategyType.CYLE, locators = {
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[contains(text(),'确定')]", timeout = 3),
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[contains(text(),'OK')]", timeout = 3)
    })
    @AutoData(value = "submit DevOps project creating button")
    private Button submit;

    // list
    @AutoLocators(strategy = StrategyType.CYLE, locators = {
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//input[@placeholder='请输入关键字进行查找']", timeout = 3),
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//input[@placeholder='Search by keyword']", timeout = 3)
    })
    @AutoData("DevOps projects search")
    private Text search;

    @AutoData("target DevOps project")
    private Button targetDevOpsProject;

    // paging buttons
    @AutoLocator(locator = LocatorType.BY_CSS, value = "qicon-next")
    @AutoData("next page")
    private Button nextButton;

    public Button getNewProject() {
        return newProject;
    }

    public void setNewProject(Button newProject) {
        this.newProject = newProject;
    }

    public Text getProjectName() {
        return projectName;
    }

    public void setProjectName(Text projectName) {
        this.projectName = projectName;
    }

    public Button getSubmit() {
        return submit;
    }

    public void setSubmit(Button submit) {
        this.submit = submit;
    }

    public Button getNextButton() {
        return nextButton;
    }

    public void setNextButton(Button nextButton) {
        this.nextButton = nextButton;
    }

    public Text getSearch() {
        return search;
    }

    public void setSearch(Text search) {
        this.search = search;
    }

    public Button getTargetDevOpsProject() {
        return targetDevOpsProject;
    }

    public void setTargetDevOpsProject(Button targetDevOpsProject) {
        this.targetDevOpsProject = targetDevOpsProject;
    }
}
