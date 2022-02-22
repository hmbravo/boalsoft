package com.soft.ui.configs;

import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ServiceListener implements VaadinServiceInitListener{

    private final Logger log = LoggerFactory.getLogger(ServiceListener.class);
    @Override
    public void serviceInit(ServiceInitEvent event) {
        event.getSource().addSessionInitListener(initEvent -> {
            log.debug("Session Init");
            log.debug("Set LocalErrorHandler for session {}",initEvent.toString());
            initEvent.getSession().setErrorHandler(new LocalErrorHandler());
        });

        event.getSource().addUIInitListener(initEvent -> { 
            log.debug("UI Init");
            initEvent.getUI().getReconnectDialogConfiguration().setDialogText("Conexión al servidor perdida, intentado reconectar..."); 
        });
        
    }    
}
