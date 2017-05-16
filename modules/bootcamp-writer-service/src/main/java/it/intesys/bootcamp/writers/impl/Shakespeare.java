package it.intesys.bootcamp.writers.impl;


import it.intesys.bootcamp.writers.api.Writer;
import org.osgi.service.component.annotations.Component;

/**
 * @author ecostanzi
 */
@Component(
	immediate = true,
	property = {
		// TODO enter required service properties
	},
	service = Writer.class
)
public class Shakespeare implements Writer {


	@Override
	public String getName() {
		return "Shakespeare";
	}

	@Override
	public String getQuote() {
		return "To be or not to be";
	}

}