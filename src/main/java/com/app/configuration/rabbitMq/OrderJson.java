package com.app.configuration.rabbitMq;

import com.app.model.Enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
@Setter
@Getter
public class OrderJson implements Serializable {

    private Integer regNumberOrder;
    private List<String> wayPoints;
    private Integer waggonId;
    private List<String> drivers;
    private OrderStatus orderStatus;

    public OrderJson(){

    }

    public OrderJson(Integer regNumberOrder, List<String> wayPoints, Integer waggonId, List<String> drivers, OrderStatus orderStatus) {
        this.regNumberOrder = regNumberOrder;
        this.wayPoints = wayPoints;
        this.waggonId = waggonId;
        this.drivers = drivers;
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "OrderJson{" +
                "regNumberOrder=" + regNumberOrder +
                ", wayPoints=" + wayPoints +
                ", waggonId=" + waggonId +
                ", drivers=" + drivers +
                ", orderStatus=" + orderStatus +
                '}';
    }

    public String toJson() {
        String result = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            result = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}