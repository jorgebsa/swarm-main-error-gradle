package com.example;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.inject.Inject;

import static com.example.MyView.VIEW_NAME;

/**
 * @author jorgesa
 * @since 7/29/16.
 */
@CDIView(VIEW_NAME)
public class MyView extends VerticalLayout implements View {

    static final String VIEW_NAME = "myview";

    @Inject
    private MyBean bean;

    @Override
    public void enter( ViewChangeListener.ViewChangeEvent event ) {
        addComponent( new Label( bean.getText() ) );
    }
}
