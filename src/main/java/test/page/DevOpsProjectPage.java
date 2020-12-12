package test.page;

import com.surenpi.autotest.webui.core.LocatorType;
import com.surenpi.autotest.webui.ui.Button;
import com.surenpi.autotest.webui.ui.Text;
import org.suren.autotest.web.framework.annotation.AutoData;
import org.suren.autotest.web.framework.annotation.AutoLocator;
import org.suren.autotest.web.framework.annotation.AutoPage;
import org.suren.autotest.web.framework.selenium.WebPage;

@AutoPage
public class DevOpsProjectPage extends WebPage {
    @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[text()='创建']", timeout = 3)
    @AutoData(value = "new DevOps Project button")
    private Button newProject;
    @AutoLocator(locator = LocatorType.BY_ID, value = "metadata.generateName", timeout = 3)
    @AutoData(value = "project name")
    private Text projectName;
    @AutoLocator(locator = LocatorType.BY_XPATH, value = "//div[contains(text(),'确定')]", timeout = 3)
    @AutoData(value = "submit DevOps project creating button")
    private Button submit;

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
}
