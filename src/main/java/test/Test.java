/**
 * http://surenpi.com
 */
package test;

import com.surenpi.autotest.utils.ThreadUtil;
import test.page.HomePage;
import org.suren.autotest.web.framework.annotation.AutoApplication;
import org.suren.autotest.web.framework.settings.Phoenix;

import java.io.IOException;

/**
 * AutoTest框架的一个简单示例</br>
 * @author suren
 * @date 2016年12月13日 下午7:52:06
 */
@AutoApplication
public class Test {

    /**
     * 入口函数
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Phoenix phoenix = new Phoenix(Test.class);
        phoenix.init();

        //获取Page类，然后获取对应的元素，再进行操作
        HomePage page = phoenix.getPage(HomePage.class);
        page.open();
        page.getSearch().fillValue("demo").performEnter();

        ThreadUtil.silentSleep(3000);

        phoenix.close(); //关闭框架
    }

}
