package it.intesys.bootcamp.customwriters.impl;


import it.intesys.bootcamp.writers.api.Writer;
import org.osgi.service.component.annotations.Component;

/**
 * @author ecostanzi
 */
@Component(
	immediate = true,
	property = {
		"service.ranking:Integer=100"
	},
	service = Writer.class
)
public class LiferayPoet implements Writer {

	@Override
	public String getName() {
		return "Liferay Poet";
	}

	@Override
	public String getQuote() {
		return "To Ext or not to Ext";
	}

}