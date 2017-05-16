<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="${name}"/></b>
    says "<i><liferay-ui:message key="${quote}"/><i>"
    <br />
    <small>this portlet contains a reluctant reference to the Writer service, copy the cfg. file you find in
    configs/common/osgi/config to osgi/config to switch the reference at runtime</small>
</p>