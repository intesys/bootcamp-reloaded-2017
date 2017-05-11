package it.intesys.bootcamp.servicewrapper;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.UserLocalServiceWrapper;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

/**
 * @author ecostanzi
 */
@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class BootcampServiceWrapperOverride extends UserLocalServiceWrapper{

	private Log _log = LogFactoryUtil.getLog(BootcampServiceWrapperOverride.class);

	public BootcampServiceWrapperOverride() {
		super(null);
	}

	@Override
	public User addUserWithWorkflow(long creatorUserId, long companyId, boolean autoPassword, String password1,
									String password2, boolean autoScreenName, String screenName, String emailAddress,
									long facebookId, String openId, Locale locale, String firstName, String middleName, String lastName, long prefixId, long suffixId, boolean male, int birthdayMonth, int birthdayDay, int birthdayYear, String jobTitle, long[] groupIds, long[] organizationIds, long[] roleIds, long[] userGroupIds, boolean sendEmail, ServiceContext serviceContext) throws PortalException {
		_log.info("Ok, ok, I'll let you create your account, just want you to know that the wrapper is here!");
		return super.addUserWithWorkflow(creatorUserId, companyId, autoPassword, password1, password2,
				autoScreenName, screenName, emailAddress, facebookId, openId, locale, firstName, middleName,
				lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
	}
}