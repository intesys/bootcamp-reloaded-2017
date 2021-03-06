package it.intesys.bootcamp.greedy.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import it.intesys.bootcamp.writers.api.Writer;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import java.io.IOException;

/**
 * @author ecostanzi
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Bootcamp Greedy Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BootcampGreedyPortlet extends MVCPortlet {

	private Writer _writer;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		renderRequest.setAttribute("name", _writer.getName());
		renderRequest.setAttribute("quote", _writer.getQuote());
		super.doView(renderRequest, renderResponse);
	}

	@Reference(unbind = "-", policyOption = ReferencePolicyOption.GREEDY)
	public void setWriter(Writer writer) {
		this._writer = writer;
	}
}