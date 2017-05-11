package it.intesys.bootcamp.permissionchecker;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.permission.SimplePermissionChecker;

/**
 * @author ecostanzi
 */
public class BootcampPermissionChecker extends SimplePermissionChecker{

	private Log _LOG = LogFactoryUtil.getLog(BootcampPermissionChecker.class);

	@Override
	public boolean hasPermission(long groupId, String name, String primKey, String actionId) {
		_LOG.info("Hello there! I'm the custom permission checker!");
		return super.hasPermission(groupId, name, primKey, actionId);
	}
}