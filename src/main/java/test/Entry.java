package test;

import com.surenpi.autotest.report.excel.annotation.EnableHtmlReport;
import org.suren.autotest.web.framework.annotation.AutoApplication;
import org.suren.autotest.web.framework.runner.RunnerStartup;

import java.io.IOException;

@AutoApplication(name = "KubeSphere UI test")
@EnableHtmlReport
public class Entry {
    public static void main(String[] args) throws IOException {
        try (RunnerStartup runner = new RunnerStartup()) {
            runner.start(Entry.class);
        }
    }
}
