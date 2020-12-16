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
public class ListComponent extends WebPage {
    @AutoLocators(strategy = StrategyType.CYLE, locators = {
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[contains(text(),'Create')]", timeout = 9),
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[contains(text(),'创建')]", timeout = 9)
    })
    @AutoData("create button")
    private Button createButton;
    @AutoLocators(strategy = StrategyType.CYLE, locators = {
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//input[@placeholder='请输入关键字进行查找']", timeout = 3),
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//input[@placeholder='Search by name']", timeout = 3),
            @AutoLocator(locator = LocatorType.BY_XPATH, value = "//input[@placeholder='Search by keyword']", timeout = 3)
    })
    @AutoData("search field")
    private Text search;

    public Button getCreateButton() {
        return createButton;
    }

    public void setCreateButton(Button createButton) {
        this.createButton = createButton;
    }

    public Text getSearch() {
        return search;
    }

    public void setSearch(Text search) {
        this.search = search;
    }
}
