package com.app.configuration.rabbitMq;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WaggonJson extends JsonParse implements Serializable {
    private int allWaggonsCount;
    private int freeWaggonsCount;
    private int busyWaggonsCount;
    private int workingWaggonCount;
    private int brokenWaggonCount;
}
