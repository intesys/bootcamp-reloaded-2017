package it.intesys.bootcamp.permissionschecker;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.permission.SimplePermissionChecker;

/**
 * @author ecostanzi
 */
public class BootcampPermissionsChecker extends SimplePermissionChecker{

	private Log _LOG = LogFactoryUtil.getLog(BootcampPermissionsChecker.class);

	@Override
	public BootcampPermissionsChecker clone() {
		return new BootcampPermissionsChecker();
	}

	@Override
	public boolean hasPermission(long groupId, String name, String primKey, String actionId) {
		_LOG.debug("Hello there! I'm the custom permission checker!");
		return super.hasPermission(groupId, name, primKey, actionId);
	}

	@Override
	protected boolean hasPermission(String actionId) {
		_LOG.debug("Hello there! I'm the custom permission checker!");
		return super.hasPermission(actionId);
	}



}