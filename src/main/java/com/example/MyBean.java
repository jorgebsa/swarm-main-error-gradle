package com.example;

import javax.enterprise.context.RequestScoped;

/**
 * @author jorgesa
 * @since 7/29/16.
 */
@RequestScoped
public class MyBean {

    private String text = "Request scoped bean has been successfully injected";

    public String getText() {
        return text;
    }
}
