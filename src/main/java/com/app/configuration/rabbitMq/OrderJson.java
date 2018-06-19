package com.app.configuration.rabbitMq;

import java.io.Serializable;

public class OrderJson implements Serializable {
    private String text;

    public OrderJson(){

    }

    public OrderJson(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "OrderJson{" +
                "text='" + text + '\'' +
                '}';
    }
}