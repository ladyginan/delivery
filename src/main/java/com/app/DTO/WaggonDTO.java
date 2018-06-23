package com.app.DTO;

import com.app.model.Enums.WaggonStatus;
import com.app.model.Waggon;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WaggonDTO {
    private int idWaggon;
    private String regNumber;
    private int shiftSize;
    private int capacity;
    private WaggonStatus status;
    private int mapId;

    public WaggonDTO(Waggon waggon) {
        this.idWaggon = waggon.getIdWaggon();
        this.regNumber = waggon.getRegNumber();
        this.shiftSize = waggon.getShiftSize();
        this.capacity = waggon.getCapacity();
        this.status = waggon.getStatus();
        this.mapId = waggon.getCity().getIdCity();
    }
}
