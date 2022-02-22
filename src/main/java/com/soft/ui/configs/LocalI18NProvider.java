package com.soft.ui.configs;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.vaadin.flow.i18n.I18NProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LocalI18NProvider implements I18NProvider{

    public static final String BUNDLE_PREFIX = "language.language";
    public final Locale LOCAL_GT = new Locale("es", "GT");
    private Logger log = LoggerFactory.getLogger(LocalI18NProvider.class);

    @Override
    public List<Locale> getProvidedLocales() {
        return Collections.unmodifiableList(
                Arrays.asList(LOCAL_GT));
    }

    @Override
    public String getTranslation(String key, Locale locale, Object... params) {
        if (key == null) {
            log.warn("Got lang request for key with null value!");
            return "";
        }

        final ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_PREFIX, locale);

        String value;
        try {
            value = bundle.getString(key);
        } catch (final MissingResourceException e) {
            log.warn("Missing resource");
            return "!" + locale.getLanguage() + ": " + key;
        }
        if (params.length > 0) {
            value = MessageFormat.format(value, params);
        }
        return value;
    }
    
}
