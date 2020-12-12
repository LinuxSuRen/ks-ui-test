/**
 * http://surenpi.com
 */
package test.page;

import com.surenpi.autotest.webui.core.LocatorType;
import com.surenpi.autotest.webui.core.StrategyType;
import com.surenpi.autotest.webui.ui.Button;
import com.surenpi.autotest.webui.ui.Text;
import org.suren.autotest.web.framework.annotation.AutoLocator;
import org.suren.autotest.web.framework.annotation.AutoLocators;
import org.suren.autotest.web.framework.annotation.AutoPage;
import org.suren.autotest.web.framework.selenium.WebPage;

/**
 * 属性上必须添加注解@Autowired以及对应的getter和setter方法
 * @author suren
 * @date Jul 23, 2016 4:41:16 PM
 */
@AutoPage(url = "https://www.baidu.com/",
	maximize = false, startPage = true)
public class HomePage extends WebPage
{
	@AutoLocator(locator = LocatorType.BY_ID, value = "kw")
	private Text search;

	public Text getSearch() {
		return search;
	}

	public void setSearch(Text search) {
		this.search = search;
	}
}