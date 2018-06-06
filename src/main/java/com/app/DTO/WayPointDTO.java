package com.app.DTO;

import com.app.model.Enums.OrderType;
import com.app.model.WayPoint;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WayPointDTO {
    private String cityDTO;
    private int cargoNumber;
    private OrderType orderTypeDTO;

    public WayPointDTO(WayPoint wayPoint){
        this.cityDTO = wayPoint.getCity().getCity();
        this.cargoNumber = wayPoint.getCargo().getIdCargo();
        this.orderTypeDTO = wayPoint.getOrderType();
    }
}
