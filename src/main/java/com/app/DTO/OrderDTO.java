package com.app.DTO;

import com.app.model.Enums.OrderStatus;
import com.app.model.Enums.OrderType;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private int regNumberOrderDTO;
    private OrderStatus statusDTO;
    private List<Integer> wayPointListDTO;
    private String regNumberWaggonDTO;
    private List<Integer> driversDTO;

}
