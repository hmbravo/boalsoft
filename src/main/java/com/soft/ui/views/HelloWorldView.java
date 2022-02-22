package com.soft.ui.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;
    private Logger log = LoggerFactory.getLogger(HelloWorldView.class);

    public HelloWorldView() {
        name = new TextField("Your name");
        sayHello = new Button("Say hello");
        sayHello.addClickListener(e -> {
            Notification.show(getTranslation("test"));
            log.debug("Prueba de log {}","hola hola hola");
        });

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);

        add(name, sayHello);
    }

}
