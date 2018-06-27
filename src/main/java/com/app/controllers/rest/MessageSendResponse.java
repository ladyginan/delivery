package com.app.controllers.rest;

import com.app.configuration.rabbitMq.JsonParse;
import lombok.*;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MessageSendResponse extends JsonParse implements Serializable {
    private String answer;

}
