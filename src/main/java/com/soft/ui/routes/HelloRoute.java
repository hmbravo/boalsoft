package com.soft.ui.routes;

import com.soft.ui.views.HelloWorldView;
import com.soft.ui.views.MainLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Hello World")
@Route(value = "hello", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelloRoute extends Div 
    implements BeforeEnterObserver, AfterNavigationObserver{

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        HelloWorldView view = new HelloWorldView();
        add(view);
    }


}
