/**
 * http://surenpi.com
 */
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

/**
 * 属性上必须添加注解@Autowired以及对应的getter和setter方法
 * @author suren
 * @date Jul 23, 2016 4:41:16 PM
 */
@AutoPage(maximize = false, startPage = true)
public class LoginPage extends WebPage
{
	@AutoLocator(locator = LocatorType.BY_ID, value = "username")
	@AutoData(value = "username field")
	private Text username;
	@AutoLocator(locator = LocatorType.BY_ID, value = "password")
	@AutoData(value = "password field")
	private Text password;
	@AutoLocator(locator = LocatorType.BY_CSS, value = "submit")
	@AutoData(value = "login button")
	private Button submit;

	public Text getUsername() {
		return username;
	}

	public void setUsername(Text username) {
		this.username = username;
	}

	public Text getPassword() {
		return password;
	}

	public void setPassword(Text password) {
		this.password = password;
	}

	public Button getSubmit() {
		return submit;
	}

	public void setSubmit(Button submit) {
		this.submit = submit;
	}
}