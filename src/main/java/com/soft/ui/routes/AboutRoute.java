package com.soft.ui.routes;

import com.soft.ui.views.AboutView;
import com.soft.ui.views.MainLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("About")
@Route(value = "about", layout = MainLayout.class)
public class AboutRoute extends Div 
    implements BeforeEnterObserver, AfterNavigationObserver{

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        AboutView view = new AboutView();
        add(view);
    }
    
}
