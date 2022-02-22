package com.soft.ui.routes;

import javax.servlet.http.HttpServletResponse;

import com.soft.ui.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.HasErrorParameter;
import com.vaadin.flow.router.ParentLayout;

@Tag(Tag.DIV)
@ParentLayout(MainLayout.class)
public class ExceptionCatchRoute extends Component
    implements HasErrorParameter<Exception>{

    @Override
    public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<Exception> parameter) {
        getElement().setText(
                    getTranslation("navigation.error.title")
                    +"'" + event.getLocation().getPath() + "'");
        return HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
    }
    
}
