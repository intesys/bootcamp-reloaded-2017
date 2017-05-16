package it.intesys.bootcamp.userimporter;

import com.liferay.portal.security.ldap.exportimport.LDAPGroup;
import com.liferay.portal.security.ldap.exportimport.LDAPToPortalConverter;
import com.liferay.portal.security.ldap.exportimport.LDAPUser;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.naming.directory.Attributes;
import java.util.Properties;

/**
 * Created by ecostanzi on 16/05/2017.
 */
@Component(
        immediate = true,
        property = {
                "service.ranking:Integer=100"
        },
        service = LDAPToPortalConverter.class
)
public class BootcampLDAPToPortalConverter implements LDAPToPortalConverter {

    private LDAPToPortalConverter _defaultLdapToPortalConverter;

    @Override
    public LDAPGroup importLDAPGroup(long companyId, Attributes attributes, Properties groupMappings) throws Exception {
        return _defaultLdapToPortalConverter.importLDAPGroup(companyId, attributes, groupMappings);
    }

    @Override
    public LDAPUser importLDAPUser(long companyId, Attributes attributes, Properties userMappings, Properties userExpandoMappings, Properties contactMappings, Properties contactExpandoMappings, String password) throws Exception {
        return _defaultLdapToPortalConverter.importLDAPUser(companyId, attributes, userMappings, userExpandoMappings, contactMappings, contactExpandoMappings, password);
    }

    @Reference(target = "(component.name=com.liferay.portal.security.ldap.internal.exportimport.DefaultLDAPToPortalConverter)")
    public void setDefaultLdapToPortalConverter(LDAPToPortalConverter defaultLdapToPortalConverter) {
        this._defaultLdapToPortalConverter = defaultLdapToPortalConverter;
    }
}
