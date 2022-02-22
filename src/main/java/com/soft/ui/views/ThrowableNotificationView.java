package com.soft.ui.views;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class ThrowableNotificationView extends Notification{
    
    public ThrowableNotificationView(String message, Throwable throwable){
        addThemeVariants(NotificationVariant.LUMO_ERROR);

        Icon icon = VaadinIcon.WARNING.create();
        Div info = new Div(new Text(message));

        Button retryBtn = new Button(
            "",
            VaadinIcon.ANGLE_DOUBLE_DOWN.create(),
            clickEvent -> openStackTrace(throwable));
            retryBtn.getStyle().set("margin", "0 0 0 var(--lumo-space-l)");

        HorizontalLayout layout = new HorizontalLayout(
            icon, info, retryBtn,
            createCloseBtn());
        layout.setAlignItems(FlexComponent.Alignment.CENTER);

        add(layout);
    }

    private void openStackTrace(Throwable e){
        close();
        Dialog d = new Dialog();
        Html h = new Html("<span>"+stackTraceToString(e)+"</span>");
        d.add(h);
        d.open();
    }

    private String stackTraceToString(Throwable e) {
		String cause = e.getLocalizedMessage()+"<br/>";
		for (int i = 0; i < e.getStackTrace().length; i++){
            cause += e.getStackTrace()[i].toString()+"<br/>";
        }
		return cause;
	}
    private Button createCloseBtn() {
        Button closeBtn = new Button(
                VaadinIcon.CLOSE_SMALL.create(),
                clickEvent -> close());
        closeBtn.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
    
        return closeBtn;
    }
}
