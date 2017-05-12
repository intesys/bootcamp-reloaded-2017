package it.intesys.bootcamp.account;


import com.liferay.login.web.internal.constants.LoginPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

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

	private MVCActionCommand originalMVCCommand;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String userQuote = actionRequest.getParameter("ExpandoAttribute--" + "quote" + "--");
		if(userQuote == null || userQuote.length() == 0){
			//the quote hasn't been inserted with a ui:custom-attribute, therefore we look for the simple "quote" attribute
			// FIXME: 12/05/2017 this way no expando attribute will be set into the user properties
			userQuote = actionRequest.getParameter("quote");
		}
		if(userQuote == null || userQuote.length() == 0){
			SessionErrors.add(actionRequest,"missing-quote");
			return;
		}

		_log.info(String.format("Hi there! The philosopher here says '%s'. Now I can create the account! :)", userQuote));
		originalMVCCommand.processAction(actionRequest, actionResponse);
	}

	/**
	 * https://dev.liferay.com/develop/tutorials/-/knowledge_base/7-0/overriding-mvc-commands
	 */
	@Reference(target = "(component.name=com.liferay.login.web.internal.portlet.action.CreateAccountMVCActionCommand)")
	public void setOriginalMVCCommand(MVCActionCommand originalMVCCommand) {
		this.originalMVCCommand = originalMVCCommand;
	}
}