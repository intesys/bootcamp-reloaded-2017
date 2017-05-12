package it.intesys.bootcamp.account;


import com.liferay.login.web.internal.constants.LoginPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * @author ecostanzi
 */
@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + LoginPortletKeys.FAST_LOGIN,
			"javax.portlet.name=" + LoginPortletKeys.LOGIN,
			"mvc.command.name=/login/create_account",
			"service.ranking:Integer=100"
	},
	service = MVCActionCommand.class
)
public class BootcampCreateAccountMVCActionCommand extends BaseMVCActionCommand {

	private Log _log = LogFactoryUtil.getLog(BootcampCreateAccountMVCActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String twitteraccount = actionRequest.getParameter("twitteraccount");
		_log.info("Hi there! We got the twitter account " +twitteraccount+". But no account will be created! :)");
	}
}