package test.page;

import com.surenpi.autotest.webui.core.LocatorType;
import com.surenpi.autotest.webui.core.StrategyType;
import com.surenpi.autotest.webui.ui.Button;
import com.surenpi.autotest.webui.ui.Text;
import org.suren.autotest.web.framework.annotation.AutoData;
import org.suren.autotest.web.framework.annotation.AutoLocator;
import org.suren.autotest.web.framework.annotation.AutoLocators;
import org.suren.autotest.web.framework.annotation.AutoPage;
import org.suren.autotest.web.framework.selenium.WebPage;

@AutoPage
public class PipelinePage extends WebPage {
    @AutoLocators(strategy = StrategyType.CYLE, locators = {
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[contains(text(),'Create')]", timeout = 9, lang = "en-US"),
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[contains(text(),'创建')]", timeout = 9)
    })
    @AutoData("create pipeline button")
    private Button createButton;

    @AutoLocators(strategy = StrategyType.CYLE, locators = {
            @AutoLocator(locator = LocatorType.BY_ID, value = "name")
    })
    @AutoData("pipeline name")
    private Text name;

    @AutoLocators(strategy = StrategyType.CYLE, locators = {
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[contains(text(),'Next')]", lang = "en-US"),
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[contains(text(),'下一步')]")
    })
    @AutoData("next button")
    private Button nextButton;

    @AutoLocators(strategy = StrategyType.CYLE, locators = {
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[@role='dialog' and @tabindex='-1']/descendant::div[contains(text(),'Create')]/parent::button", timeout = 9),
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[@role='dialog' and @tabindex='-1']/descendant::div[contains(text(),'创建')]/parent::button", timeout = 9)
    })
    @AutoData("save pipeline button")
    private Button saveButton;

    @AutoLocators(strategy = StrategyType.CYLE, locators = {
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[contains(text(),'Run Pipeline')]/parent::button", timeout = 3, lang = "en-US"),
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[contains(text(),'运行')]/parent::button", timeout = 3),
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[contains(text(),'Run')]/parent::button", timeout = 3, lang = "en-US")
    })
    @AutoData("run pipeline")
    private Button run;

    @AutoLocators(strategy = StrategyType.CYLE, locators = {
            @AutoLocator(locator = LocatorType.BY_LINK_TEXT, value = "活动", timeout = 3),
            @AutoLocator(locator = LocatorType.BY_LINK_TEXT, value = "Activity", timeout = 3, lang = "en-US")
    })
    @AutoData("activity button")
    private Button activityBut;

    public Button getCreateButton() {
        return createButton;
    }

    public void setCreateButton(Button createButton) {
        this.createButton = createButton;
    }

    public Text getName() {
        return name;
    }

    public void setName(Text name) {
        this.name = name;
    }

    public Button getNextButton() {
        return nextButton;
    }

    public void setNextButton(Button nextButton) {
        this.nextButton = nextButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(Button saveButton) {
        this.saveButton = saveButton;
    }

    public Button getRun() {
        return run;
    }

    public void setRun(Button run) {
        this.run = run;
    }

    public Button getActivityBut() {
        return activityBut;
    }

    public void setActivityBut(Button activityBut) {
        this.activityBut = activityBut;
    }
}
