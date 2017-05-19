package it.intesys.bootcamp.account;


import com.liferay.login.web.internal.constants.LoginPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

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
public class BootcampCreateAccountMVCActionCommand implements MVCActionCommand {

	private Log _log = LogFactoryUtil.getLog(BootcampCreateAccountMVCActionCommand.class);

	private MVCActionCommand originalMVCCommand;

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		String userQuote = actionRequest.getParameter("ExpandoAttribute--" + "quote" + "--");

		if(userQuote == null || userQuote.length() == 0){
			SessionErrors.add(actionRequest,"missing-quote");
			return false;
		}

		_log.info(String.format("Hi there! The philosopher here says '%s'. Now I can create the account! :)", userQuote));
		return originalMVCCommand.processAction(actionRequest, actionResponse);
	}

	@Reference(target = "(component.name=com.liferay.login.web.internal.portlet.action.CreateAccountMVCActionCommand)")
	public void setOriginalMVCCommand(MVCActionCommand originalMVCCommand) {
		this.originalMVCCommand = originalMVCCommand;
	}
}