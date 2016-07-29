package com.example;


import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.inject.Inject;

@CDIUI( "" )
@Theme( "valo" )
@Title( "My example" )
@Widgetset( value = "com.example.MyWidgetset" )
public class MyUI extends UI {

    @Inject
    private CDIViewProvider cdiViewProvider;

    private VerticalLayout root = new VerticalLayout();

    @Override
    protected void init( VaadinRequest request ) {
        setContent( root );

        Navigator navigator = new Navigator( this, root );
        navigator.addProvider( cdiViewProvider );
        setNavigator( navigator );
        navigator.navigateTo( MyView.VIEW_NAME );
    }
}