package it.intesys.bootcamp.userimporter;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.security.ldap.exportimport.LDAPUserImporter;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.naming.directory.Attributes;
import javax.naming.ldap.LdapContext;

/**
 * @author ecostanzi
 */
@Component(
	immediate = true,
	service = LDAPUserImporter.class
)
public class BootcampLDAPUserImporter implements LDAPUserImporter {

	private Log _log = LogFactoryUtil.getLog(BootcampLDAPUserImporter.class);

	private LDAPUserImporter _defaultUserImporter;

	@Override
	public User importUser(long ldapServerId, long companyId, LdapContext ldapContext, Attributes attributes, String password) throws Exception {
		_log.info("Hey there! I'm the " + this.getClass().getName());
		return _defaultUserImporter.importUser(ldapServerId, companyId, ldapContext, attributes, password);
	}

	@Override
	public long getLastImportTime() throws Exception {
		_log.info("Hey there! I'm the " + this.getClass().getName());
		return _defaultUserImporter.getLastImportTime();
	}

	@Override
	public User importUser(long ldapServerId, long companyId, String emailAddress, String screenName) throws Exception {
		_log.info("Hey there! I'm the " + this.getClass().getName());
		return _defaultUserImporter.importUser(ldapServerId, companyId, emailAddress, screenName);
	}

	@Override
	public User importUser(long companyId, String emailAddress, String screenName) throws Exception {
		_log.info("Hey there! I'm the " + this.getClass().getName());
		return _defaultUserImporter.importUser(companyId, emailAddress, screenName);
	}

	@Override
	public User importUserByScreenName(long companyId, String screenName) throws Exception {
		_log.info("Hey there! I'm the " + this.getClass().getName());
		return _defaultUserImporter.importUserByScreenName(companyId, screenName);
	}

	@Override
	public void importUsers() throws Exception {
		_log.info("Hey there! I'm the " + this.getClass().getName());
		_defaultUserImporter.importUsers();
	}

	@Override
	public void importUsers(long companyId) throws Exception {
		_log.info("Hey there! I'm the " + this.getClass().getName());
		_defaultUserImporter.importUsers(companyId);
	}

	@Override
	public void importUsers(long ldapServerId, long companyId) throws Exception {
		_log.info("Hey there! I'm the " + this.getClass().getName());
		_defaultUserImporter.importUsers(ldapServerId, companyId);
	}

	@Reference(target = "(component.name=com.liferay.portal.security.ldap.internal.exportimport.LDAPUserImporterImpl)")
	public void setDefaultUserImporter(LDAPUserImporter defaultUserImporter) {
		this._defaultUserImporter = defaultUserImporter;
	}
}