package com.app.controllers.rest;

import com.app.service.SendJsonOrdersInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    SendJsonOrdersInterface sendJsonOrders;
    @RequestMapping(value = "/getJson")
    @ResponseBody
    public MessageSendResponse getSend(){
        sendJsonOrders.sendJson();
        return new MessageSendResponse("Send");
    }
}
