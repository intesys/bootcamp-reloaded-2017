<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="${name}"/></b>
    says "<i><liferay-ui:message key="${quote}"/><i>"
    <br />
    <small>This is a portlet with a greedy reference to Writer service,
    deploy and undeploy bootcamp-writer-service-custom to see the difference</small>
</p>