package com.app.DTO;

import com.app.model.Enums.OrderStatus;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderDTO {
    Integer regNumberOrder;
    List<Integer> waypoints;
    Integer waggonId;
    List<Integer> drivers;
    OrderStatus orderStatus;
}
