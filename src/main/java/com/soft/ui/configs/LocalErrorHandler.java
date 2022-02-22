package com.soft.ui.configs;

import com.soft.shared.ExceptionWrapper;
import com.soft.ui.views.ThrowableNotificationView;
import com.vaadin.flow.server.ErrorEvent;
import com.vaadin.flow.server.ErrorHandler;

public class LocalErrorHandler implements ErrorHandler {

    @Override
    public void error(ErrorEvent event) {
        String message = "";
        if (event.getThrowable() instanceof ExceptionWrapper)
            message = ((ExceptionWrapper)event.getThrowable()).getUserFriendlyMessage();
        (new ThrowableNotificationView(message, event.getThrowable())).open();
    }
    
}
