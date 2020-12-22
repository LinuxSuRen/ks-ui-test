package test;

import org.suren.autotest.web.framework.annotation.AutoApplication;
import org.suren.autotest.web.framework.runner.RunnerStartup;

import java.io.IOException;

@AutoApplication
public class Entry {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 1; i++) {
            try (RunnerStartup runner = new RunnerStartup()) {
                runner.start(Entry.class);
            }
        }
    }
}
