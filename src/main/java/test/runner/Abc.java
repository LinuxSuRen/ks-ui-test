package test.runner;

import org.suren.autotest.web.framework.annotation.AutoPage;
import org.suren.autotest.web.framework.runner.Runner;

@AutoPage
public class Abc implements Runner {
    public void test() {
        throw new RuntimeException("test");
    }
}
