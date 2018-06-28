package com.app.configuration.rabbitMq;

import com.app.model.Enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderJson extends JsonParse implements Serializable {
    private Integer regNumberOrder;
    private List<String> wayPoints;
    private String regNumber;
    private List<String> drivers;
    private OrderStatus orderStatus;

}