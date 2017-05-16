package it.intesys.bootcamp.reluctant.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import it.intesys.bootcamp.writers.api.Writer;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

/**
 * @author ecostanzi
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Bootcamp Reluctant Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BootcampReluctantPortlet extends MVCPortlet {

	private Writer _writer;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		renderRequest.setAttribute("name", _writer.getName());
		renderRequest.setAttribute("quote", _writer.getQuote());
		super.doView(renderRequest, renderResponse);
	}

	@Reference(unbind = "-")
	public void setWriter(Writer writer) {
		this._writer = writer;
	}
}