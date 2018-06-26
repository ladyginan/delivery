package com.app.controllers.rest;

import com.app.service.SendJsonOrdersInterface;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    SendJsonOrdersInterface sendJsonOrders;
    @GetMapping(value = "/getJson")
    public @ResponseBody
    MessageSendResponse getSend(){
        sendJsonOrders.sendJson();
        return new MessageSendResponse("Send");
    }
}
