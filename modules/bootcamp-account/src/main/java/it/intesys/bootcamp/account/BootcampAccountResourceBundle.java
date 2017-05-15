package it.intesys.bootcamp.account;

import com.liferay.portal.kernel.language.UTF8Control;

import java.util.Enumeration;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

/**
 * Created by niccolo on 16/05/2017.
 */
@Component(
        immediate = true, property = {"language.id=en_US"},
        service = ResourceBundle.class
)
public class BootcampAccountResourceBundle extends ResourceBundle {

    private final ResourceBundle _resourceBundle = ResourceBundle.getBundle(
            "content.Language", UTF8Control.INSTANCE);

    @Override
    public Enumeration<String> getKeys() {
        return _resourceBundle.getKeys();
    }

    @Override
    protected Object handleGetObject(String key) {
        return _resourceBundle.getObject(key);
    }

}
