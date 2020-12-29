package test.module;

import com.surenpi.autotest.webui.ui.AbstractElement;
import org.suren.autotest.web.framework.annotation.AutoField;
import org.suren.autotest.web.framework.annotation.AutoModule;
import org.suren.autotest.web.framework.annotation.AutoPage;
import org.suren.autotest.web.framework.annotation.AutoReporter;
import test.page.ListComponent;
import test.page.PipelinePage;

@AutoModule(name = "流水线")
@AutoPage
public class PipelineModule {
    @AutoField
    private PipelinePage pipPage;
    @AutoField
    private ListComponent listComponent;

    @AutoReporter
    public void create(String pipName) {
        pipPage.getCreateButton().click();
        pipPage.getName().fillValue(pipName);
        pipPage.getNextButton().click();
        pipPage.getSaveButton().click();
    }

    @AutoReporter
    public void execute(String pipName) {
        listComponent.getSearch().fillValue(pipName).performEnter();
        chooseByName(pipName);
        pipPage.getActivityBut().click();
        pipPage.getRun().click();
    }

    public void chooseByName(String name) {
        pipPage.getSaveButton().getClickAble().click(new AbstractElement() {
            @Override
            public String getLinkText() {
                return name;
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
    }

    // getter and setter
    public PipelinePage getPipPage() {
        return pipPage;
    }

    public void setPipPage(PipelinePage pipPage) {
        this.pipPage = pipPage;
    }

    public ListComponent getListComponent() {
        return listComponent;
    }

    public void setListComponent(ListComponent listComponent) {
        this.listComponent = listComponent;
    }
}
